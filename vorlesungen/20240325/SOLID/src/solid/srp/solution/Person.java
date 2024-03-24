package solid.srp.solution;

public class Person {
	
	public void feedCat(Cat c) {
		System.out.println("Here you go, "+c.getFirstName());
	}
	
	public void prepareCatFood(Cat c) {
		System.out.println("hmmmmmm :)");
	}
	
	public void pet(Cat c) {
		System.out.println("I wanna cuddle you, "+c.getFirstName()+"!");
	}

}
