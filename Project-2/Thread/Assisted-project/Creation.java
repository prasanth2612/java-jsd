

class WorkerThread1 extends Thread{
	@Override
	public void run() {
		System.out.println("I am Worker Thread 1, I extends Thread class");
	}
}

class WorkerThread2 implements Runnable{
	@Override
	public void run() {
		System.out.println("I am Worker Thread 2, I implements Runnable interface");
	}
}

public class Creation {

	public static void main(String[] args) {
		WorkerThread1 w1 = new WorkerThread1();
		w1.setPriority(10);
		
		WorkerThread2 w2 = new WorkerThread2();
		Thread t2 = new Thread(w2);
		t2.setPriority(1);
		
		t2.start();
		w1.start();
		//The order is not maintained
		System.out.println("I am in main class");
	}

}
