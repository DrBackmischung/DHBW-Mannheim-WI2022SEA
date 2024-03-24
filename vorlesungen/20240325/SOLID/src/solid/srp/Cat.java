package solid.srp;

public class Cat {
	
	// Single Responsibility Principle
	// Ein Objekt soll nur das tun, was das Objekt selber machen kann!
	// Katzen können nur "Katzensachen" machen
	
	private String firstName;
	private String lastName;
	private String color;
	private int age;
	
	public Cat(String firstName, String lastName, String color, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.color = color;
		this.age = age;
	}
	
	public void meow() {
		System.out.println("Meow");
	}
	
	public void eat() {
		System.out.println("Nom nom nom");
	}
	
	public void sleep() {
		System.out.println("zzZZZzzZZZ");
	}
	
	public void feedCat() {
		System.out.println("Here you go, "+firstName);
	}
	
	public void prepareCatFood() {
		System.out.println("hmmmmmm :)");
	}
	
	public void pet() {
		System.out.println("I wanna cuddle you, "+firstName+"!");
	}
	
	// Getter & Setter

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
