

// After reading the feedback from this assignment I can see how validation staying in one place makes for a cleaner code base
// Now all of the validation is called on by other methods and is seperate 
package contactservice;

public class Contact {
	// This sets all of the names and allows them to be updated throughout the later methods... 
	// the only one that wont change is the contact ID
	 private String contactId;
	 private String firstName;
	 private String lastName;
	 private String phone;
	 private String address;
	 
	  
	 // Now that the names are set, this is the constructor to make sure they pass the requirements
	 public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		 // Added this to call validation methods so i dont repeat the validation code and can change everything in one place
		 validateContactId(contactId);
	     validateFirstName(firstName);
	     validateLastName(lastName);
	     validatePhone(phone);
	     validateAddress(address);
	     
	 	// this is only if the validations above pass, then they are assigned new values
		 this.contactId = contactId;
		 this.firstName = firstName;
		 this.lastName = lastName;
		 this.phone = phone;
		 this.address = address;
	 }
		 
	 
	 //Refactored the validation methods so all the logic is in one place
	 // Now everywhere else can call on this 
		 //contactId cant be longer than 10 char and cant be null
	 private void validateContactId(String contactId) {
		 if (contactId == null || contactId.length() > 10) {
			 throw new IllegalArgumentException("Invalid contact ID");
		 }
	 }
		 
		//first name cant be longer than 10 char or null
	 private void validateFirstName(String firstName) {
		 if (firstName == null || firstName.length() > 10) {
			 throw new IllegalArgumentException("Invalid first name");
		 }
	 }
	 
	//last name cant be longer than 10 char or null
	 private void validateLastName(String lastName) {
		 if (lastName == null || lastName.length() > 10) {
			 throw new IllegalArgumentException("Invalid last name");
		 }
	 }
	 
	//phone number has to be 10 char and cant be null
	 private void validatePhone(String phone) {
		 if (phone == null || phone.length() != 10) {
			 throw new IllegalArgumentException("Invalid phone number");
		 }
	 }
	 
	//address cant be longer than 30 char or null
	 private void validateAddress(String address) {
		 if (address == null || address.length() > 30) {
			 throw new IllegalArgumentException("Invalid address");
		 }
	 }
	
		 
	
	 
	 
	 // These are the getter methods for contactId, firstName, lastName, phone, and address.
	 // I put these separate from the setter methods because it seemed more organized than putting all of them together 
	 // I figured it wouldnt mess things up but we will see in testing
	 
	 public String getContactId() {
		 return contactId;
	 }
	 
	 public String getFirstName() {
		 return firstName;
	 }
	 
	 public String getLastName() {
		 return lastName;
	 }
	 
	 public String getPhone() {
		 return phone;
	 }
	 public String getAddress() {
		 return address;
	 }
	 
	 
	 // Now these are the setter methods, the only one that doesnt have one is the contactId since it wont be changed
	 // I took out the seperate validation and have each call upon the validation above
	 public void setfirstName(String firstName) {
		 // in order to set I passed all of these through the same validations shown in the constructor
		 validateFirstName(firstName);
		 this.firstName = firstName;
	 }
	 
	 public void setlastName(String lastName) {
		 // in order to set I passed it through the same validations in the constructor
		 validateLastName(lastName);
		 this.lastName = lastName;
	 }
	 
	 public void setphone(String phone) {
		 // in order to set I passed it through the same validations in the constructor
		validatePhone(phone);
		 this.phone = phone;
	 }
	 
	 public void setaddress(String address) {
		 // in order to set I passed it through the same validations in the constructor
		 validateAddress(address);
		 this.address = address;
	 }
	 
		 
}


