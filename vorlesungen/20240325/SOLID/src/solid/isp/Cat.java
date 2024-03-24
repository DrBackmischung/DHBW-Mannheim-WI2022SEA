package solid.isp;

public class Cat implements AnimalActions {
	
	// Interface Segregation Principle
	// Ein Interface soll keine unnötigen Methoden & Attribute mitgeben
	
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
	
	public void eat() {
		System.out.println("Nom nom nom");
	}

	public void sleep() {
		System.out.println("zzZZZzzZZZ");
	}

	public void fly() {
		System.out.println("Cats can not fly :(");
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
