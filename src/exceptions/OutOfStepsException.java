
package exceptions;

/**
 * Runtime Exception thrown when the player is out of steps
 *
 */
public class OutOfStepsException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OutOfStepsException() {
		
    	super("You have ran out of steps!");
    }
}
