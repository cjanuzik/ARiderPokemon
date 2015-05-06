
package model;

public class OutOfStepsException extends RuntimeException{
	public OutOfStepsException() {
		
    	super("You have ran out of steps!");
    }
}
