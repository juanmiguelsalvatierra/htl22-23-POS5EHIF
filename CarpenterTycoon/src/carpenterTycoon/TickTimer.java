package carpenterTycoon;

class TickTimer implements Runnable {
	
	private int tickTime;
	private int simulationSteps;
	private final Simulation sim;
	
	public TickTimer(int tickTime,int simulationSteps, Simulation sim) {
		this.tickTime=tickTime;
		this.sim=sim;
		this.simulationSteps=simulationSteps;
	}
	
	
// Event to Simulation --> one SimulationStep is over	
	@Override
	public void run() {
		while (simulationSteps>0) { 
			try {
				Thread.sleep(tickTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sim.tick();
			simulationSteps--;
		}
		sim.stop();
	}	
}
