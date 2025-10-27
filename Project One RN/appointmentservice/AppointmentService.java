// using the same Hashmap plan I used in previouse modules to keep it universal
package appointmentservice;

import java.util.HashMap;
import java.util.Map;
 
public class AppointmentService {
	// start out by creating the memory structure for storing Apt with a HashMap
	private Map<String, Appointment> appointments = new HashMap<>();
	
	// Need to handle the unique appointment IDs
	public void addAppointment(Appointment appointment) {
		// check that the Id exists and stays unique
		if(appointments.containsKey(appointment.getAptId())) {
			throw new IllegalArgumentException("Error Appointment ID taken");
				
		}
		//once checked if ID is unique it can be added to the Map
		appointments.put(appointment.getAptId(), appointment);
	}

	
	// This is the function for deleting appointments using aptId
	public void deleteApt(String aptId) {
		//check if Id exists before deleting
		if (appointments.containsKey(aptId)) {
			// now remove apt from the Map
			appointments.remove(aptId);
		} else {
			// now if the Id doesnt exist an error needs to be thrown
			throw new IllegalArgumentException("Error Appointment couldnt be found");
		}
	}
	
	
	// helper method for fetching apt 
	public Appointment getAppointment(String aptId) {
		return appointments.get(aptId);
	}
	
	
}

