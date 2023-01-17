package carpenterTycoon;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Factory {

// constants
	
	
// attributes
	private LinkedList<productionJob> productionJobs = new LinkedList<productionJob>();
	private float inflation;
	
// flow control
	
	
// inner class to store production jobs
	private class productionJob {
		Player player;
		EProduct product;
		int amount;
		int productionTimeLeft;
		
		public productionJob(Player player, EProduct product, int amount, int productionTimeLeft) {
			this.player=player;
			this.product=product;
			this.amount=amount;
			this.productionTimeLeft=productionTimeLeft;
		}
	}
	
// Constructor
	public Factory() {
		
	}
	
// TICK
	void tick(float inflation) {
		this.inflation=inflation;
		
		// check produktion list for finished orders
		LinkedList<productionJob> deleteList= new LinkedList<productionJob>();
		for (productionJob p:productionJobs) {
			p.productionTimeLeft=p.productionTimeLeft-1;
			if (p.productionTimeLeft==0) {
				deleteList.add(p);
				p.player.addProduct(p.product,p.amount);
				//System.out.println(p.player.getNickname()+" -->"+p.amount+" "+p.product.toString()+" READY!");
			}
		}
		productionJobs.removeAll(deleteList);
	}
	
	
// start production job
	//  0=ok, putting job in production queue
	// -1= not enough money!
	// -2=order+product orders in queue is higher than 10 products
	// -3=wood, nails or screws missing
		public synchronized int startProduction(Player player, EProduct product, int amount) {

			// not enough money?
			if (player.getMoney()<product.getProductionCost()*amount*inflation) {return -1;}
			

			// maximum 10 products in production allowed
			int tmp=0;
			for (productionJob p:productionJobs) {
				if (p.player.nickname.equals(player.nickname)) {
					tmp+=p.amount;
				}
				if ((amount+tmp)>10) {return -2;}
			}
			
			// screws, nails, wood missing?
			HashMap<EProduct,Integer> productsavailable = player.getMyProducts();
			
			if (product==EProduct.CHAIR) {
				if (productsavailable.get(EProduct.WOOD)<2) {return -2;}  // 2 wood needed
				if (productsavailable.get(EProduct.NAIL)<1) {return -2;}  // 1 nail needed
				player.removeProduct(EProduct.WOOD,2);
				player.removeProduct(EProduct.NAIL,1);
			}
			
			if (product==EProduct.TABLE) {
				if (productsavailable.get(EProduct.WOOD)<4) {return -2;}  // 4 wood needed
				if (productsavailable.get(EProduct.NAIL)<2) {return -2;}  // 2 nail needed
				if (productsavailable.get(EProduct.SCREW)<1) {return -2;} // 1 screws needed
				player.removeProduct(EProduct.WOOD,4);
				player.removeProduct(EProduct.NAIL,2);
				player.removeProduct(EProduct.SCREW,1);
			}
			
			if (product==EProduct.WARDROBE) {
				if (productsavailable.get(EProduct.WOOD)<8) {return -2;}  // 8 wood needed
				if (productsavailable.get(EProduct.NAIL)<3) {return -2;}  // 3 nail needed
				if (productsavailable.get(EProduct.SCREW)<2) {return -2;} // 2 screws needed
				player.removeProduct(EProduct.WOOD,8);
				player.removeProduct(EProduct.NAIL,3);
				player.removeProduct(EProduct.SCREW,2);
			}
			player.removeMoney(product.getProductionCost()*amount*inflation);
			productionJobs.add(new productionJob(player,product,amount,amount*product.getProductionTime()));
			//System.out.println("AMOUNT:"+amount+" TIMELEFT:"+amount*product.getProductionTime());
			return 0;
	}
		
		
} // end class