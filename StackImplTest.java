import org.junit.*;
import static org.junit.Assert.*;

public class StackImplTest extends StackTest {

	public Stack getEmptyStack() {
		return new StackImpl();
	}

}