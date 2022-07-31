
//Inheritance


class Animal{
	
	String species;
	boolean isMammal;
	
	Animal(String species, boolean isMammal){
		this.isMammal = isMammal;
		this.species = species;
	}
	
	@Override
	public String toString() {
		if(isMammal)
			return("I am a "+ this.species+ " and I am also a mammal" );
		else
			return("I am a "+ this.species+ " and I am also a mammal" );
	}
}

class Dog extends Animal{
	
	String name;
	String gender;
	
	Dog(String name, String gender, String species, boolean isMammal){
		super(species, isMammal);
		this.gender = gender;
		this.name = name;
		
		super.toString();
	}
	
	@Override
	public String toString() {
		return("I am a "+ this.name+ " and I am a "+this.gender );
	}
}

public class Pillairs {
	
	public static void main(String[] args) {
		Dog puppy = new Dog("puppy", "Male", "Dog", true);
		System.out.println(puppy);
	}

}
//Encapsulation

class Dog {
	String name;
	String gender;
	
	Dog(String name, String gender, String species, boolean isMammal){
		super(species, isMammal);
		this.gender = gender;
		this.name = name;
		
		super.toString();
	}
	
	public String toString() {
		return("I am a "+ this.name+ " and I am a "+this.gender );
	}
}

public class Pillairs {
	
	public static void main(String[] args) {
		Dog puppy = new Dog("puppy", "Male", "Dog", true);
		System.out.println(puppy);
	}

}

//Polymorphism
class Sum 
{
    public int sum(int x, int y) 
    { 
        return (x + y); 
    } 
    public int sum(int x, int y, int z) 
    { 
        return (x + y + z); 
    } 
    public double sum(double x, double y) 
    { 
        return (x + y); 
    } 
    public static void main(String args[]) 
    { 
        Sum s = new Sum(); 
        System.out.println(s.sum(10, 20)); 
        System.out.println(s.sum(10, 20, 30)); 
        System.out.println(s.sum(10.5, 20.5)); 
    } 
}
//Abstraction


abstract class PetrolTank{
	int fuelPercent;
	boolean isConnectedToEngine;
	
	
	public PetrolTank(int fuelPercent, boolean isConnectedToEngine) {
		this.fuelPercent = fuelPercent;
		this.isConnectedToEngine = isConnectedToEngine;
	}

	public abstract void tankOk(int fuelPercent, boolean isConnectedToEngine);
}

interface Engine{
	boolean isEngineOk = true;
	abstract void start();
}

class Bike extends PetrolTank implements Engine{

	public Bike(int fuelPercent, boolean isConnectedToEngine) {
		super(fuelPercent, isConnectedToEngine);
	}
	
	@Override
	public void start() {
		if(isEngineOk)
			tankOk(fuelPercent, isConnectedToEngine);
		else
			System.out.println("Bike not Started...");

	}
	
	@Override
	public void tankOk(int fuelPercent, boolean isConnectedToEngine) {
		if(this.fuelPercent > 20 && this.isConnectedToEngine)
			System.out.println("Bike Started");
		else
			System.out.println("Bike not Started...");
	}
	
	
	
}

public class Pillairs {

	public static void main(String[] args) {
		Bike hero = new Bike(10, true);
		hero.start();
	}

}

