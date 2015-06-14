package friedman.DiningPhilosopher;

public class Fork {
	
	boolean inUse = false;
	
	public boolean isUsed(){
		return inUse;
	}
	
	public void switchUsed(){
		inUse = false;
	}
	
	
}
