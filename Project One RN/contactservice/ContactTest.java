package contactservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class ContactTest {

	// To start I am setting the values for the test cases, I put random names numbers and addresses 
	// I was having a hard time understanding how to write test cases even after reviewing the course material
	// But I am pretty sure I figured out how to write them 
	@Test
	public void testContactCreation() {
		Contact contact = new Contact("AB123", "Billy", "Bob", "8608675309", "47 Cherry st");
		assertEquals("AB123", contact.getContactId());
		assertEquals("Billy", contact.getFirstName());
		assertEquals("Bob", contact.getLastName());
		assertEquals("8608675309", contact.getPhone());
		assertEquals("47 Cherry st", contact.getAddress());
	}
	
	// To start I test the ContactId length and whether it is null
	@Test
	public void testContactIdTooLong() {
		assertThrows(IllegalArgumentException.class,() -> {
			new Contact("AB1234567890", "Billy", "Bob", "8608675309", "47 Cherry st");
		});
	}
	@Test
	public void testContactIdNull() {
		assertThrows(IllegalArgumentException.class,() -> {
			new Contact(null, "Billy", "Bob", "8608675309", "47 Cherry st");
		});
	}
	
	// Then I moved on to the first name to test the length and null
	@Test
	public void testFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("AB123", "Billybutlonger", "Bob", "8608675309", "47 Cherry st");
		});
	}
	@Test
	public void testFirstNameNull() {
		assertThrows(IllegalArgumentException.class,() -> {
			new Contact("AB123", null, "Bob", "8608675309", "47 Cherry st");
		});
	}
	
	// Now the lastname tests for length or null 
	@Test
	public void testLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("AB123", "Billy", "Bobbutlonger", "8608675309", "47 Cherry st");
		});
	}
	@Test
	public void testLastNameNull() {
		assertThrows(IllegalArgumentException.class,() -> {
			new Contact("AB123", "Billy", null, "8608675309", "47 Cherry st");
		});
	}
	
	// The phone number I created a less than 10 length and if null
	@Test
	public void testPhoneBadLength() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("AB123", "Billy", "Bob", "8675309", "47 Cherry st");
		});
	}
	@Test
	public void testPhoneNull() {
		assertThrows(IllegalArgumentException.class,() -> {
			new Contact("AB123", "Billy", "Bob", null, "47 Cherry st");
		});
	}
	
	// For the address I test its length... I am pretty sure this is longer than the 30 char and then if null
	@Test
	public void testAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("AB123", "Billy", "Bob", "8608675309", "47 Cherry st but much longer the requirements are checking for");
		});
	}	
	@Test
	public void testAddressNull() {
		assertThrows(IllegalArgumentException.class,() -> {
			new Contact("AB123", "Billy", "Bob", "8608675309", null);
		});
	}
	
	
	
	
	//now that the length and null tests are done I am going to impliment tests for updating
	// Since we wont be updating the ID it will only be for First, Last, phone, and address

	// update first name
	@Test
	public void testUpdateFirstName() {
		Contact contact = new Contact("AB123", "Billy", "Bob", "8608675309", "47 Cherry st");
		contact.setfirstName("Roger");
		assertEquals("Roger", contact.getFirstName());
	}
	
	// update last name
	@Test
	public void testUpdateLastName() {
		Contact contact = new Contact("AB123", "Billy", "Bob", "8608675309", "47 Cherry st");
		contact.setlastName("Newton");
		assertEquals("Newton", contact.getLastName());
	}
	
	// update phone number 
	@Test
	public void testUpdatePhone() {
		Contact contact = new Contact("AB123", "Billy", "Bob", "8608675309", "47 Cherry st");
		contact.setphone("1234567890");
		assertEquals("1234567890", contact.getPhone());
	}
	
	// update the address
	@Test
	public void testUpdateAddress() {
		Contact contact = new Contact("AB123", "Billy", "Bob", "8608675309", "47 Cherry st");
		contact.setaddress("47 Trailsend dr");
		assertEquals("47 Trailsend dr", contact.getAddress());
	}
	
	

}
