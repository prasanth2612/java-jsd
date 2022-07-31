import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ChatApp{

	boolean flag = false;
	String ask_msg = "";
	
	public synchronized void ask(String msg) {
		this.ask_msg = msg;
		if(flag) {
			try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		System.out.println(msg);
		flag = true;
		notify();
	}
	
	public synchronized void give(String msg) {
		if(flag==false) {
			try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		System.out.println(msg);
		flag = false;
		notify();
	}	
}

class ElectronicsProducer extends Thread{
	public HashMap<String, Integer> inventory;
	ChatApp cap;
	Consumer c;
	
	ElectronicsProducer(HashMap<String, Integer> inventory, ChatApp cap) {
		this.inventory = inventory;
		this.cap = cap;
		
		inventory.put("Diode", 0);
		inventory.put("Mosfet", 900);
		inventory.put("Transistor", 500);
		
		this.start();
	}
	
	@Override
	public void run() {
				
		for (Map.Entry<String, Integer> mapElement : inventory.entrySet()) {
			if(mapElement.getKey().equals(cap.ask_msg))  {
				if(mapElement.getValue() > 0)
					cap.give("I can provide "+ mapElement.getKey());
				else 
					cap.give("I do not have enough stock of "+ mapElement.getKey()+ "s");
			}
		}
	}
}

class Consumer extends Thread{
	public HashMap<String, Integer> inventory;
	ChatApp cac;
	ElectronicsProducer p;
	
	Consumer(HashMap<String, Integer> inventory, ChatApp cac) {
		this.inventory = inventory;
		this.cac = cac;
		
		inventory.put("Diode", 0);
		inventory.put("Mosfet", 0);
		inventory.put("Transistor", 0);
		inventory.put("AND_Gate", 10);
		
		this.start();
	}
	
	@Override
	public void run() {
		for (Map.Entry<String, Integer> mapElement : inventory.entrySet()) {
			if(mapElement.getValue() == 0) {
				cac.ask(mapElement.getKey()+"");
			}
		}
	}
}

public class Sync{

	public static void main(String[] args) {
		
		HashMap<String, Integer> producerInventory = new HashMap<String, Integer>();
		HashMap<String, Integer> consumerInventory = new HashMap<String, Integer>();
		
		ChatApp ca = new ChatApp();
		
		new Consumer(consumerInventory, ca);
		new ElectronicsProducer(producerInventory, ca);
		
	}

}