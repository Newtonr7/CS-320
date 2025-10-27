//  Using a hashmap again since I used this in the last modules assignment 
package taskservice;


import java.util.HashMap;
import java.util.Map;

public class TaskService {
	// This starts off by setting up the HashMap for the task
	private Map<String, Task> tasks = new HashMap<>();
	

	// now we handle the requirement for tasks Unique ID (addTask) 
	public void addTask(Task task) {
		// First check if the task already exists, same method from the task file
		if (tasks.containsKey(task.getTaskId())) {
			throw new IllegalArgumentException("The Task with ID " + task.getTaskId() + " already exists");
		}
		// Once checked that Id is unique, add it to the map
		tasks.put(task.getTaskId(), task);
	}
	
	
	// handle the deletle tasks per ID
	public void deleteTask(String taskId) {
		// Verify it exists first
		if (tasks.containsKey(taskId)) {
			// remove task from the map
			tasks.remove(taskId);
		} else {
			// incase it doesnt exist throw an error
			throw new IllegalArgumentException("Task wasnt found");
		}
	}
	
	
	// This will be to update the name using the task ID
	public void updateTaskName(String taskId, String name) { 
		// Check the ID exists first
		if ( tasks.containsKey(taskId)) {
			//validate
			tasks.get(taskId).setName(name);
		} else {
			//for if it doesnt exist we wont update 
			throw new IllegalArgumentException("Task wasnt found");
		}
	}
	
	
	// Lastly update the Description 
	public void updateTaskDescription(String taskId, String description) { 
		//Check the ID exists first
		if(tasks.containsKey(taskId)) {
			//validate it
			tasks.get(taskId).setDescription(description);
		} else {
			throw new IllegalArgumentException("task wasnt found");
		}
	}
	// used to get tasks if needed
	public Task getTask(String taskId) {
		return tasks.get(taskId);
	}
	
}
