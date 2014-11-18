import org.junit.*;
import static org.junit.Assert.*;

public abstract class StackTest {

	/**
	 * Must be implemented by subclasses to create an
	 * empty Stack of the class to be tested.
	 * @return an empty Stack to be tested.
	**/
	public abstract Stack getEmptyStack();

	
	@Test
	public void testIsEmpty() {
		Stack testStack = getEmptyStack();
		assertTrue(testStack.isEmpty());
	}

	@Test
	public void testInitialSize() {
		Stack testStack = getEmptyStack();
		assertEquals(0, testStack.size());	
	}

	@Test
	public void testTopFromEmptyStack() {
		Stack testStack = getEmptyStack();
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, testStack.top().getError());	
	}

	@Test
	public void testPopFromEmptyStack() {
		Stack testStack = getEmptyStack();
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, testStack.pop().getError());	
	}

	@Test
	public void testPushPop() {
		Stack testStack = getEmptyStack();
		testStack.push(new Integer(1));
		testStack.push(new Integer(2));
		testStack.push(new Integer(3));
		assertEquals(3, testStack.size());
		assertEquals(3, testStack.pop().getReturnValue());
		assertEquals(2, testStack.pop().getReturnValue());
		assertEquals(1, testStack.pop().getReturnValue());
		assertEquals(0, testStack.size());
	}
}
	