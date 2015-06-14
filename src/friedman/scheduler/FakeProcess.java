package friedman.scheduler;

public class FakeProcess {
	
	private final int MIN_PRIORITY = 0;
	private final int NORM_PRIORITY = 5;
	private final int MAX_PRIORITY = 10;
	
	private String name;
	private int priority;
	private int length;
	private boolean stillRunning;
	private int progress;
	@SuppressWarnings("unused")
	private int adjustedPriority;

	public FakeProcess(String name, int priority, int length){
		this.name = name;
		this.priority = priority;
		this.length = length;
		
		//amount of time left needed to run
		this.progress = length;
		this.stillRunning = true;
		this.adjustedPriority = priority;
	}

	
	
	public String getName() {
		return name;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int getAdjustedPriority() {
		return priority;
	}
	
	public void setAdjustedPriority(int adjustedPriority) {
		this.adjustedPriority = adjustedPriority;
	}
	
	public double getLength() {
		return length;
	}
	
	public int getMIN_PRIORITY() {
		return MIN_PRIORITY;
	}

	public int getNORM_PRIORITY() {
		return NORM_PRIORITY;
	}

	public int getMAX_PRIORITY() {
		return MAX_PRIORITY;
	}

	public boolean isStillRunning() {
		return stillRunning;
	}

	public void run(int quantum) throws InterruptedException {
		System.out.println("Running process " + name);
		System.out.println("	length: " + length);
		System.out.println("	priority: " + priority);
		System.out.println("	still running?: " + stillRunning);
		if(progress > quantum){
			Thread.sleep(quantum);
			progress -= quantum;
		}
		else if(progress <= quantum){
			Thread.sleep(progress);
			stillRunning = false;
		}
	}
	
	
}
