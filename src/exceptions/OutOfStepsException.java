
package exceptions;

/**
 * Runtime Exception thrown when the player is out of steps
 *
 */
public class OutOfStepsException extends RuntimeException{
	public OutOfStepsException() {
		
    	super("You have ran out of steps!");
    }
}
