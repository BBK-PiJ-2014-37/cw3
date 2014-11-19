import org.junit.*;
import static org.junit.Assert.*;

public class ImprovedStackImplTest extends StackTest {

	public Stack getEmptyStack() {
		return new ImprovedStackImpl();
	}

	@Test 
	public void testReverse() {
		ImprovedStack oldStack = (ImprovedStackImpl)getEmptyStack();
		oldStack.push(new Integer(1));
		oldStack.push(new Integer(2));
		oldStack.push(new Integer(3));
		ImprovedStack newStack = oldStack.reverse();
		assertEquals(3, newStack.size());
		assertEquals(3, oldStack.size());
		assertEquals(1, newStack.pop().getReturnValue());
		assertEquals(2, newStack.pop().getReturnValue());
		assertEquals(3, newStack.pop().getReturnValue());
		assertEquals(3, oldStack.pop().getReturnValue());
		assertEquals(2, oldStack.pop().getReturnValue());
		assertEquals(1, oldStack.pop().getReturnValue());
	}

	@Test
	public void testRemove() {
		ImprovedStack oldStack = (ImprovedStackImpl)getEmptyStack();
		oldStack.push(new Integer(1));
		oldStack.push(new Integer(2));
		oldStack.push(new Integer(1));
		oldStack.push(new Integer(1));
		oldStack.push(new Integer(3));
		oldStack.push(new Integer(1));
		oldStack.remove(new Integer(1));
		assertEquals(2, oldStack.size());
		assertEquals(3, oldStack.pop().getReturnValue());
		assertEquals(2, oldStack.pop().getReturnValue());
	}

}