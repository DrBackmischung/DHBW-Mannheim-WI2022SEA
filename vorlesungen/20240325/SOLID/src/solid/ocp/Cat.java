package solid.ocp;

public class Cat {
	
	// Open-Closed Principle
	// Ein Objekt soll soll nicht änderbar, aber erweiterbar sein
	
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
	
	public void play(String toy) {
        if (toy.equals("ball")) {
            System.out.println("This is fun :)");
        } else if (toy.equals("feather")) {
            System.out.println("Oooh, its a dead bird!");
        }
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
