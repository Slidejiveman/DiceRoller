package diceProblemDomain;

/**
 * DiceBag simulates the action of shaking up a bunch of Dice in a single bag, then dumping
 * all of said dice out on a table. Each die has the same number of faces, and their total 
 * value is returned and displayed
 * @author RyderDale
 * @package diceProblemDomain
 */
public class DiceBag 
{
	private int total;
	private int numberOfFaces;
	private int numberOfDice;
	private Die dice[];
		
	/**
	 * DiceBag is the constructor for this class.
	 * 
	 * @param numberOfFaces: corresponds to the number of faces a die has.
	 * @param numberOfDice: corresponds to the number of dice in the bag.
	 * @throws NumberOfDiceRangeException: is thrown if the number of dice is less than 0.
	 * @throws NumberOfFacesRangeException: is thrown if the number of faces is less than 0.
	 * 
	 */
	public DiceBag(int numberOfFaces, int numberOfDice) throws NumberOfDiceRangeException, 
																NumberOfFacesRangeException
	{
		// Create the dice in the bag with the corresponding number of faces
		this.numberOfFaces = numberOfFaces;
		setNumberDice(numberOfDice);
		
		// Create the array to hold the dice
		dice = new Die[numberOfDice];
		for (int i = 0; i<numberOfDice; i++)
		{
			// Create the dice to occupy the spots
			dice[i] = new Die(this.numberOfFaces);
		}
	}
	
	
	// Setters and getters for number of faces Not entirely necessary.
	/**
	 * setNumberFaces is the setter method for the number of faces on a the dice.
	 * @param numberOfFaces:	corresponds to the number of faces on a die in the bag.
	 */
	public void setNumberFaces (int numberOfFaces)
	{
		this.numberOfFaces = numberOfFaces;
	}
	
	// Throw an exception about number of Dice here
	/**
	 * setNumberDice is the setter method that simulates placing dice in the bag.
	 * @param numberOfDice: corresponds to the dice placed in the bag.
	 * @throws NumberOfDiceRangeException: thrown if a negative number of dice is in the bag.
	 */
	public void setNumberDice (int numberOfDice) throws NumberOfDiceRangeException
	{
		if (numberOfDice <= 0)
		{
			NumberOfDiceRangeException exception = new NumberOfDiceRangeException("The "
																+ "bag needs at least 1 die.");
			throw exception;
		}
		else
		{
			this.numberOfDice = numberOfDice;
		}
	}
	
	/**
	 * getNumberOfFaces is the getter method that returns the current faces on the dice.
	 * @return numberOfFaces: corresponds to the sides on the dice
	 */
	public int getNumberOfFaces()
	{
		return numberOfFaces;
	}
	
	/**
	 * getNumberOfDice is the getter method that returns the current number of dice in the bag.
	 * @return numberOfDice: corresponds to the number of dice in the bag
	 */
	public int getNumberOfDice()
	{
		return numberOfDice;
	}
	
	/**
	 * Roll simulates the action of dumping all of the dice in the bag on a table. They 
	 * are summed and the total is returned.
	 * @return total: the added up value of the showing faces on the dice.
	 */
	public int roll()
	{
		// Create and roll the number of Dice desired
		total = 0;  // reset total with each call
		for (int i = 0; i<numberOfDice; i++)
		{
			dice[i].roll();
			total += dice[i].getCurrentFace();			// Collect running total of dice rolls
		}
		return total;
	}
	
	/**
	 * getTotal is a getter method that retrieves the current total of face values without
	 * re-rolling. This can be useful if the current roll is ever needed. Otherwise, it would
	 * be lost when roll is called again.
	 * @return total: the added up value of the showing faces on the dice.
	 */
	public int getTotal()
	{
		return total;
	}
	
	/**
	 * toString takes the rolls stored in the dice array and converts them to strings so that
	 * they may be shown on the GUI.
	 * @return faces: The current showing faces of the dice as a string.
	 */
	public String toString()
	{
		String faces;
		faces = ""; // An empty string
		for(int i = 0; i<numberOfDice; i++)
		{
			faces += dice[i].toString();
			if (i < (numberOfDice-1))
				faces+= " + ";
		}
		return(faces);
	}
}
