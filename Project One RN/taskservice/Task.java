// start by introducing taskID, name, and description 
package taskservice;

public class Task {
	private String taskId;
	private String name;
	private String description;
	// Now we call on them to put in peramiters shown in the directions
	public Task(String taskId, String name, String description) {
		// taskID cant be null and has to be 10 char or less
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("The Task ID cant be null and has to be 10 characters or less");
		}
		// Name cant be null and has to be 20 char or less
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("The name cant be null and has to be 20 characters or less");
		}
		// Description cant be null and has to be = 50 char or less
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("The Description cant be null and has to be 50 characters or less");
		}
		// Making the this values = to values
		this.taskId = taskId;
		this.name = name;
		this.description = description;
	}
	
	// The get methods for TaskID
	 public String getTaskId() {
		 return taskId;
	 }
	 // The get method for Name
	 public String getName() {
		 return name;
	 }
	 // The get method for the Description
	 public String getDescription() {
		 return description;
	 }
	 // now the set method for name, using the same peramiters used before 
	 public void setName(String name) {
		 if (name == null || name.length() > 20) {
			 throw new IllegalArgumentException("The Name cant be null and has to be 20 characters or less");
		 }
		 //make the this Name = name 
		 this.name = name;
		 
	 }
	 // The set method for Description
	 public void setDescription(String description) {
		 if (description == null || description.length() > 50) {
			 throw new IllegalArgumentException("The Description cant be null and has to be 50 characters or less");
		 }
		 // Now make this description = description 
		 this.description = description;
	 }
	 
}
