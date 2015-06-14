package friedman.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FIFOmain {

	public static void main(String[] args) throws InterruptedException{


		//pg 344 - FIFO scheduler
		//pg 348 - shortest process first scheduler
		//pg 360 - based on priority, whenever a process hasnt executed in a while increase its priority

		//write a program to test all these
		//run the program for 100 iterations of the run method 
		//see how many processes u complete
		//which one is more efficient

		Random r = new Random();

		List<FakeProcess> procList = new ArrayList<FakeProcess>();

		int priority = 0;
		for(int i = 0; i < 100; i++){
			procList.add(new FakeProcess("Process "+i+"",priority,r.nextInt(25)));
			if(priority < 10){
				priority++;
			}
			else{
				priority = 0;
			}
		}

		FIFOScheduler sched = new FIFOScheduler();
		Scheduler s1 = new Scheduler(sched, procList);

		System.out.println("Starting the FIFO Scheduler:");
		long startTime = System.currentTimeMillis();
		s1.run();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
}
