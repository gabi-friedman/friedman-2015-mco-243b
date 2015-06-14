package friedman.scheduler;

import java.util.Comparator;

public class FakeProcessLengthComparator implements Comparator<FakeProcess> {

	@Override
	public int compare(FakeProcess fp1, FakeProcess fp2) {
		return (int) (fp1.getLength() - fp2.getLength());
	}

	

}
