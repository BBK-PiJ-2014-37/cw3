/**
 * A sampleable list can be sampled. 
 * 
 * @author Joel Armando
 */
public class SampleableArrayList extends ArrayList implements SampleableList  {

	public SampleableArrayList(int capacity) {
		super(capacity);
	}

	public SampleableArrayList() {
		super();
	}

	/**
	 * Returns a list containing the first, third, fifth...
	 * items of this list, or an empty list if the list is empty. 
	 * 
	 * @return a list containing the first, third, fifth... items of this list
	 */
	public SampleableArrayList sample() {
		int size = this.size();
		int newSize = (size+1)/2;
		SampleableArrayList newList = new SampleableArrayList(newSize);
		int i = 0;
		while (i < newSize) {
			newList.add(this.get(i*2).getReturnValue());
			i++;
		}
		return newList;
	}
}
