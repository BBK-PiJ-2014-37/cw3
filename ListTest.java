import org.junit.*;
import static org.junit.Assert.*;

public abstract class ListTest {

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
		assertEquals(0, testList.size());	
	}

	@Test
	public void testGetElementFromEmptyList() {
		List testList = getEmptyList();
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, testList.get(0).getError());	
	}

	@Test
	public void testGetElementFromSingleElementListAtWrongIndex() {
		List testList = getSingleElementList();
		ReturnObject ret = testList.get(1);
		assertTrue(ret.hasError());
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, ret.getError());	
	}

	private void testInsertWorksAtEnd(List testList) {
    	int oldSize = testList.size();
    	Object obj = new Object();
    	ReturnObject ret = testList.add(obj);
    	assertFalse(ret.hasError());
    	assertSame(obj, ret.getReturnValue());
    	assertEquals(oldSize+1, testList.size());
    	ret = testList.get(oldSize);
    	assertFalse(ret.hasError());
    	assertSame(obj, ret.getReturnValue());
	}

	private void testInsertWorksAt(List testList, int index) {
    	int oldSize = testList.size();
    	Object obj = new Object();
    	ReturnObject ret = testList.add(index, obj);
    	assertEquals(ErrorMessage.NO_ERROR, ret.getError());
    	assertSame(obj, ret.getReturnValue());
    	assertEquals(oldSize+1, testList.size());
    	ret = testList.get(index);
    	assertFalse(ret.hasError());
    	assertSame(obj, ret.getReturnValue());
	}

    private void testInsertDoesNotWorkAt(List testList, int index) {
        int oldSize = testList.size();
    	Object obj = new Object();
 		ReturnObject ret = testList.add(index, obj);
	  	assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, ret.getError());
    	assertEquals(oldSize, testList.size());
    }

	@Test
	public void testAddInvalidElement() {
		List testList = getSingleElementList();
		assertEquals(ErrorMessage.INVALID_ARGUMENT, testList.add(null).getError());
	}

	@Test
	public void testAddElementIntoEmptyListAtWrongIndex() {
		List testList = getEmptyList();
		this.testInsertDoesNotWorkAt(testList, 1);	
	}

	@Test
	public void testAddElementIntoEmptyListAtNegativeIndex() {
		List testList = getEmptyList();
		this.testInsertDoesNotWorkAt(testList, -1);	;	
	}

	@Test
	public void testAddElementIntoEmptyListAtBeginning() {
		List testList = getEmptyList();
		this.testInsertWorksAt(testList, 0);
	}

	@Test
	public void testAddElementIntoEmptyListAtEnd() {
		List testList = getEmptyList();
		this.testInsertWorksAtEnd(testList);
	}

	@Test
    public void testAddElementIntoSingleElementListAtIndex0() {
        List testList = getSingleElementList();
  	    this.testInsertWorksAt(testList, 0);
    }

    @Test
   	public void testAddElementIntoSingleElementListAtIndex1() {
        List testList = getSingleElementList();
        this.testInsertWorksAt(testList, 1);
   	}

	@Test
   	public void testAddElementIntoSingleElementListAtIndex2() {
	    List testList = getSingleElementList();
    	this.testInsertDoesNotWorkAt(testList, 2);
    }

	@Test
	public void testAddElementIntoSingleElementListAtEnd() {
		List testList = getSingleElementList();
		this.testInsertWorksAtEnd(testList);
	}

	@Test
    public void testAddElementIntoTwoElementListAtIndex0() {
        List testList = getTwoElementList();
        this.testInsertWorksAt(testList, 0);
    }

    @Test
	public void testAddElementIntoTwoElementListAtIndex1() {
        List testList = getTwoElementList();
        this.testInsertWorksAt(testList, 1);
    } 
    
    @Test   
    public void testAddElementIntoTwoElementListAtIndex2() {
        List testList = getTwoElementList();
        this.testInsertWorksAt(testList, 2);
    }

    @Test
    public void testAddElementIntoTwoElementListAtIndex3() {
        List testList = getTwoElementList();
        this.testInsertDoesNotWorkAt(testList, 3);
    }

	@Test
	public void testAddElementIntoTwoElementListAtEnd() {
		List testList = getTwoElementList();
		this.testInsertWorksAtEnd(testList);
	}

    @Test
    public void testAddElementIntoThreeElementListAtIndex0() {
        List testList = getThreeElementList();
        this.testInsertWorksAt(testList, 0);
    }

    @Test
    public void testAddElementIntoThreeElementListAtIndex1() {
        List testList = getTwoElementList();
        this.testInsertWorksAt(testList, 1);
    } 
    
    @Test   
    public void testAddElementIntoThreeElementListAtIndex2() {
        List testList = getTwoElementList();
        this.testInsertWorksAt(testList, 2);
    }
    @Test   
    public void testAddElementIntoThreeElementListAtIndex3() {
        List testList = getThreeElementList();
        this.testInsertWorksAt(testList, 3);
    }

	@Test
    public void testAddElementIntoThreeElementListAtIndex4() {
        List testList = getThreeElementList();
        this.testInsertDoesNotWorkAt(testList, 4);
    }

	@Test
	public void testAddElementIntoThreeElementListAtEnd() {
		List testList = getThreeElementList();
		this.testInsertWorksAtEnd(testList);
	}

	private void testRemoveElementWorksAt(List testList, int index) {
		int oldSize = testList.size();
		Object nextObject = null;
		if (index < oldSize-1) {
			nextObject = testList.get(index+1).getReturnValue();
		}
		ReturnObject gotten = testList.get(index);
		assertFalse(gotten.hasError());
		ReturnObject removed = testList.remove(index);
		assertFalse(removed.hasError());
		assertEquals(oldSize-1, testList.size());
		assertSame(gotten.getReturnValue(), removed.getReturnValue());
		ReturnObject after = testList.get(index);
		assertSame(nextObject, after.getReturnValue());
	}

	private void testRemoveElementDoesNotWorkAt(List testList, int index) {
		int oldSize = testList.size();
		ReturnObject ret = testList.get(index);
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, testList.remove(index).getError());	
		assertEquals(oldSize, testList.size());
	}

	@Test
	public void testRemoveElementAtNegativeIndex() {
		List testList = getSingleElementList();
		this.testRemoveElementDoesNotWorkAt(testList, -1);	
	}

	@Test
	public void testRemoveElementFromEmptyList() {
		List testList = getEmptyList();
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, testList.remove(0).getError());	
	}

	@Test
    public void testRemoveElementFromSingleElementListAtIndex0() {
        List testList = getSingleElementList();
        this.testRemoveElementWorksAt(testList, 0);
    }

    @Test
	public void testRemoveElementFromSingleElementListAtIndex1() {
		List testList = getSingleElementList();
		this.testRemoveElementDoesNotWorkAt(testList, 1);	
	}

	@Test
    public void testRemoveElementFromTwoElementListAtIndex0() {
        List testList = getTwoElementList();
        this.testRemoveElementWorksAt(testList, 0);
    }

    @Test
    public void testRemoveElementFromTwoElementListAtIndex1() {
        List testList = getTwoElementList();
        this.testRemoveElementWorksAt(testList, 1);
    }

    @Test
    public void testRemoveElementFromTwoElementListAtIndex2() {
        List testList = getTwoElementList();
        this.testRemoveElementDoesNotWorkAt(testList, 2);
    }

    @Test
    public void testRemoveElementFromThreeElementListAtIndex0() {
        List testList = getThreeElementList();
        this.testRemoveElementWorksAt(testList, 0);
    }

    @Test
    public void testRemoveElementFromThreeElementListAtIndex1() {
        List testList = getThreeElementList();
        this.testRemoveElementWorksAt(testList, 1);
    }

    @Test
    public void testRemoveElementFromThreeElementListAtIndex2() {
        List testList = getThreeElementList();
        this.testRemoveElementWorksAt(testList, 2);
    }

    @Test
    public void testRemoveElementFromThreeElementListAtIndex3() {
        List testList = getThreeElementList();
        this.testRemoveElementDoesNotWorkAt(testList, 3);
    }

}