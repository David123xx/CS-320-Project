package taskService;

public class Task {
	private final String id;
	private String name;
	private String description;
	
	public Task(String inputID, String inputName,
			String inputDescription) {
		id = stringValidation(inputID, 10);
		name = stringValidation(inputName,20);
		description = stringValidation(inputDescription,50);
	}
	public String getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public void setName(String inputName) {
		name = stringValidation(inputName, 20);
	}
	public void setDescription(String inputDescription) {
		description = stringValidation(inputDescription,50);
	}
	public String stringValidation(String input, int length) {
		
		if (input == null) {throw new IllegalArgumentException("Can not be null");}
		if (input.length() > length) {throw new IllegalArgumentException("Invalid Length");}
		return input;
	}

}