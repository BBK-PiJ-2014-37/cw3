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
		assertTrue(testArrayList.add(new Integer(3)).hasError());
	}

}