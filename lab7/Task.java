package labs.lab7;
/**
* Class for creating a priority To Do list.
*/
public class Task implements Comparable {
	// ADD INSTANCE VARIABLES HERE
	private int priority;
	private String desc;
	
	/**
	* Constructor
	*
	* @param description The description of the task.
	* @param priority The priority of the task.
	*/
	public Task(int priority, String description) {
		this.priority = priority;
		desc = description;
	}
	
	/**
	* @return the priority
	*/
	public int getPriority() {
		return priority; // FIX ME
	}
	
	/**
	* @return the task description
	*/
	public String getDescription() {
		return desc; // FIX ME
	}
	
	@Override
	public int compareTo(Object otherObject) {
		Task obj = (Task) otherObject;
		
		if (priority > obj.priority) return 1;
		if (priority < obj.priority) return -1;
		return 0;
	}
}
