package carpenterTycoon;

import java.util.HashMap;
import java.util.Iterator;

public abstract class Player implements Comparable<Player>  {

// attributes of player	
	String nickname="noname";   // nickname
	Float money=100f;                     // amount of current money
	private HashMap<EProduct,Integer> products = new HashMap<EProduct,Integer>(); // products in portfolio
	public final Factory factory;       // the factory where all the goods will be produced
	public final ISell marketPlace; // this is the place where you can sell goods
	float inflation=1; 
	
// flow control
	private boolean readyForProduction=true;
	
	
// constructor	
	public Player(Factory factory, ISell marketPlace) {
		products.put(EProduct.WOOD,0);
		products.put(EProduct.NAIL,0);
		products.put(EProduct.SCREW,0);
		products.put(EProduct.CHAIR,0);
		products.put(EProduct.TABLE,0);
		products.put(EProduct.WARDROBE,0);
		this.factory=factory;
		this.marketPlace=marketPlace;
	}
	

// one simulationStep is over - force to implement logic in subclass	
	protected abstract void tick();
	
// setInflation	
	void setInflation(float inflation) {
		this.inflation=inflation;
	}
	
// getInflation
	 protected float getInflation() {
		return inflation;
	}
	
// Tax office!
	void tax(int percent) {
		int val=0;
		// calculate value of all products in store
		Iterator it=products.keySet().iterator();
		while (it.hasNext()) {
			EProduct tmp=(EProduct) it.next();
			val+=tmp.getWorth()*products.get(tmp);
		}
		
		// set new account balance
		money=money*((100f-percent)/100f);
	}
	
// set Nickname	
	protected void setNickname(String nickname) {
		this.nickname=nickname;
	}
	
	
// return a copy of all products in OWN list (no way "return products" ;-))
	protected HashMap<EProduct,Integer> getMyProducts() {
		HashMap<EProduct,Integer> productsCopy = new HashMap<EProduct,Integer>();
		Iterator it=products.keySet().iterator();
		while (it.hasNext()) {
			EProduct tmp=(EProduct) it.next();
			productsCopy.put(tmp,products.get(tmp));
		}
		return productsCopy;
	}
	
	
// return current amount of money
	public float getMoney() {
		return money;
	}
	

// remove money
	void removeMoney(float amount) {
		this.money-=amount;
	}
	
// remove Product 
	void removeProduct(EProduct p,int amount) {
		products.put(p, products.get(p)-amount);
	}

	
// add Product 
	void addProduct(EProduct p,int amount) {
			products.put(p, products.get(p)+amount);
	}

	
	public String getNickname() {
		return nickname;
	}
	
// print out player infos	
	@Override
	public String toString() {
		
		String tmp=nickname+"--> MONEY:"+getWorth()+" (";
		Iterator it=products.keySet().iterator();
		while (it.hasNext()) {
			EProduct ep=(EProduct) it.next();
			tmp+=ep.toString()+":"+products.get(ep)+" ";
		}
		return tmp+")";
	}


// logic to determine best player 
	@Override
	public int compareTo(Player other) {
		
		return -this.getWorth().compareTo(other.getWorth());
	}
	
// get money + value of goods
	public Float getWorth() { 
		int val=0;
		// calculate value of all products in store
		Iterator it=products.keySet().iterator();
		while (it.hasNext()) {
			EProduct tmp=(EProduct) it.next();
			val+=tmp.getWorth()*products.get(tmp)*inflation;
		}
		
		// set new account balance
		return val+money;
	}
}
