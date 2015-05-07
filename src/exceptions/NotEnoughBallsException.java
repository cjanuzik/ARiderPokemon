
package exceptions;

/**
 * Runtime exception thrown when the player is out Safari Balls
 * 
 */
public class NotEnoughBallsException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotEnoughBallsException() {
		
    	super("Trainer has ran out of Safair Balls!");
    }
}
