package syed.example;

class MyThread extends Thread {

	private boolean isRunning = false;
	private boolean isEven = true;
	private int count = 0;
	private Object lock;

	public MyThread(boolean isEven) {
		super();
		this.isEven = isEven;
		if (!isEven)
			count = 1;
	}

	public void setLock(Object obj) {
		lock = obj;
	}

	public void stopThread() {
		isRunning = false;
	}

	public void run() {
		isRunning = true;

		synchronized (lock) {
			while (isRunning) {
				lock.notify();
				//System.out.println("Unlock :: " + count);
				System.out.println(">> " + count);
				count += 2;
				if (count >= 50) {
					System.out.println("End the thread");
					return;
				}
				try {
					sleep(10);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					//System.out.println("Lock :: " + count);
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
			}
		}
	}
}

public class MultiThreadExample {

	public static void main(String args[]) {
		MyThread thread1 = new MyThread(true);
		MyThread thread2 = new MyThread(false);
		Object mLock = new Object();
		thread1.setLock(mLock);
		thread2.setLock(mLock);
		thread1.start();
		thread2.start();
	}
}
