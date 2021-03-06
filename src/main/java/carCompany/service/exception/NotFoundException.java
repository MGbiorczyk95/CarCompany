package carCompany.service.exception;

/**
 * Exception for avoid null objects
 * 
 * @author RWEYCHAN
 *
 */
public class NotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5672338599002092515L;

	/**
	 * Object was not found and is null.
	 * 
	 * @param message
	 *            What kind of object wasn't found
	 */
	public NotFoundException(String message) {
		super(message);

	}
}
