/**
 * A List, implemented as a single-listed list.
 * 
 * @author Joel Armando
 */
public class LinkedList implements List {
	private SingleNode head;
	
	public LinkedList() {
		this.head = null;
	}

	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
	public int size() {
		int i = 0;
		SingleNode node = head;
		while (node != null) {
			node = node.getNext();
			i++;
		}
		return i;
	}

	/**
	 * Returns the elements at the given position. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject get(int index) {
		int i = 0;
		SingleNode node = head;

		if (node == null) {
			return new ReturnObjectImpl (ErrorMessage.EMPTY_STRUCTURE);
		}
		if (index < 0) {
			return new ReturnObjectImpl (ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		while (i < index && node != null) {
			node = node.getNext();
			i++;		
		}
		if (node == null) {
			return new ReturnObjectImpl (ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		return new ReturnObjectImpl(node.getValue());
	}

	/**
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject remove(int index){
		if (head == null)
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		if (index == 0) {
			SingleNode oldHead = head;
			head = head.getNext();
			oldHead.setNext(null);
			return new ReturnObjectImpl(oldHead.getValue());
		}
		int i = 0;
		SingleNode node = head;
		while (i < index-1 && node != null) {
			node = node.getNext();
			i++;
		}
		if (node != null && node.getNext() != null) {
			SingleNode oldNode = node.getNext();
			node.setNext(oldNode.getNext());
			oldNode.setNext(null);
			return new ReturnObjectImpl(oldNode.getValue());
		}
		return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
	}

	/**
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         the item added or containing an appropriate error message
	 */
	public ReturnObject add(int index, Object item) {
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		if (index == 0) {
			SingleNode oldHead = head;
			head = new SingleNode(item);
			head.setNext(oldHead);
			return new ReturnObjectImpl(item);
		}

		int i = 0;
		SingleNode node = head;
		while (i < index-1 && node != null) {
			node = node.getNext();
			i++;
		}
		if (node != null) {
			SingleNode newNode = new SingleNode(item);
			newNode.setNext(node.getNext());
			node.setNext(newNode);
			return new ReturnObjectImpl(item);
		}
		return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
	}

	/**
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         the item added or containing an appropriate error message
	 */
	public ReturnObject add(Object item) {
		return this.add(this.size(), item);
	}
}
