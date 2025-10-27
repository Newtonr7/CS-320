package appointmentservice;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

public class AppointmentTest {

	//start out with testing creating an appointment 
	@Test
	public void testAptCreation() {
		// Create a date in the future (month out )
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		Date futureDate = calendar.getTime();
		//The info for the appointment
		Appointment apt = new Appointment("A123", futureDate, "Doctor");
		assertEquals("A123", apt.getAptId());
		assertEquals(futureDate, apt.getAptDate());
		assertEquals("Doctor", apt.getAptDescription());
	}
	
	// This is to test the length of the aappointmentId
	@Test
	public void testAptIdTooLong() {
		// to set the calendar and add a furtue date for the appointment 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		Date futureDate = calendar.getTime();
		
		assertThrows(IllegalArgumentException.class,() -> {
			new Appointment("A123456789123456789", futureDate, "Oil Change");
		});
	}
	
	//test if the apointmentID is null 
	@Test
	public void testAptIdNull() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		Date futureDate = calendar.getTime();
		
		assertThrows(IllegalArgumentException.class,() -> {
			new Appointment(null, futureDate, "Dentist");
		});
	}
	
	// test apt date for null
	@Test
	public void testAptDateNull() {
		assertThrows(IllegalArgumentException.class,() -> {
			new Appointment("A123", null, "Therapy");
		});
	}
	// test a past date 
	@Test
	public void testAptDateInPast() {
		// Create a date in the past
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		Date pastDate = calendar.getTime();
		
		assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("R123", pastDate, "Doctor");
		});
	}
	
	// For the description test its length
	@Test
	public void testAptDescriptionTooLong() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		Date futureDate = calendar.getTime();
		
		assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("A123", futureDate, "This description is too long and exceeds the fifty character limit for sure but if not i will keep writing just to be safe I hope you enjoy this message");
		});
	}	
	// now test if null
	@Test
	public void testAptDescriptionNull() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		Date futureDate = calendar.getTime();
		
		assertThrows(IllegalArgumentException.class,() -> {
			new Appointment("A123", futureDate, null);
		});
	}
	
	
	
	
	// now  the length and null tests are done 
	// moving on to testing the update apointment function
	// not updating the ID... only the date and description
	@Test
	public void testUpdateAptDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		Date futureDate = calendar.getTime();
		
		Appointment apt = new Appointment("A123", futureDate, "Tire Change");
		
		// Create new future date 
		calendar.add(Calendar.MONTH, 1);
		Date newDate = calendar.getTime();
		
		apt.setAptDate(newDate);
		assertEquals(newDate, apt.getAptDate());
	}
	
	// test updating the description
	@Test
	public void testUpdateAptDescription() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		Date futureDate = calendar.getTime();
		
		Appointment apt = new Appointment("R123", futureDate, "Dentist");
		apt.setAptDescription("Hair Cut");
		assertEquals("Hair Cut", apt.getAptDescription());
	}
	
	

}