// bring in the recommended data utility
package appointmentservice;

import java.util.Date;

public class Appointment {
	//set all the fields for id, description, and date
	// I changed from "appointmentId"etc...  I was getting tired of writing the full name haha
	private String aptId;
	private Date aptDate;
	private String aptDescription;
	
	
	// Going to start with the constructor checking if they pass the requirements 
	public Appointment(String aptId, Date aptDate, String aptDescription) {
		//ID cant be longer than 10 char or null
		if (aptId == null || aptId.length() > 10) {
			throw new IllegalArgumentException("Error Appointment ID");
		}
		//Date cant be in the past or null
		if (aptDate == null || aptDate.before(new Date())) {
			throw new IllegalArgumentException("Error Appointment Date");
		}
		//Description cant be longer than 50 char or null
		if (aptDescription == null || aptDescription.length() > 50) {
			throw new IllegalArgumentException("Error Appointment Description");
		}		
		
		// now once the validation happens, assign values
		this.aptId = aptId;
		this.aptDate = aptDate;
		this.aptDescription = aptDescription;
		
		
	}
	 
	
	//Next is the getter methods for ID, Date, and Description
	// I followed the same logic and code from past modules.
	
	public String getAptId() {
		return aptId;
	}
	
	public Date getAptDate() {
		return aptDate;
	}

	public String getAptDescription() {
		return aptDescription;
	}
	
	
	// Moving on to the setter methods
	// The Id wont change like past modules 
	public void setAptDate(Date aptDate) {
		// before set I use the validation again
		if (aptDate == null || aptDate.before(new Date())) {
			throw new IllegalArgumentException("Error Appointment Date");
		}
		this.aptDate = aptDate;
	}
	public void setAptDescription( String aptDescription) {
		// before set, use the same validation 
		if (aptDescription == null || aptDescription.length() > 50) {
			throw new IllegalArgumentException("Error Appointment Description");
		}
		this.aptDescription = aptDescription;
	}
}
	
