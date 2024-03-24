package solid.dip.solution;

import solid.dip.Toy;

public class Cat {
	
	// Dependency Inversion Principle
	// Hochrangige Module sollten nicht von niedrigrangigen Modulen abhängig sein

	private String firstName;
	private String lastName;
	private String color;
	private int age;
	private Toy t;
	
	public Cat(String firstName, String lastName, String color, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.color = color;
		this.age = age;
	}
	
	public void play() {
		Ball t = new Ball();
		t.play();
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
