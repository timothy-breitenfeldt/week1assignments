package exercise3;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

	private Queue<Integer> queue;
	private int capasity;

	public ProducerConsumer(int capasity) {
		this.capasity = capasity;
		this.queue = new LinkedList<Integer>();
	}

	public void producer() throws InterruptedException {
		int item = 0;

		while (true) {
			synchronized(this) {
				//Lock thread until there is space in the queue for more items.
				while (this.queue.size() == this.capasity) {
					super.wait();
				}

				item += 1;

				this.queue.add(item);
				System.out.println("The producer produced " + item + " there are " + this.queue.size() + " items in the queue.");
				super.notify();
				Thread.sleep(1000);
			}
		}
	}

	public void consumer() throws InterruptedException {
		int item = 0;

		while (true) {
			synchronized(this) {
				//Lock the thread until there are items that can be consumed.
				while (this.queue.size() == 0) {
					super.wait();
				}

				item = this.queue.poll();
				System.out.println("Consumer consumes the item " + item + " there are " + this.queue.size() + " items in the queue.");
				super.notify();
				Thread.sleep(1000);
			}
		}
	}

}
