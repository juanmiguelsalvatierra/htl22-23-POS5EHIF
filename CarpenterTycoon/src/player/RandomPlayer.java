package player;

import java.util.HashMap;
import java.util.Random;

import carpenterTycoon.EProduct;
import carpenterTycoon.Factory;
import carpenterTycoon.ISell;
import carpenterTycoon.Player;

public class RandomPlayer extends Player {
	public static Random rn=new Random();
	public static int c=0;
	
	public RandomPlayer(Factory factory, ISell marketPlace) {
		super(factory, marketPlace);
		setNickname("RandomPlayer"+c);
		c++;
	}

	@Override
	protected void tick() {
		//WOOD(2,1,1), NAIL(6,3,2), SCREW(8,4,3), CHAIR(30,7,10), TABLE(48,10,7), WARDROBE(90,8,15);
		EProduct e=EProduct.values()[rn.nextInt(6)];
		
		int a=rn.nextInt(9)+1;
		
		if (factory.startProduction(this,e,a)==0) {
			//System.out.println(toString()+": PRODUCE "+e.toString()+"("+a+")");
		} else
		if (marketPlace.sell(this,e,a)) {
			//System.out.println(toString()+": SELL "+e.toString()+"("+a+")");
		} else 
		if (marketPlace.buy(this,e,a*2)) {
			//System.out.println(toString()+": BUY "+e.toString()+"("+a+")");
		}
	}
	
	
	

}
