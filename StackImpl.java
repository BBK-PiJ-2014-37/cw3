/**
 * An implementation of a stack, a data structure of type LIFO (Last
 * In, First Out).
 * 
 * * 
 * @author Joel Armando
 */
public class StackImpl extends AbstractStack implements Stack {

	public StackImpl(List list) {
		super(list);
	}

	public StackImpl() {
		super(new LinkedList());
	}

	/**
	 * Returns true if the stack is empty, false otherwise. 
	 * 
	 * @return true if the stack is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		return internalList.isEmpty();
	}

	/**
	 * Returns the number of items currently in the stack.
	 * 
	 * @return the number of items currently in the stack
	 */
	public int size() {
		return internalList.size();
	}

	/**
	 * Adds an element at the top of the stack. 
	 * 
	 * @param item the new item to be added
	 */
	public void push(Object item) {
		internalList.add(0, item);
	}

	/**
	 * Returns the element at the top of the stack. The stack is
	 * left unchanged.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject top() {
		return internalList.get(0);
	}

	/**
	 * Returns the element at the top of the stack. The element is
	 * removed frmo the stack.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject pop() {
		return internalList.remove(0);
	}
}

