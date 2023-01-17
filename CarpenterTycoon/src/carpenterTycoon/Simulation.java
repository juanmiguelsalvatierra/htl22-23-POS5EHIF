package carpenterTycoon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import player.DummyPlayer;
import player.RandomPlayer;



class Simulation implements ISell  {
// constants
	private final static int ticktime=10;
	private final static int simulationSteps=200;
	
// attributes
	private Factory factory;
	private LinkedList<Player> playerList = new LinkedList<Player>();   // List with all Players
	private HashMap<EProduct,Integer> marketproducts = new HashMap<EProduct,Integer>(); // List of all products on free market
	private Thread tickTimer; // Thread for TickTimer
	private float inflation=1; // inflation based on value of all products on market  

	
// flow control
	private int stepCounter=0;             // needed to stop simulation
    private float lastSeasonAmount=0;      // needed for calculation of inflation
	
	
// Constructor	
	public Simulation() {
		// Init list of all products on free market
			marketproducts.put(EProduct.WOOD,0);
			marketproducts.put(EProduct.NAIL,0);
			marketproducts.put(EProduct.SCREW,0);
			marketproducts.put(EProduct.CHAIR,0);
			marketproducts.put(EProduct.TABLE,0);
			marketproducts.put(EProduct.WARDROBE,0);
		
		// create factory
			factory = new Factory();
			
		// create all players with own Logic
			playerList.add(new DummyPlayer(factory,this));
			for (int i=0;i<30;i++) {
				playerList.add(new RandomPlayer(factory,this));
			}
			
			
				
		
		// start Simulation by starting the tickTimer
			tickTimer = new Thread(new TickTimer(ticktime,simulationSteps,this));
			tickTimer.start();
	}

	

	
// Information to players: one simulationStep is over, or simulation is over	
	void tick() {
		
		float amountSeason=0f;
		
		// count next round till end
		stepCounter++;
		System.out.println("Round:"+stepCounter);
		
		// calculate inflation
		if (stepCounter%10==0) {
			System.out.println();
			Iterator it=marketproducts.keySet().iterator();
			while (it.hasNext()) {
				EProduct tmp=(EProduct) it.next();
				amountSeason+=tmp.getWorth()*marketproducts.get(tmp);
				System.out.print(tmp.toString()+"["+marketproducts.get(tmp)+"] ");
			}  
		  if (lastSeasonAmount==0) {  // do not calculate in first season
			  lastSeasonAmount=amountSeason;
		  } else {
			// compare values of products in store at beginning of season / end of seasion
			  inflation=lastSeasonAmount/amountSeason;
			  if (inflation<0.8f) {inflation=0.8f;} else
		      if (inflation>1.2) {inflation=1.2f;}
			  System.out.println("NEW INFLATION:"+inflation);
			  lastSeasonAmount=amountSeason;
			  
		  }
			
		}
		
	   // round controll
		factory.tick(inflation);
		for (Player p:playerList) {
			p.setInflation(inflation); // inform player about new inflation
			p.tick();  // tell all players next round has started
			p.tax(4);  // 1% tax on all Products
		}
	}

	// called by TickTimer, stop simulation
	void stop() {
		playerList.sort(null);
		int place=0;
		System.out.println("--------------- RESULT -------------");
		for (Player p:playerList) {  // print out ranking
			place++;
			System.out.println("Place "+place+":"+p.toString());	
		}
	}
	


	@Override
	// player sells goods on market
	// returns true when ok, false when player does not have enough goods
	public synchronized boolean sell(Player player, EProduct product, int amount) {
		HashMap<EProduct,Integer> products = player.getMyProducts();
		if (products.get(product)>=amount) {  // player has enough products to sell
			marketproducts.put(product,marketproducts.get(product)+amount); // add products to market
			player.removeProduct(product, amount);                          // remove products from player
			player.money+=product.getWorth()*amount*inflation;              // give money to player
			return true;
		}
		return false;
	}




	@Override
	// player buys goods from market
	// returns true when ok, false when market does not have enough goods or player does not have enough money
	public synchronized boolean buy(Player player, EProduct product, int amount) {
		
		// check player has enough money
		if (player.money<=product.getWorth()*amount*inflation) {
			return false;
		}
		
		if (marketproducts.get(product)>=amount) {  // market has enough products to sell
			marketproducts.put(product,marketproducts.get(product)-amount); // remove products from market
			player.addProduct(product, amount);                             // remove products from player
			player.money-=product.getWorth()*amount*inflation;              // remove money from player
			return true;
		}
		return false;
	}
	
	
	
	
}
