
package model;

public class NotEnoughBallsException extends RuntimeException{
	public NotEnoughBallsException() {
		
    	super("Trainer has ran out of Safair Balls!");
    }
}
