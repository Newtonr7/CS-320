//getting started I think that using a Hash Map would be the most effective way of storing the contacts without a database
package contactservice;


import java.util.HashMap;
import java.util.Map;

 
public class ContactService {
	// To start I will need in memory data structure for storing contacts
	// This will be with a HashMap
	private Map<String, Contact> contacts = new HashMap<>();
	
	// Hanlde the unique ID for contact
	public void addContact(Contact contact) {
		//need to check if the ID exists so it remains unique using similar checking from contact.java
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("The Contact ID already exists");	
		}
		
		// Now if the ID is unique we add it to the map
		contacts.put(contact.getContactId(), contact);
	}
	
	
	// Then we move on to handle the ability to delete contacts
	public boolean deleteContact(String contactId) {
		// check if it exists before moving on to deleting
		if (contacts.containsKey(contactId)) {
			// this will remove the contact from the Map
			contacts.remove(contactId);
			return true;
		
		}
		// if the contacts doesnt exist then we return false
		return false;
	}
	
	
	// now we move to the firstName and make it updatable
	public void updateFirstName(String contactId, String firstName) {
		//need to check if the ID exists
		if (contacts.containsKey(contactId)) { 
			// now we call on the firstName method and the Contact class will validate it
			contacts.get(contactId).setfirstName(firstName);
		} else {
			// THis is in case it doesnt exist we wont update it... error will show so we know 
			throw new IllegalArgumentException("Contact cannot be found");
		}
		
	}
	
	
	// Next is the Lastname following the same logic in the firstName
	public void updateLastName(String contactId, String lastName) {
		//need to check if the ID exists
		if (contacts.containsKey(contactId)) { 
			// now we call on the lastName method and the Contact class will validate it
			contacts.get(contactId).setlastName(lastName);
		} else {
			// THis is in case it doesnt exist we wont update it... error will show so we know 
			throw new IllegalArgumentException("Contact cannot be found");
		}
		
	}
	
	// Continuing we do the same for the phone number
	public void updatePhone(String contactId, String phone) {
		//need to check if the ID exists
		if (contacts.containsKey(contactId)) { 
			// now we call on the phone number method and the Contact class will validate it
			contacts.get(contactId).setphone(phone);
		} else {
			// This is in case it doesnt exist we wont update it... error will show so we know 
			throw new IllegalArgumentException("Contact cannot be found");
		}
		
	}
	
	//Lastly we do the address
	public void updateAddress(String contactId, String address) {
		//need to check if the ID exists
		if (contacts.containsKey(contactId)) { 
			// now we call on the Address method and the Contact class will validate it
			contacts.get(contactId).setaddress(address);
		} else {
			// This is in case it doesnt exist we wont update it... error will show so we know 
			throw new IllegalArgumentException("Contact cannot be found");
		}
		
	}
	
	
	
	
}
