public class SleepWait {

	public static void main(String[] args) {
		Object obj = new Object();
		int i = 0;
		while(i<10) {
			synchronized (obj) {
				try {
					obj.wait(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("obj is woken after 1 sec");
			}
			
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " is woken after 2 sec");
			i +=1 ;
		}	
	}
}