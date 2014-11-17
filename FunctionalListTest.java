import org.junit.*;
import static org.junit.Assert.*;

public abstract class FunctionalListTest extends ArrayListTest {

	public abstract FunctionalList getEmptyList();

	@Test 
	public void testHeadEmptyList() {
		FunctionalList originalList = this.getEmptyList();
    	ReturnObject ret = originalList.head();
    	assertEquals(ErrorMessage.EMPTY_STRUCTURE, ret.getError());
    }

    @Test 
    public void testTailEmptyList() {
    	FunctionalList originalList = this.getEmptyList();
    	FunctionalList rest = originalList.rest();
    	assertNull(rest);        
    }

    @Test 
    public void testHeadThreeElementList() {
    	FunctionalList originalList = (FunctionalList)this.getThreeElementList();
    	ReturnObject ret = originalList.head();
    	assertFalse(ret.hasError());
    	Object head = ret.getReturnValue();
    	assertEquals(1, head);
    	FunctionalList rest = originalList.rest();
    	assertEquals(2,rest.size());
    	assertEquals(3, originalList.size());
    	ret = rest.head();
    	assertFalse(ret.hasError());
    	head = ret.getReturnValue();
    	assertEquals(2, head);
    	rest = rest.rest();
    	assertEquals(1,rest.size());
    	assertEquals(3, originalList.size());
    	ret = rest.head();
    	assertFalse(ret.hasError());
    	head = ret.getReturnValue();
    	assertEquals(3, head);
    	rest = rest.rest();
    	assertEquals(0,rest.size());
    	assertEquals(3, originalList.size());
    }

     public void testOriginalAndRestSeparate() {
    	FunctionalList originalList = (FunctionalList)this.getThreeElementList();
    	FunctionalList rest = originalList.rest();
    	ReturnObject ret = originalList.add(new Integer(4));
    	assertFalse(ret.hasError());
    	assertEquals(2, rest.size());
    }
}
