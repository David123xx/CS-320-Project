package appointmentService;
import java.time.LocalDate;
import java.util.Date;

public class Appointment {
	private final String id;
	private final LocalDate appDate;

	private String description;
	
	
	public Appointment(String inputID, String inputDesc, LocalDate inputDate ) {
		
		id = stringValidation(inputID,10);
		description = stringValidation(inputDesc,50);
		appDate = setDate(inputDate);
	}
	public String getID() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public LocalDate getDate() {
		return appDate;
	}
	public void setDescription(String input) {
		description = stringValidation(input, 50);
		
	}
	
	public String stringValidation(String input, int length) {
		
		if (input == null) {throw new IllegalArgumentException("Can not be null");}
		if (input.length() > length) {throw new IllegalArgumentException("Invalid Length");}
		return input;
	}
	public LocalDate setDate(LocalDate inputDate) {
		if(inputDate == null) {throw new IllegalArgumentException("Date cannot be null");}
		LocalDate currDate = LocalDate.now();
		if(inputDate.isBefore(currDate)) {throw new IllegalArgumentException("Date cannot be before today");}
		return inputDate;
	}
	
	
	

}
