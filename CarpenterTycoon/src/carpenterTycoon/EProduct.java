package carpenterTycoon;

public enum EProduct {
		                                     
	WOOD(2,1,1), NAIL(6,3,2), SCREW(8,4,3), CHAIR(30,7,10), TABLE(48,10,7), WARDROBE(90,8,15);
	
	private int worth;
	private int productionTime;
	private float productionCost;

	private EProduct(int worth, int productionTime, float productionCost) {
		this.worth=worth;
		this.productionTime=productionTime;
		this.productionCost=productionCost;
	}
	
	public int getWorth() {
		return worth;
	}
	
	public int getProductionTime() {
		return productionTime;
	}
	
	public float getProductionCost() {
		return productionCost;
	}
	
}
