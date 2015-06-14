package friedman.scheduler;

import java.util.List;

public class Scheduler {
	//scheduler holds list of processes & algorithm

	private static final int QUANTUM = 10;

	List<FakeProcess> list;
	SchedulerAlgorithm alg;

	public Scheduler(SchedulerAlgorithm alg, List<FakeProcess> list){
		this.alg = alg;
		this.list = list;
	}

	public void run() throws InterruptedException{
		
		System.out.println("Starting the FIFO Scheduler:");
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		long t = (endTime-startTime);
		
		while(t < 180*1000){
			//get the next one
			FakeProcess proc = alg.getNextProcess(list);
			if(alg.getNextProcess(list) != null){
				proc = alg.getNextProcess(list);
				list.remove(proc);
			}
			else{
				break;
			}
			//run for x amt of time
			proc.run(QUANTUM);

			//check if still needs to b run
			if(proc.isStillRunning()){
				list.add(proc);
			}
		}
	}

}
