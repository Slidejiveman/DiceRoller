package diceProblemDomain;
/**
 *The Die class creates the individual instances of dice that will be placed into the dicebag for
 *rolling. It uses a random generator associated with the dice. 
 *@author RyderDale
 *@package diceProblemDomain
 */

// Allows use of the random number generator
import java.util.Random;

public class Die
 {
	private int face;		 		 // Current rolled value
	private int numberFaces; 		 // Total number of sides on the die
	private static Random randomGen; // Allows all methods to use same Random obj.
	
	/**
	 * Die is the constructor for the die class. Each time a die is created,
	 * a random number seed is associated with it.
	 * @param numberOfFaces: corresponds to the number of faces on a die
	 * @throws NumberOfFacesRangeException: thrown if faces is a negative value
	 */
	// Constructor
	public Die(int numberOfFaces) throws NumberOfFacesRangeException
	{
		// Each object keeps track of its own seed
		this.setNumberFaces(numberOfFaces);
		
		// If there isn't a die created, create and seed. Happens only the first time.
		if (Die.randomGen == null)		// null checks that this hasn't been done at all.	
		{
			randomGen = new Random();
			Die.randomGen.setSeed(System.currentTimeMillis());
		}
	}
	
	/**
	 * setNumberFaces is the setter method for the number of faces on a die. Embedded within it
	 * is a test for whether or not the numberOfFaces variable is negative. If it is negative,
	 * the exception is thrown.
	 * @param numberOfFaces: corresponds to the number of faces on the dice.
	 * @throws NumberOfFacesRangeException: thrown if the faces is less than zero
	 */
	public void setNumberFaces(int numberOfFaces) throws NumberOfFacesRangeException
	{
		if (numberOfFaces <= 0)
		{
			NumberOfFacesRangeException exception = new NumberOfFacesRangeException("A die "
																	+ "must have at least 1 face.");
					throw exception;
		}
		else
		{
			this.numberFaces = numberOfFaces;
		}
		
	}
	
	/**
	 * getNumberFaces is the getter method that returns the numberOfFaces on a dice.
	 * @return numberFaces: the number of faces on the dice.
	 */
	public int getNumberFaces()
	{
		return numberFaces;
	}
	
	/**
	 * getCurrentFace will return the current showing face of a die without re-rolling.
	 * @return face: the current showing value of a die.
	 */
	public int getCurrentFace()
	{
		return face;
	}
	
	/**
	 * The roll method rolls the die. This collects a face value that is returned.
	 * @return: face; the current showing value of a die.
	 */
	public int roll()
	{
		face = randomGen.nextInt(numberFaces)+1; // Avoids generating 0-(numberFaces-1)
		return face;
	}

	/**
	 * toString in the Die class converts the shown face to a string value for display purposes.
	 * @return iFace.toString: the integer value of the face converted into a string.
	 */
	public String toString()
	{
		Integer iFace = face;							// Integer is a wrapper, primitive to obj.
		return(iFace.toString());
	}
}
