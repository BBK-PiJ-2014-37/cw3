import org.junit.*;
import static org.junit.Assert.*;

public class ReturnObjectImplTest {
	@Test
	public void testHasError() {
		ReturnObjectImpl testObject = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		assertTrue(testObject.hasError());
		assertNull(testObject.getReturnValue());
	}
	
	@Test
	public void testGetError() {
		ReturnObjectImpl testObject = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		assertEquals(testObject.getError(), ErrorMessage.EMPTY_STRUCTURE);
		assertNull(testObject.getReturnValue());
	}

	@Test
	public void testNoError() {
		Integer testInteger = new Integer(42);
		ReturnObjectImpl testObject = new ReturnObjectImpl(testInteger);
		assertFalse(testObject.hasError());
		assertSame(testObject.getReturnValue(), testInteger);
	}

}