package friedman.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityTimeScheduler implements SchedulerAlgorithm{

	private ArrayList<FakeProcess> last25;
	private int round;


	public PriorityTimeScheduler(){
		this.last25 = new ArrayList<FakeProcess>();
		this.round = 0;
	}

	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		FakeProcess fp = null;
		if(!list.isEmpty()){
			fp = list.get(0);

			//if not in last25 increase priority by 1
			if(round > 50){
				for(FakeProcess p : list){
					if(!last25.contains(p)){
						p.setAdjustedPriority(p.getAdjustedPriority()+1);
					}
				}
			}

			Collections.sort(list, new FakeProcessLengthComparator());

			if(last25.size() >= 25){
				last25.remove(24);
			}

			if(!last25.contains(list.get(0))){
				last25.add(list.get(0));
			}

			round++;
		}
		return fp;
	}
}

/*
 * pg 360 - based on priority, whenever a process hasnt executed in a while increase its priority
 * 
 */
