package taskservice;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {
	
	//Start this off with a test for creating a valid task
	@Test
	public void testTaskCreate() { 
		Task task = new Task("12345", "Roger Test", "Description Test");
		assertEquals("12345", task.getTaskId());
		assertEquals("Roger Test", task.getName());
		assertEquals("Description Test", task.getDescription());
	}
	
	
	// Test that the task ID cant be null
	@Test
	public void testTaskIdNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			Task task= new Task(null, "Rpger Test", "Description Test");
		});
	}
	
	// Test the ID length
	@Test
	public void testTaskIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("10101010101101010110", "Roger Test", "Description Test");
		});
	}
	
	// Test for the name length
	@Test
	public void testNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("12345", "Roger Test Is way too long", "Description Test");
		});
	}
	
	// Test for the name being null 
	@Test
	public void testNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			Task task= new Task("12345", null, "Description Test");
		});
	}
	
	// Test for the description being null 
	@Test
	public void testDescriptionNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			Task task= new Task("12345", "Roger Test", null);
		});
	}
	// Test for the Description length
	@Test
	public void testDescriptionTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("12345", "Roger Test", "Description Test for being way too long for the peramiters set in this weeks module stating that it cant be more than 50 characters");
		});
	}
	
	
	
	// This is testing the updating name func
	@Test
	public void testSetname() {
		Task task = new Task("12345", "Roger Test", "Description Test");
		task.setName("Billy");
		assertEquals("Billy", task.getName());
	}
	
	// This is testing the updating Description func
	@Test
	public void testSetDescription() {
		Task task = new Task("12345", "Roger Test", "Description Test");
		task.setDescription("This is a new Description");
		assertEquals("This is a new Description", task.getDescription());
	}
	
	
}
