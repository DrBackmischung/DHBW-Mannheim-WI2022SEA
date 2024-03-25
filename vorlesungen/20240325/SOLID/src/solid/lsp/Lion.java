package solid.lsp;

public class Lion extends Cat {

	public Lion(String firstName, String lastName, String color, int age) {
		super(firstName, lastName, color, age);
	}
	
	public void eat() {
		System.out.println("Nom nom nom >:)");
	}
	
	public void hunt() {
		System.out.println("hehehe >:)");
	}

}
