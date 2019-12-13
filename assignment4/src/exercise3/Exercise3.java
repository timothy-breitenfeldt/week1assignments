package exercise3;

public class Exercise3 {

	public static void main(String[] args) throws InterruptedException{
		int capasity = 5;
		ProducerConsumer pc = new ProducerConsumer(capasity);
		Thread t1 = null;
		Thread t2 = null;
		
		t1 = new Thread(new Runnable() {
			public void run() {
				try {
					pc.consumer();
				} catch(InterruptedException anInterruptedException) {
					anInterruptedException.printStackTrace();
				}
			}
		});
		
		t2 = new Thread(new Runnable() {
			public void run() {
				try {
					pc.producer();
				} catch(InterruptedException anInterruptedException) {
					anInterruptedException.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

}
