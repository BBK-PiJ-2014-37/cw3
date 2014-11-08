import org.junit.*;
import static org.junit.Assert.*;

public class ReturnObjectImplTest {
	@Test
	public void testIsError() {
		ReturnObjectImpl testObject = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE, null);
		assertTrue(testObject.hasError());
	}
	
	@Test
	public void testGetError() {
		ReturnObjectImpl testObject = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE, null);
		assertEquals(testObject.getError(), ErrorMessage.EMPTY_STRUCTURE);
	}

	@Test
	public void testIsNotError() {
		Integer testInteger = new Integer(42);
		ReturnObjectImpl testObject = new ReturnObjectImpl(ErrorMessage.NO_ERROR, testInteger);
		assertFalse(testObject.hasError());
	}

	@Test
	public void testGetReturnValue() {
		Integer testInteger = new Integer(42);
		ReturnObjectImpl testObject = new ReturnObjectImpl(ErrorMessage.NO_ERROR, testInteger);
		assertEquals(testObject.getReturnValue(), testInteger);
	}

}