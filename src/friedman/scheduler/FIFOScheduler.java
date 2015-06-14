package friedman.scheduler;

import java.util.List;

public class FIFOScheduler implements SchedulerAlgorithm{	
	
	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		FakeProcess fp = null;
		if(!list.isEmpty()){
			fp = list.get(0);
		}
		return fp;
	}

}

/*
 * pg 344 - FIFO scheduler
 * 
 * 8.7.1 First-In-First-Out (FIFO) Scheduling
	Perhaps the simplest scheduling algorithm is first-in-first-out (FIFO), also called
	first-come-first-served (FCFS) (Fig. 8.2). Processes are dispatched according to
	their arrival time at the ready queue. FIFO is nonpreemptive — once a process has a
	processor, the process runs to completion. FIFO is fair in that it schedules processes
	according to their arrival times, so all processes are treated equally, but somewhat
	unfair because long processes make short processes wait, and unimportant processes
	make important processes wait. FIFO is not useful in scheduling interactive
	processes because it cannot guarantee short response times.
	FIFO is rarely used as a master scheme in today's systems, but it is often found
	within other schemes. For example, many scheduling schemes dispatch processes
	according to priority, but processes with the same priority are dispatched in FIFO
	order.
 */
