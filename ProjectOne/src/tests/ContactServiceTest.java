package tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import contactService.Contact;
import contactService.ContactService;

class ContactServiceTest {
	//valid inputs for first contact
	String id1 = "1" , fName1 = "David",
			lName1 = "Robey", pnum1 = "1234567890",
			address1 = "123 Happy Rd";
	Contact test1 = new Contact(id1,fName1,lName1,pnum1,address1);
	//valid inputs for second contact
	String id2 = "2", fName2 = "John",
			lName2 = "Smith", pnum2 = "9876543210",
			address2 = "123 second st";
	Contact test2 = new Contact(id2,fName2,lName2,pnum2,address2);
	//valid inputs for 3rd contact
	String id3 = "3", fName3 = "Abe",
			lName3 = "Cheese", pnum3 = "7534201596",
			address3 = "123 cloudyface rd";
	Contact test3 = new Contact(id3,fName3,lName3,pnum3,address3);
	
	//invalid options
	String nullString = null;
	Contact nulltest = new Contact(null, fName3,lName3,pnum3,address3);
	Contact invalidIDtest = new Contact(id1, fName2,lName2,pnum2,address2);

	//adds 3 contacts and then removes contacts
	@Test
	void testAddAndRemoveContacts() {
		ContactService testService = new ContactService();
		//adds contacts
		assertTrue(testService.addContact(test1));
		assertTrue(testService.addContact(test2));
		assertTrue(testService.addContact(test3));
		//removes contacts
		assertTrue(testService.removeContact(id1));
		assertTrue(testService.removeContact(id2));
		assertTrue(testService.removeContact(id3));
		//attempts to remove already removed contacts
		assertFalse(testService.removeContact(id1));
		assertFalse(testService.removeContact(id2));
		assertFalse(testService.removeContact(id3));
	}
	//adds a valid contact, then tries to add null or used id's
	@Test
	void testAddInvalidContacts() {
		ContactService testService = new ContactService();
		assertTrue(testService.addContact(test1));
		assertFalse(testService.addContact(nulltest));
		assertFalse(testService.addContact(invalidIDtest));
		
		
	}
	@Test
	void testAddAndChangeContactInformation() {
		ContactService testService = new ContactService();
		assertTrue(testService.addContact(test1));
		assertTrue(testService.addContact(test2));
		assertTrue(testService.addContact(test3));
		//valid changes
		assertTrue(testService.updateFirstName(id1, "Sinikka"));
		assertTrue(testService.updateLastName(id1, "Bites"));
		assertTrue(testService.updateAddress(id1, "123 SuperHappy rd"));
		assertTrue(testService.updatePhoneNumber(id1, "7033136720"));
		//invalid changes for too long
		assertFalse(testService.updateFirstName(id2, "FrancisvonBigname"));
		assertFalse(testService.updateLastName(id2, "JacobLikesPineapples"));
		assertFalse(testService.updatePhoneNumber(id2, "123456789123456789"));
		assertFalse(testService.updateAddress(id2,"1234 I have no idea what street i live"
				+ " on rd or was it a ct? maybe a street?"));
		assertFalse(testService.updatePhoneNumber(id2, "abcdefcasd"));
		//invalid null changes
		assertFalse(testService.updateFirstName(id3, null));
		assertFalse(testService.updateLastName(id3, null));
		assertFalse(testService.updatePhoneNumber(id3, null));
		assertFalse(testService.updateAddress(id3,null));
	}
	

}

