package player;
import java.util.HashMap;

import carpenterTycoon.EProduct;
import carpenterTycoon.Factory;
import carpenterTycoon.ISell;
import carpenterTycoon.Player;


public class DummyPlayer extends Player {
	
	


	public DummyPlayer(Factory factory, ISell marketPlace) {
		super(factory, marketPlace);
		setNickname("Dummy");
	}



// one Simulation step is over+ info about actual inflation rate - so what to do now?	
	@Override
	protected void tick() {
		
		// HINT: with getMyProducts() you will get a HashMap with all products in you portfolio
		HashMap<EProduct,Integer> products = getMyProducts();
		
		// HINT: with getMoney() you will get your current amount of money
		float money=getMoney();
		
		
		// HINT: startProduction return:
		//  0=ok, putting job in production queue
		// -1= not enough money!
		// -2= this order + orders in queue would be higher than 10 products
		// -3=wood, nails or screws missing
		//int erg=factory.startProduction(this,EProduct.WOOD,2);
		//System.out.println(toString()+": starts WoodProduction --> result:"+erg);
		
		
		// HINT: sell goods on market
		// returns true when ok, false when player does not have enough goods
		//boolean sold=marketPlace.sell(this,EProduct.WOOD,3);
		//System.out.println(toString()+": sells Wood --> result:"+sold);
		
		
		// HINT: buy goods from market
		// returns true when ok, false when market does not have enough goods
		//boolean bought=marketPlace.buy(this,EProduct.WOOD,2);
		//System.out.println(toString()+": bought Wood --> result:"+bought);
		
		// HINT: get Inflation
		float inflation=getInflation();
	}



	
	

}
