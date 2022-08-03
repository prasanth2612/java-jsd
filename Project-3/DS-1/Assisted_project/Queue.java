import java.util.Scanner;

public class Queue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of the queue");
		int size = sc.nextInt();
		int queue[] = new int[size];
		int front=-1, rear=-1;
		System.out.println("q operatoin");
		while(true) {
			System.out.println("enter choice 1.enqueue 2.dequeue 3. display 4. exit");
			int ch = sc.nextInt();
		    switch(ch) {
		    case 1:if(rear==size-1) {
		    	System.out.println("queue is full no more insertion");
		    }
		    else {
		    	System.out.println("enter element to add");
		    	int key = sc.nextInt();
		    	rear++;
		    	queue[rear] = key;
		    	front=0;
		    	
		    	
		    }
		    break;
		    case 2:
		    	if ((front==-1&&rear==-1)||(front>rear)) {
		    		System.out.println("queue is empty no del");
		    	}
		    	else {
		    		front =  front+1;
		    		
		    	}
		    	break;
		    case 3:
		    	if ((front==-1&&rear==-1)||(front>rear)) {
		    		System.out.println("queue is empty ");
		    	}
		    	else {
		    		for(int i= front; i<=rear; i++) {
		    			System.out.println(queue[i]);
		    		}
		    	}
		    	break;
		    case 4:
		    	System.exit(0);
		    	break;
		    	default:System.out.println("check ur choice");
		    	break;
		    	
		    }
		}
	}

}
