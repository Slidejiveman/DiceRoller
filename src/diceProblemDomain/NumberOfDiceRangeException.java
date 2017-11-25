package diceProblemDomain;

/**
 * NumberOfDiceRangeException is a user made exception object that is thrown if there are a
 * negative number of dice in a particular dice bag. This object inherits from the exception class 
 * and sends a message to be caught to its caller.
 * @author RyderDale
 * @package diceProblemDomain
 */
@SuppressWarnings("serial")
public class NumberOfDiceRangeException extends Exception
{
	NumberOfDiceRangeException(String message)
	{
		super(message);
	}
}
