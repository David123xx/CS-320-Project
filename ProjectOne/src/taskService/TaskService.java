package taskService;

import java.util.ArrayList;

public class TaskService {
	public ArrayList<Task> TaskList;
	
	public TaskService() {
		TaskList = new ArrayList<Task>();
	}
	public void addTask(Task newTask) {
		for(Task task : TaskList) {
			if(newTask.getID() == task.getID()) {
				throw new IllegalArgumentException("ID must be unique");
			}
		}
		TaskList.add(newTask);
	}
	public boolean removeTask(String taskID) {
		for(Task task: TaskList) {
			if(taskID.equals(task.getID())) {
				TaskList.remove(task);
				return true;
			}
		}
		return false;
	}
	public boolean updateName(String taskID, String inputName) {
		for (Task task : TaskList) {
			if(taskID.equals(task.getID())) {
				task.setName(inputName);
				return true;
			}
		}
		return false;
	}
	public boolean updateDescription(String taskID, String inputDescription) {
		for(Task task : TaskList) {
			if(taskID.equals(task.getID())) {
				task.setDescription(inputDescription);
				return true;
			}
		}
		return false;
	}
	// for testing purposes
	public boolean findID(String taskID) {
		for(Task task: TaskList) {
			if(taskID.equals(task.getID())) {
				return true;
			}
		}
		return false;
		
	}
	
}
