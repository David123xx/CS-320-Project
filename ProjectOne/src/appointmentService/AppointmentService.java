package appointmentService;
import java.time.LocalDate;
import java.util.ArrayList;

public class AppointmentService {
	public ArrayList<Appointment> AppList;
	
	public AppointmentService() {
		AppList = new ArrayList<Appointment>();
	}
	
	public void addAppointment(Appointment newApp) {
		for(Appointment app : AppList) {
			if(newApp.getID() == app.getID()) {
				throw new IllegalArgumentException("Must have unique ID");
			}
		}
		AppList.add(newApp);
	}
	public boolean removeAppointment(String id) {
		for(Appointment app : AppList) {
			if(app.getID() == id) {
				AppList.remove(app);
				return true;
			}
		}
		return false;
		
	}
	public boolean findAppointment(String id) {
		for(Appointment app : AppList) {
			if(app.getID() == id) {
				return true;
			}
		}
		return false;
	}
	

}
