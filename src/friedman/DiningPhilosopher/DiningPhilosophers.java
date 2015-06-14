package friedman.DiningPhilosopher;

public class DiningPhilosophers {
	
	Philosopher[] ps = new Philosopher[5];
	Fork[] f = new Fork[5];
	
	for(int i = 0; i < ps.length; i++){
		ps[i] = new Philosopher();
	}

}
