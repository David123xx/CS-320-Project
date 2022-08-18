package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointmentService.Appointment;
import appointmentService.AppointmentService;

class AppointmentServiceTest {
	String id1 = "12345", id2 = "54321", id3 = "12345678910";
	String d1 = "description", d2 = "123456789012345678901234567890123456789012345678901";
	LocalDate date1 = LocalDate.of(2022, 10, 05);
	LocalDate date2 = LocalDate.of(1994, 10, 05);

	@Test
	void testAddAppointments() {
		//tests it can find appointment
		AppointmentService testService = new AppointmentService();
		Appointment test1 = new Appointment(id1, d1, date1);
		testService.addAppointment(test1);
		assertTrue(testService.findAppointment(id1));
		
		//checks to see if you can add a second appointment of the same ID
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			Appointment test2 = new Appointment(id1, d1, date1);
			testService.addAppointment(test2);
		});
		}
	@Test
	void testRemoveAppointment() {
		AppointmentService testService = new AppointmentService();
		Appointment test1 = new Appointment(id1, d1, date1);
		Appointment test2 = new Appointment(id2, d1, date1);
		testService.addAppointment(test1);
		testService.addAppointment(test2);
		assertTrue(testService.removeAppointment(id2));
		assertFalse(testService.removeAppointment(id2));
		assertTrue(testService.removeAppointment(id1));
		assertFalse(testService.removeAppointment(id1));
		
	}

	@Test
	void testNullTest() {
		//regression null tests for appointment objects
		AppointmentService testService = new AppointmentService();
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			Appointment test2 = new Appointment(null, d1, date1);
			testService.addAppointment(test2);
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			Appointment test2 = new Appointment(id2, null, date1);
			testService.addAppointment(test2);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			Appointment test2 = new Appointment(id2, d1, null);
			testService.addAppointment(test2);
		});
	}
	@Test
	void testOutOfRangeVariables() {
		AppointmentService testService = new AppointmentService();
		
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			Appointment test2 = new Appointment(id1, d1, date2);
			testService.addAppointment(test2);
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			Appointment test2 = new Appointment(id3, d2, date1);
			testService.addAppointment(test2);
		});
		
		
	}

}
