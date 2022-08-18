package contactService;

public class Contact {
	
	private final String id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	//constructor
	public Contact(String inputID, 
			String inputFirstName,
			String inputLastName,
			 String inputPhoneNumber, 
			 String inputAddress){
		id = inputID;
		firstName = nameValidation(inputFirstName);
		lastName = nameValidation(inputLastName);
		if(inputPhoneNumber == null) {phoneNumber = "0000000000";}
		else {phoneNumber = phoneNumValidation(inputPhoneNumber);}
		address = addressValidation(inputAddress);
	}
	//getter methods return as string
	public String getID() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	//setter methods
	//sets first name
	public void setFirstName(String newFirstName) {
		//if name change is valid is default
		if(nameValidation(newFirstName).equals("default")) {
			System.out.println("First Name did not change");
		}
		//first name becomes new first name
		else {firstName = newFirstName;}
	}
	
	public void setLastName(String newLastName) {
		//checks to see if new name is default
		if(nameValidation(newLastName).equals("default")) {
			//doesnt change name
			System.out.println("Last Name did not change");
		}
		else {lastName = newLastName;}
	}
	
	public void setPhoneNumber(String newPhoneNumber) {
		//checks if phone number is default
		if(phoneNumValidation(newPhoneNumber).equals("default")) {
			//if default doesnt change
			System.out.println("Phone Number did not change");
			//changes phone number to all 0's
			
		}
		//else changes
		else {phoneNumber = newPhoneNumber;}
	}
	public void setAddress(String newAddress) {
		//if address is default
		if(addressValidation(newAddress).equals("default")) {
			//doesn't change
			System.out.println("Address did not change");
		}
		//else it changes
		else {address = newAddress;}
	}
	
	// checks if name is null, name exceeds length of 10
	public String nameValidation(String name) {
		//checks if name is null
		if( name == null){
			System.out.println("name cannot be null");
			//returns default
			return "default";
		}
		//checks if name is greater than 10
		if(name.length()> 10) {
			System.out.println("name cannot exceed 10 characters");
			//sets to "default"
			return "default";
		}

		return name;
	}
	public String phoneNumValidation(String phoneNumber) {
		//checks if  number is null
		if(phoneNumber == null) {
			System.out.println("phone number cannot be null");
			return "default";
		}
		//checks length is not 10
		if(phoneNumber.length() != 10) {
			System.out.println("phone number must have a length of 10");
			return "default";
		}
		//checks if there are any letters or other characters
		for(int i = 0; i < phoneNumber.length(); i++) {
			if(phoneNumber.charAt(i) < '0' || phoneNumber.charAt(i) > '9') {
				System.out.println("Phone number can only have digits");
				return "default";
			}
		}
		return phoneNumber;
	}
	public String addressValidation(String address) {
		//checks if address is null
		if(address == null) {
			System.out.println("address can not be null");
			return "default";
		}
		//checks if addres is greater than 30
		if(address.length() > 30) {
			
			System.out.println("address can not exceed 30 characters");
			return "default";
			}
		
		return address;
	}
	
}
