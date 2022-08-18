package contactService;

import java.util.ArrayList;

public class ContactService {
	//creates array list of contacts
	public ArrayList<Contact> contactList;
	//constructor
	public ContactService() {
		contactList = new ArrayList<Contact>();
	}
	//adds contact
	public boolean addContact(Contact newContact) {
		//checks if contact id is not null or length is greater than 10
		if(newContact.getID()== null) {	return false;}
		if( newContact.getID().length() > 10) {return false;}
		//checks each contact to make sure id is not in use
			for(Contact contact : contactList) {
				if(newContact.getID() == contact.getID()) {
					System.out.println("Contact must have different id");
					return false;
				}
			}
			//if not in use, adds new contact
			contactList.add(newContact);
			return true;
		}
	public boolean removeContact(String id) {
		//check each contact in array
		for(Contact contact : contactList) {
			//if id matches remove
			if(id.equals(contact.getID())) {
				//removes contact
				contactList.remove(contact);
				return true;
			}
		}
		System.out.println("No contact found by that id");
		return false;
	}
	
	public boolean updateFirstName(String id, String newName) {
		//check each contact in array
		for(Contact contact : contactList) {
			//if contact found
			if(id.equals(contact.getID())) {
				//update name
				contact.setFirstName(newName);
				//if name worked return true
				if(contact.getFirstName().equals(newName)) {return true;}
				//else returns false
				else {return false;}
			}
		}
		System.out.println("Could not find id");
		return false;
	}
	public boolean updateLastName(String id, String newName) {
		//checks each contact in array
		for(Contact contact : contactList) {
			//if id matches
			if(id.equals(contact.getID())) {
				//changes name if valid
				contact.setLastName(newName);
				//if valid returns true
				if(contact.getLastName().equals(newName)) {	return true;}
				//returns false otherwise
				else {return false;}
			}
		}
		System.out.println("Could not find id");
		return false;
	}
	public boolean updatePhoneNumber(String id, String newNum) {
		//checks each contact in list
		for(Contact contact : contactList) {
			// if id match found
			if(id.equals(contact.getID())) {
				//set phone number
				contact.setPhoneNumber(newNum);
				//checks if it took effect
				if(contact.getPhoneNumber().equals(newNum)) {return true;}
				//if it doesn't false
				else {return false;}
				}
		}
		//default false condition
		return false;
	}
	// updates address
	public boolean updateAddress(String id, String newAddress) {
		//searhes each contact in contact list
		for(Contact contact : contactList) {
			//checks to see if it matches
			if(id.equals(contact.getID())) {
				//sets address to new one
				contact.setAddress(newAddress);
				//If it changed, it returns true
				if(contact.getAddress().equals(newAddress)) {return true;}
				//else false
				else {return false;}
			}
		}
		//default false condition
		return false;
	}
}
