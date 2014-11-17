import org.junit.*;
import static org.junit.Assert.*;

public class ArrayListTest extends ListTest {

	public List getEmptyList() {
		return new ArrayList();
	}

	@Test 
	public void testOverflow() {
		ArrayList testArrayList = new ArrayList(2);
		assertFalse(testArrayList.add(new Integer(1)).hasError());
		assertFalse(testArrayList.add(new Integer(2)).hasError());
		assertFalse(testArrayList.add(new Integer(3)).hasError());
		assertEquals(3, testArrayList.get(2).getReturnValue());
		assertEquals(2, testArrayList.get(1).getReturnValue());
		assertEquals(1, testArrayList.get(0).getReturnValue());
	}

}