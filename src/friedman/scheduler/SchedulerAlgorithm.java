package friedman.scheduler;

import java.util.List;

public interface SchedulerAlgorithm {
	
	//send in list, sends back which one should be next, 
	FakeProcess getNextProcess(List<FakeProcess> list);

	
	//only cares about the priority of the next one
	//delicate delegate pattern - can change scheduler at any time
}
