package diceProblemDomain;

/**
 * NumberOfFacesRangeException is a user made exception object that is thrown if there are a
 * negative number of faces on a particular die. This object inherits from the exception class 
 * and sends a message to be caught to its caller.
 * @author RyderDale
 * @package diceProblemDomain
 */

@SuppressWarnings("serial")					// Prevents unnecessary warnings from displaying
//"extends" means this program uses inheritance from the Exception class
public class NumberOfFacesRangeException extends Exception
{
	NumberOfFacesRangeException(String message)
	{
		super(message);
	}
}
