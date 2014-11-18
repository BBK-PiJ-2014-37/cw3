import org.junit.*;
import static org.junit.Assert.*;


public class SampleableArrayListTest extends ListTest {

	public List getEmptyList() {
		return new SampleableArrayList();
	}

	@Test
	public void testSampling() {
		SampleableArrayList sampleableList = (SampleableArrayList)getEmptyList();
		assertFalse(sampleableList.add(new Integer(1)).hasError());
		assertFalse(sampleableList.add(new Integer(2)).hasError());
		assertFalse(sampleableList.add(new Integer(3)).hasError());
		assertFalse(sampleableList.add(new Integer(4)).hasError());
		assertFalse(sampleableList.add(new Integer(5)).hasError());
		assertFalse(sampleableList.add(new Integer(6)).hasError());
		SampleableArrayList newSampleableList =  sampleableList.sample();
		assertEquals(1, newSampleableList.get(0));
		assertEquals(3, newSampleableList.get(2));
		assertEquals(5, newSampleableList.get(4));
	}
}
