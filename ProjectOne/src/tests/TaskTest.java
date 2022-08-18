package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import taskService.Task;

class TaskTest {
	//default parameters for tests
	//ID strings
	String goodID = "1234567890", longID = "12345678901", nullID = null;
	//name strings
	String goodName = "12345678901234567890", longName = "123456789012345678901", nullName = null;
	//description strings
	String goodDesc = "12345678901234567890123456789012345678901234567890", 
			longDesc = "123456789012345678901234567890123456789012345678901",
			nullDesc = null;
	//tests constuctor works
	@Test
	void testGoodConstructor() {
		Task test = new Task(goodID, goodName, goodDesc);
		assertEquals(goodID, test.getID());
		assertEquals(goodName, test.getName());
		assertEquals(goodDesc, test.getDescription());
		//null ID test
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Task(nullID, goodName, goodDesc);});
		//null name test
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Task(goodID, nullName, goodDesc);});
		//null description
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Task(goodID, goodName, nullDesc);});
		//long ID test
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Task(longID, goodName, goodDesc);});
		//long name test
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Task(goodID, longName, goodDesc);});
		//long description test
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Task(goodID, goodName, longDesc);});
	}
	//tests name change works
	@Test
	void testNameChange() {
		//checks if name change works with good imput
			Task test = new Task(goodID, goodName, goodDesc);
			test.setName("happy");
			assertEquals("happy",test.getName());
		//checks if throws illegal argument with null name change
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			Task test1 = new Task(goodID, goodName, goodDesc);
			test1.setName(nullName);
			} );
		//checks if throws illegal argument with long name
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			Task test2 = new Task(goodID, goodName, goodDesc);
			test2.setName(longName);
			} );
		
		
	}
	@Test
	void testDescriptionChange() {
		//checks if legal argument works
		Task test = new Task(goodID, goodName, goodDesc);
		test.setDescription("happy");
		assertEquals("happy",test.getDescription());
		//checks if throws illegal argument with null description
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			Task test1 = new Task(goodID, goodName, goodDesc);
			test1.setDescription(nullDesc);
			} );
		//checks if throws illegal argument with too long of description
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			Task test1 = new Task(goodID, goodName, goodDesc);
			test1.setName(longDesc);
			} );
		
	}

}
