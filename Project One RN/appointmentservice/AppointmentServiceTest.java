//imported all the libraries for assertions, date, test and calendar 
package appointmentservice;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

public class AppointmentServiceTest {
	
	private AppointmentService service;
	
	@BeforeEach
	public void setup() {
		service = new AppointmentService();
	}


	// First testing the adding appointment for a date in the future
	// the calendar object helps to check a date a month away
	@Test
	public void testAddApt() {
		//This starts out by setting the date to the current date 
		Calendar calendar = Calendar.getInstance();
		// now add a month to the current date
		calendar.add(Calendar.MONTH, 1);
		// turn it into a date object for the appointment consturctor 
		Date futureDate = calendar.getTime();
		
		Appointment apt = new Appointment("A123", futureDate, "Dentist");
		service.addAppointment(apt);
	}
	
	// This tests the adding a duplicate Appointment
	@Test
	public void testAddDupApt() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		Date futureDate1 = calendar.getTime();
		
		calendar.add(Calendar.MONTH, 1);
		Date futureDate2 = calendar.getTime();
		
		//The apt are different exept they have identical id 
		Appointment apt1 = new Appointment("A123", futureDate1, "Dentist");
		Appointment apt2 = new Appointment("A123", futureDate2, "Doctor");
		
		service.addAppointment(apt1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(apt2);
		});
	}
	
	// now to test deleting an appointment 
	@Test
	public void testDelApt() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		Date futureDate = calendar.getTime();
		// add the new appointment 
		Appointment apt = new Appointment("A123", futureDate, "Doctor");
		service.addAppointment(apt);
		//now delete that appointent using its id
		service.deleteApt("A123");
		assertNull(service.getAppointment("A123"));
	}

}