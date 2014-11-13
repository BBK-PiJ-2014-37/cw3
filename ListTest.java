import org.junit.*;
import static org.junit.Assert.*;

abstract class ListTest {

	/**
	 * Must be implemented by subclasses to create an
	 * empty list of the class to be tested.
	 * @return an empty list to be tested.
	**/
	public abstract List getEmptyList();

	/**
	 * @return the list [1]
	**/
	public List getSingleElementList() {
		List aList = getEmptyList();
		aList.add(new Integer(1)); 
		return aList;
	}

	/**
	 * @return the list [1, 2]
	**/
	public List getTwoElementList() {
		List aList = getSingleElementList();
		aList.add(new Integer(2)); 
		return aList;
	}

	/**
	 * @return the list [1, 2, 3]
	**/
	public List getThreeElementList() {
		List aList = getTwoElementList();
		aList.add(new Integer(3)); 
		return aList;
	}

	@Test
	public void testIsEmpty() {
		List testList = getEmptyList();
		assertTrue(testList.isEmpty());
	}

	@Test
	public void testInitialSize() {
		List testList = getEmptyList();
		assertEquals(testList.size(), 0);	
	}

	@Test
	public void testGetElementFromEmptyList() {
		List testList = getEmptyList();
		assertEquals(testList.get(0).getError(), ErrorMessage.EMPTY_STRUCTURE);	
	}

	@Test
	public void testRemoveElementFromEmptyList() {
		List testList = getEmptyList();
		assertEquals(testList.remove(0).getError(), ErrorMessage.EMPTY_STRUCTURE);	
	}

	@Test
	public void testInsertElementIntoEmptyListAtWrongIndex() {
		Object obj = new Object();
		List testList = getEmptyList();
		assertEquals(testList.add(1, obj).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);	
	}

	@Test
	public void testInsertElementIntoEmptyListAtNegativeIndex() {
		Object obj = new Object();
		List testList = getEmptyList();
		assertEquals(testList.add(-1, obj).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);	
	}

	@Test
	public void testInsertElementIntoEmptyListAtBeginning() {
		Object obj = new Object();
		List testList = getEmptyList();
		assertEquals(testList.add(0, obj).getError(), ErrorMessage.NO_ERROR);
		assertEquals(testList.size(), 1);
		ReturnObject ret = testList.get(0);
		assertFalse(ret.hasError());
		assertSame(ret.getReturnValue(), obj);
	}

	@Test
	public void testInsertElementIntoEmptyListAtEnd() {
		Object obj = new Object();
		List testList = getEmptyList();
		assertEquals(testList.add(obj).getError(), ErrorMessage.NO_ERROR);
		assertEquals(testList.size(), 1);
		ReturnObject ret = testList.get(0);
		assertFalse(ret.hasError());
		assertSame(ret.getReturnValue(), obj);
	}

	@Test
	public void testInsertInvalidElement() {
		List testList = getSingleElementList();
		assertEquals(testList.add(null).getError(), ErrorMessage.INVALID_ARGUMENT);
	}
	@Test
	public void testGetElementFromOneElementListAtWrongIndex() {
		List testList = getSingleElementList();
		ReturnObject ret = testList.get(1);
		assertFalse(ret.hasError());
		assertEquals(ret.getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);	
	}

	@Test
	public void testRemoveElementFromOneElementListAtWrongIndex() {
		List testList = getSingleElementList();
		assertEquals(testList.remove(1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);	
	}
	
}