package taskservice;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TaskServiceTest {
	private TaskService taskService;
	
	
	//set up to run before the tests 
	@BeforeEach
	public void setUp() {
		taskService = new TaskService();
	}
	
	
	//First testing adding a task
	@Test
	public void testAddTask() {
		Task task = new Task("12345", "Roger Test", " This is a test for the description");
		taskService.addTask(task);
		assertEquals(task, taskService.getTask("12345"));
	}
	
	
	// Test that if there are multiple of the same ID it throws an exception
	@Test
	public void testAddDupTask() {
		Task task1 = new Task("12345", "Roger one",  "first task");
		Task task2 = new Task("12345", "Roger two", "second task");
		
		taskService.addTask(task1);
		
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(task2);
		});
	}
	
	//test for deleting a task
	@Test
	public void testDeleteTask() {
		Task task = new Task("12345", "Roger Test", " This is a test for the description");
		taskService.addTask(task);
		
		taskService.deleteTask("12345");
		
		assertNull(taskService.getTask("12345"));
	}
	
	
	
	//Now testing deleting a non existant task
	@Test
	public void testDeleteNoRealTask() {
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.deleteTask("054321");
		});
	}
	
	
	//Test updating the tasks name
	@Test
	public void testUpdateTaskName() {
		Task task = new Task("12345", "Roger Test", " This is a test for the description");
		taskService.addTask(task);
		
		taskService.updateTaskName("12345", "Billy");
		
		assertEquals("Billy", taskService.getTask("12345").getName());
	}
	 
	
	// Test case for updating the task description 
	@Test
	public void testUpdateTaskDescription() {
		Task task = new Task("12345", "Roger Test", " First Description");
		taskService.addTask(task);
		
		taskService.updateTaskDescription("12345", "New Description");
		
		assertEquals("New Description", taskService.getTask("12345").getDescription());
	}
	
	
	//Now testing updating a non existant Description
	@Test
	public void testUpdateDescriptionNoRealTask() {
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTaskDescription("054321", "No Real Description");
		});
	}
	
	
	
	
	
	//Lastly test the get method for tasks that dont exist
	@Test
	public void testGetNoRealTask() {
		assertNull(taskService.getTask("054321"));
	}

}
