
package exceptions;

/**
 * Runtime exception thrown when the player is out Safari Balls
 * 
 */
public class NotEnoughBallsException extends RuntimeException{
	public NotEnoughBallsException() {
		
    	super("Trainer has ran out of Safair Balls!");
    }
}
