package friedman.scheduler;

import java.util.Collections;
import java.util.List;

public class ShortestFirstScheduler implements SchedulerAlgorithm{	
	
	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		FakeProcess fp = null;
		
		if(!list.isEmpty()){
			Collections.sort(list, new FakeProcessLengthComparator());
			fp = list.get(0);
		}
		return fp;
	}

}

/*
 * pg 348 - shortest process first scheduler
 * 
 * 8.7.3 Shortest-Process-First (SPF) Scheduling
  	Shortest-process-first (SPF) is a nonpreemptive scheduling discipline in which the
	scheduler selects the waiting process with the smallest estimated run-time-to-completion.
	SPF reduces average waiting time over FIFO.14 The waiting times, however, have a larger 
	variance (i.e., are more unpredictable) than FIFO, especially for large processes.

	SPF favors short processes at the expense of longer ones. Many designers
	advocate that the shorter the process, the better the service it should receive. Other
	designers disagree, because this strategy does not incorporate priorities (as measured
	by the importance of a process). Interactive processes, in particular, tend to
	be "shorter" than processor-bound processes, so this discipline would seem to still
	provide good interactive response times. The problem is that it is nonpreemptive,
	so, in general, arriving interactive processes will not receive prompt service.
	SPF selects processes for service in a manner ensuring the next one will complete
	and leave the system as soon as possible. This tends to reduce the number of
	waiting processes and also the number of processes waiting behind large processes.
	As a result, SPF can minimize the average waiting time of processes as they pass
	through the system.
	A key problem with SPF is that it requires precise knowledge of how long a
	process will run, and this information usually is not available. Therefore, SPF must
	rely on user- or system-supplied run-time estimates. In production environments
	where the same processes run regularly, the system may be able to maintain reasonable
	runtime heuristics. In development environments, however, the user rarely
	knows how long a process will execute.
	Another problem with relying on user process duration estimates is that users
	may supply small (perhaps inaccurate) estimates so that the system will give their
	programs higher priority. However, the scheduler can be designed to remove this
	temptation. For example, if a process runs longer than estimated, the system could
	terminate it and reduce the priority of that user's other processes, even invoking
	penalties. A second method is to run the process for the estimated time plus a small
	percentage extra, then "shelve" it (i.e., preserve it in its current form) so that the
	system may restart it at a later time.15
	SPF derives from a discipline called short job first (SJF), which might have
	worked well scheduling jobs in factories but clearly is inappropriate for low-level
	scheduling in operating systems. SPF, like FIFO, is nonpreemptive and thus not
	suitable for environments in which reasonable response times must be guaranteed.
 */

