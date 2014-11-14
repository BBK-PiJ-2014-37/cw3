/**
 * A wrapper containing either an object (the result of an operation
 * on a data structure) or an error value.
 *
 * @author Joel Armando
 */
public class ReturnObjectImpl implements ReturnObject {
	private ErrorMessage errorMessage;
	private Object value;

	public ReturnObjectImpl(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
		this.value = null;
	}

	public ReturnObjectImpl(Object value) {
		this.errorMessage = ErrorMessage.NO_ERROR;
		this.value = value;
	}

	/**
	 * Returns whether there has been an error
	 * @return whether there has been an error
	 */
	public boolean hasError() {
		return getError() != ErrorMessage.NO_ERROR;
	}

	/**
	 * Returns the error message. 
	 * 
	 * This method must return NO_ERROR if and only if
	 * {@hasError} returns false.
	 * 
	 * @return the error message
	 */
	public ErrorMessage getError() {
		return errorMessage;
	}

	/**
	 * Returns the object wrapped in this ReturnObject, i.e. the
	 * result of the operation if it was successful, or null if
	 * there has been error.
	 * 
	 * Note that the output of this method must be null if {@see
	 * hasError} returns true, but the opposite is not true: if
	 * {@see hasError} returns false, this method may or may not
	 * return null.
	 * 
	 * @return the return value from the method or null if there has been an
	 *         error
	 */
	public Object getReturnValue() {
		if (hasError()) {
			return null;
		} else {
			return value;
		}
	}
}
																												