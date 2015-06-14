package friedman.scheduler;

import java.util.Comparator;

public class FakeProcessPriorityComparator implements Comparator<FakeProcess> {

	@Override
	public int compare(FakeProcess fp1, FakeProcess fp2) {
		return fp1.getPriority() - fp2.getPriority();
	}

}
