import org.junit.*;
import static org.junit.Assert.*;

public abstract class SingleNodeTest {

  @Test
  public void testGetValue() {
    Object object = new Object();
    SingleNode nodeTest = new SingleNode(object);
    assertSame(object, nodeTest.getValue());
  }

  @Test
  public void testSetGetNext() {
      Object object = new Object();
      Object nextObject = new Object();
      SingleNode nodeTest = new SingleNode(object);
      SingleNode nextNode = new SingleNode(nextObject);
      nodeTest.setNext(nextNode);
      assertSame(nextObject, nodeTest.getNext());
  }
}

