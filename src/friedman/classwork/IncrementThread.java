package friedman.classwork;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class IncrementThread extends Thread {

	static int num;
	private CountDownLatch latch;
	static Object lock = new Object(); //used lock, if one obj is accesing this code nt else can

	static Semaphore s = new Semaphore(1,true);
	
	private AtomicInteger ai = new AtomicInteger(0);

	//increments int 1mil times
	//int is a global variable

	public IncrementThread(CountDownLatch latch, AtomicInteger ai) {
		this.latch = latch;
		this.ai = ai;
	}

	@Override
	public void run() {
		for(int i = 0; i < 1000000; i++){
			//APPROACH A
			
			//synchronized(lock){num = num + 1;}
			//only 1 thread can b in this block at a time

			//APPROACH B
			/*try {
				s.acquire();

				num++;
				s.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			//APPROACH C
			ai.incrementAndGet();
			
		}
		latch.countDown();
	}

	public static void main(String[] args) throws InterruptedException{
		AtomicInteger ai = new AtomicInteger(0);
		CountDownLatch latch = new CountDownLatch(10);

		for(int i = 0; i < 10; i++){
			new IncrementThread(latch,ai).start();
		}

		latch.await();
		System.out.println(num);

	}

}
