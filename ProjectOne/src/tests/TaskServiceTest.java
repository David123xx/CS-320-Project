package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import taskService.Task;
import taskService.TaskService;

class TaskServiceTest {
	//default parameters for tests
	//ID strings
	String goodID = "1234567890", longID = "12345678901", nullID = null;
	//name strings
	String goodName = "12345678901234567890", longName = "123456789012345678901", nullName = null;
	//description strings
	String goodDesc = "12345678901234567890123456789012345678901234567890", 
			longDesc = "123456789012345678901234567890123456789012345678901",
			nullDesc = null;

	@Test
	void testAddTasks() {
		//section tests the addition of good task
		TaskService serviceTest1 = new TaskService();
		Task test = new Task(goodID, goodName, goodDesc);
		serviceTest1.addTask(test);
		assertTrue(serviceTest1.findID(test.getID()));
		//checks if it throws illegal argument for null id
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			TaskService serviceTest = new TaskService();
			Task test2 = new Task(nullID, goodName, goodDesc);
			serviceTest.addTask(test2);
			} );
		//checks it throws illegal argument for long id
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			TaskService serviceTest = new TaskService();
			Task test2 = new Task(longID, goodName, goodDesc);
			serviceTest.addTask(test2);
			} );
		//checks it throws illegal argument for same id
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			TaskService serviceTest = new TaskService();
			Task test1 = new Task(goodID, goodName, goodDesc);
			Task test2 = new Task(goodID, goodName, goodDesc);
			serviceTest.addTask(test1);
			serviceTest.addTask(test2);
			} );

	}
	@Test
	void testDeleteTasks() {
		TaskService serviceTest1 = new TaskService();
		Task test1 = new Task("1", goodName, goodDesc);
		Task test2 = new Task("2", goodName, goodDesc);
		serviceTest1.addTask(test1);
		serviceTest1.addTask(test2);
		//removes task with id "1"
		assertTrue(serviceTest1.removeTask("1"));
		//tries to remove it again
		assertFalse(serviceTest1.removeTask("1"));
		//removes other task
		assertTrue(serviceTest1.removeTask("2"));
		//was not a task actually created
		assertFalse(serviceTest1.removeTask("3"));
		
	}
	@Test
	void testChangeName() {
		TaskService serviceTest = new TaskService();
		Task test = new Task(goodID, goodName, goodDesc);
		serviceTest.addTask(test);
		
		assertTrue(serviceTest.updateName(goodID,"good"));
		assertFalse(serviceTest.updateName("123", "bad"));
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			serviceTest.updateName(goodID, longName);
			} );
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			serviceTest.updateName(goodID, nullName);
			} );
		
	}
	@Test
	void testChangeDesc() {
		TaskService serviceTest = new TaskService();
		Task test = new Task(goodID, goodName, goodDesc);
		serviceTest.addTask(test);
		
		assertTrue(serviceTest.updateDescription(goodID,"good"));
		assertFalse(serviceTest.updateDescription("123", "bad"));
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			serviceTest.updateDescription(goodID, longDesc);
			} );
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			serviceTest.updateDescription(goodID, nullDesc);
			} );
	}

}
