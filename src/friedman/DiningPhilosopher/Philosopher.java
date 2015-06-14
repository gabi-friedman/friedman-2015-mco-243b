package friedman.DiningPhilosopher;

import java.util.Random;

public class Philosopher extends Thread{
	
	private final static Random r = new Random();
	
	String name;
	Fork a;
	Fork b;
	
	public Philosopher(String name, Fork a, Fork b){
		this.name = name;
		this.a = a;
		this.b = b;
	}
	
	Random x = new Random();
	private boolean eating;
	private boolean thinking;
	
	public boolean isEating(){
		return eating;
	}
	public boolean isThinking(){
		return thinking;
	}
	
	public void eating() throws InterruptedException{
		synchronized (a){
			synchronized (b){
				sleepRange();
			}
		}
	}
	private void sleepRange() {
		try {
			Thread.sleep(r.nextInt(1500)+500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void think(){
		sleepRange();
	}
	

}
