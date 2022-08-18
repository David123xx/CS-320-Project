package tests;

import static org.junit.jupiter.api.Assertions.*;
import contactService.Contact;

import org.junit.jupiter.api.Test;


class ContactTest {
	//default params for tests
	String id = "12345", firstName = "David",
			lastName = "Robey", phoneNumber = "1234567890",
			address = "123 house rd";

	@Test
	void testAddressNull() {
		Contact test = new Contact(id, firstName, lastName,
				phoneNumber,address);
		test.setAddress(null);
		assertEquals(address, test.getAddress());
	}
	@Test
	void testAddressTooLong() {
		Contact test = new Contact(id, firstName, lastName,
				phoneNumber,address);
		test.setAddress("This is far longer than it has to be but I am going to do it anyways ");
		assertEquals(address, test.getAddress());
	}
	@Test
	void testAddressWorks() {
		Contact test = new Contact(id, firstName, lastName,
				phoneNumber,address);
		test.setAddress("123 change rd");
		assertEquals("123 change rd", test.getAddress());
	}
	@Test
	void testNameNull() {
		Contact test = new Contact(id, firstName, lastName,
				phoneNumber,address);
		test.setFirstName(null);
		assertEquals(firstName, test.getFirstName());
	}
	@Test 
	void testNameTooLong(){
		Contact test = new Contact(id, firstName, lastName,
				phoneNumber,address);
		test.setFirstName("This is too long of a name");
		assertEquals(firstName, test.getFirstName());
	}
	@Test
	void testNameWorks() {
		Contact test = new Contact(id, firstName, lastName,
				phoneNumber,address);
		test.setFirstName("john");
		assertEquals("john", test.getFirstName());
	}
	@Test
	void testPhoneNumTooShort() {
		Contact test = new Contact(id, firstName, lastName,
				phoneNumber,address);
		test.setPhoneNumber("1");
		assertEquals(phoneNumber, test.getPhoneNumber());
	}
	@Test
	void testPhoneNumTooLong() {
		Contact test = new Contact(id, firstName, lastName,
				phoneNumber,address);
		test.setPhoneNumber("123456789123456789");
		assertEquals(phoneNumber, test.getPhoneNumber());
		
	}
	@Test
	void testPhoneNumNull() {
		Contact test = new Contact(id, firstName, lastName,
				phoneNumber,address);
		test.setPhoneNumber(null);
		assertEquals(phoneNumber, test.getPhoneNumber());
	}
	@Test
	void testPhoneNumNull2() {
		Contact test = new Contact(id, firstName, lastName,
				null,address);
		assertEquals("0000000000", test.getPhoneNumber());
	}
	@Test
	void testPhoneNumWorks() {
		Contact test = new Contact(id, firstName, lastName,
				phoneNumber,address);
		test.setPhoneNumber("5715556666");
		assertEquals("5715556666", test.getPhoneNumber());
	}

}
