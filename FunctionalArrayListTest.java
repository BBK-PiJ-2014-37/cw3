import org.junit.*;
import static org.junit.Assert.*;

public class FunctionalArrayListTest extends  FunctionalListTest {

	public FunctionalList getEmptyList() {
		return new FunctionalArrayList();
	}
}