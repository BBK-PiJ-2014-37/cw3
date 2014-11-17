/**
 * A List, implemented with an Array.
 * 
 * 
 * @author Joel Armando
 */
public class ArrayList implements List {
	Object array[];
	int length;

	public ArrayList(int capacity) {
		this.array = new Object[capacity];
		this.length = 0;
	}

	public ArrayList() {
		this(10);
	}

	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		return this.length == 0;
	}

	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
	public int size() {
		return this.length;
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
		if (this.isEmpty()) {
			return new ReturnObjectImpl (ErrorMessage.EMPTY_STRUCTURE);
		}
		if (index < 0 || index >= this.size()) {
			return new ReturnObjectImpl (ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		return new ReturnObjectImpl(this.array[index]);
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
	public ReturnObject remove(int index) {
		if (this.isEmpty()) {
			return new ReturnObjectImpl (ErrorMessage.EMPTY_STRUCTURE);
		}
		if (index < 0 || index >= this.size()) {
			return new ReturnObjectImpl (ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		Object value = array[index];
		while (index < this.size() - 1) {
			this.array[index] = this.array[index+1]; 
			index++;
		}
		this.length--;
		return new ReturnObjectImpl(value);
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
		if (index < 0 || index > this.size()) {
			return new ReturnObjectImpl (ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		if (this.length == array.length) {
			Object newArray[] = new Object[array.length * 2];
			int i = 0;
			while (i < this.length) {
				newArray[i] = array[i];
				i++;
			}
			array = newArray;
		}

		int i = this.size();
		while (i > index) {
			this.array[i] = this.array[i-1]; 
			i--;
		}
		this.array[index] = item;
		this.length++;
		return new ReturnObjectImpl(item);
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
