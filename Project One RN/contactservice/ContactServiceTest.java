package contactservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ContactServiceTest {
	
	private ContactService service;
	
	@BeforeEach
	public void setup() {
		service = new ContactService();
	}


	// First testing the adding contact with the same sample I used in the contactTest
	@Test
	public void testAddContact() {
		Contact contact = new Contact("AB123", "Billy", "Bob", "8608675309", "47 Cherry st");
		service.addContact(contact);
	}
	
	// Now testing adding a duplicate contact
	// Each contact will be different exept for the ID
	@Test
	public void testAddDupContact() {
		Contact contact1 = new Contact("AB123", "Billy", "Bob", "8608675309", "47 Cherry st");
		Contact contact2 = new Contact("AB123", "Roger", "Newton", "8607984444", "47 Trailsend dr");
		
		service.addContact(contact1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact2);
		});
	}
	
	//This is now to test deleting a contact 
	@Test
	public void testDelContact() {
		Contact contact = new Contact("AB123", "Billy", "Bob", "8608675309", "47 Cherry st");
		service.addContact(contact);
		
		assertTrue(service.deleteContact("AB123"));
		assertFalse(service.deleteContact("AB123"));
	}
	
	// After reviewing the notes you left in the submission feedback I added this
	// Now I should be able to test for the update contact functionality
	
	@Test 
	public void testUpdateContactFields() {
		Contact contact = new Contact("AB123", "Billy", "Bob", "8608675309", "47 Cherry st");
		service.addContact(contact);
		
		// This will cover the 4 methods
		service.updateFirstName("AB123", "Josh");
		service.updateLastName("AB123", "Kahl");
		service.updatePhone("AB123", "8607745544");
		service.updateAddress("AB123", "12 Brook st");
				
		
	}
	// Added in a test for the updating a non ecisitng contact
	@Test
	public void testUpdateNonExistingContact() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("XY777777", "Testing");
		});
	}
	

}
