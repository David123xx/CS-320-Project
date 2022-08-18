package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointmentService.Appointment;

class AppointmentTest {
	LocalDate date1 = LocalDate.of(2022, 10, 05);
	String goodID = "12345";
	String goodDesc = "Description";
	LocalDate invalid = LocalDate.of(1994, 10, 05);
	String badID = "12345678910";
	String badDesc = "this is a really really really really really long description that is probably too long for this";

	@Test
	void testGoodInput() {
		Appointment app = new Appointment(goodID,goodDesc, date1);
		assertEquals(goodID, app.getID());
		assertEquals(goodDesc, app.getDescription());
		assertEquals(date1, app.getDate());
	}
	@Test
	void testNullInput() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Appointment(null, goodDesc, date1);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Appointment(goodID, null, date1);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Appointment(goodID, goodDesc, null);});
		
	}
	@Test
	void testInvalidInput() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Appointment(badID, goodDesc, date1);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Appointment(goodID, badDesc, date1);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Appointment(goodID, goodDesc, invalid);});
		
		
	}

}
