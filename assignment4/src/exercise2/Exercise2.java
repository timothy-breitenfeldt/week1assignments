package exercise2;

public class Exercise2 {

	private static Object resource1 = new Object();
	private static Object resource2 = new Object();

	public static void main(String[] args) {
			Thread t1 = new Thread1();
			Thread t2 = new Thread2();
			t1.start();
			t2.start();
	}

	private static class Thread1 extends Thread {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("thread 1 " + i);

				synchronized(resource1) {
					System.out.println("Thread 1 has resource 1.");

					try {
						Thread.sleep(100);
					} catch(InterruptedException anInterruptedException) {}

					System.out.println("Thread 1 is waiting for resource 2");
					synchronized(resource2) {
						System.out.println("Thread 1 is holding both locks for resource 1 and 2.");
					}
				}
			}
		}

	}

	private static class Thread2 extends Thread {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("thread 2 " + i);

				synchronized(resource2) {
					System.out.println("Thread 2 has resource 2.");

					try {
						Thread.sleep(100);
					} catch(InterruptedException anInterruptedException) {}

					System.out.println("Thread 2 is waiting for resource 1");
					synchronized(resource1) {
						System.out.println("Thread 2 is holding both locks for resource 1 and 2.");
					}
				}
			}
		}

	}

}
