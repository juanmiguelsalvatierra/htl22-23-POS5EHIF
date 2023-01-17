package carpenterTycoon;

public interface ISell {
	public boolean sell(Player player, EProduct product,int amount);
	public boolean buy(Player player, EProduct product,int amount);
}
