package friedman.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CombinedMain {

	public static void main(String[] args) throws InterruptedException{
		Random r = new Random();
		long fifoTime;
		long shortestTime;
		long priorityTime;
		long startTime1;
		long endTime1;
		long startTime2;
		long endTime2;
		long startTime3;
		long endTime3;
		FakeProcess fp;

		List<FakeProcess> procList1 = new ArrayList<FakeProcess>();
		List<FakeProcess> procList2 = new ArrayList<FakeProcess>();
		List<FakeProcess> procList3 = new ArrayList<FakeProcess>();

		int priority = 0;
		int x;
		for(int i = 0; i < 100; i++){
			x = r.nextInt(25);
			fp = new FakeProcess("Process "+i+"",priority,x);
			procList1.add(fp);
			procList2.add(fp);
			procList3.add(fp);
			if(priority < 10){
				priority++;
			}
			else{
				priority = 0;
			}
		}

		FIFOScheduler sched1 = new FIFOScheduler();
		Scheduler s1 = new Scheduler(sched1, procList1);

		System.out.println("Starting the FIFO Scheduler:");
		startTime1 = System.currentTimeMillis();
		s1.run();
		endTime1 = System.currentTimeMillis();
		fifoTime = endTime1 - startTime1;

		ShortestFirstScheduler sched2 = new ShortestFirstScheduler();
		Scheduler s2 = new Scheduler(sched2, procList2);

		System.out.println("Starting the Shortest First Scheduler:");
		startTime2 = System.currentTimeMillis();
		s2.run();
		endTime2 = System.currentTimeMillis();
		shortestTime = endTime2 - startTime2;

		PriorityTimeScheduler sched3 = new PriorityTimeScheduler();
		Scheduler s3 = new Scheduler(sched3, procList3);

		System.out.println("Starting the Priority Scheduler:");
		startTime3 = System.currentTimeMillis();
		s3.run();
		endTime3 = System.currentTimeMillis();
		priorityTime = endTime3 - startTime3;

		System.out.println("FIFO Scheduler "+ fifoTime);
		System.out.println("Shortest First Scheduler "+ shortestTime);
		System.out.println("Priority Scheduler "+ priorityTime);

	}

}
