package DiceRoller;

// Allows usage of problem domain exception objects
import diceProblemDomain.*;
// Import the Scanner Object to allow keyboard input
import java.util.Scanner;

// Allows creation of necessary GUI elements
import javax.swing.JFrame;

/**
 * DiceRoller is the class that holds the test methods as well as the frame through which
 * the program is seen.
 * @author RyderDale
 * @package DiceRoller: This package corresponds to the elements the user interacts with.
 */
public class DiceRoller 
{

	/**
	 * This is the main method. It creates the frame and the content panel, DiceRollerPanel2,
	 * which is explained in its own class.
	 * @param args
	 */
	public static void main(String[] args)
	{
		//*****************************************************************
		// Test Methods
		//*****************************************************************
		try
		{
		inputTester();
		diceTester(6,100);
		}
		catch(NumberOfFacesRangeException exception)
		{
			return;
		}
		catch(NumberOfDiceRangeException exception)
		{
			return;
		}
				
		//***********************************************************
		// GUI elements
		//***********************************************************
		JFrame frame = new JFrame("Dice Roller");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DiceRollerPanel2 panel = new DiceRollerPanel2();	
		frame.getContentPane().add(panel);				// Adds our panel into the contentPane
		
		frame.pack();									// This means arrange so elements fit
		frame.setVisible(true);							// Show it after this is finished
		
	}
	 
		/**
		 * diceTester checks to see if Die and DiceBag are working correctly by calling the roll
		 * function and testing the distribution of roll values.
		 * @param numberOfFaces: corresponds to the number of sides on a die
		 * @param numberOfDice: corresponds to the number of Dice in a bag
		 * @throws NumberOfFacesRangeException: thrown if negative number of faces
		 * @throws NumberOfDiceRangeException: thrown if negative number of dice
		 */
		public static void diceTester(int numberOfFaces, int numberOfDice) throws NumberOfFacesRangeException, 
																				NumberOfDiceRangeException
		{
			
			Die d1;											// Die object for test rolling
			try
			{
			d1 = new Die(numberOfFaces);
			}
			catch (NumberOfFacesRangeException exception)
			{
				return;
			}
			
			// Roll d1 10 times and test that the values are reasonable
			System.out.println("Test of Roll Values:");
			for(int i = 0; i<10; i++)
			{
				d1.roll();
				// Latter part prints out a boolean to test values
				System.out.println(d1.getCurrentFace()+" "+(d1.getCurrentFace()>0 && 
																d1.getCurrentFace()<7));
			}
			
			//************************************************************
			// TEST DISTRIBUTION OF DICE ROLLS
			//************************************************************
			Die[] lotaDice = new Die[numberOfDice];		// Making an array syntax
			// Create and roll the number of Dice desired
			for (int i = 0; i<numberOfDice; i++)
			{
				try
				{
					lotaDice[i] = new Die(numberOfFaces);
				}
				catch(NumberOfFacesRangeException exception)
				{
					return;
				}
				lotaDice[i].roll();
			}
			// Print out desired distribution number with integer division
			System.out.println("\nTest of Distribution of Rolls: ");
			System.out.println("Target :"+(numberOfDice/numberOfFaces));
			// Count the number of times a particular value is rolled compared to the Target
			int[] diceCount = new int[numberOfFaces];
			for(int i = 0; i<numberOfDice;i++)
			{
					diceCount[lotaDice[i].getCurrentFace()-1]++;				
			}
			// Prints out number of faces that appear in set of rolls
			for(int i = 0; i<numberOfFaces; i++)
			{
				System.out.println(" Count for " +(i+1)+ " = " +diceCount[i]); // fix this
			}
		
		}
		
		/**
		 * inputTester is a function used during the development of the program to allow
		 * this program to work in a command line style. Input came from the keyboard into the
		 * command window.
		 * @throws NumberOfFacesRangeException: thrown if negative number of dice faces
		 * @throws NumberOfDiceRangeException: thrown if negative number of dice
		 */
		public static void inputTester() throws NumberOfFacesRangeException, NumberOfDiceRangeException
		{
			Scanner keyboardInput = new Scanner(System.in);
			String input;
			int numberOfDice;
			int numberOfFaces;
			DiceBag bag;
			
			System.out.println("Enter the number of Dice to roll:");
			input = keyboardInput.nextLine();				// Enters input as string
			numberOfDice = Integer.parseInt(input);			// Returns string as an integer
			
			System.out.println("Enter number of faces:");
			input = keyboardInput.nextLine();
			numberOfFaces = Integer.parseInt(input);
			
			// Create the diceBag that was initialized
			try
			{
			bag = new DiceBag(numberOfFaces, numberOfDice);
			}
			catch (NumberOfFacesRangeException exception)
			{
				keyboardInput.close();
				return;
			}
			catch (NumberOfDiceRangeException exception)
			{
				keyboardInput.close();
				return;
			}
			bag.roll();
			
			System.out.println("Rolls: " +bag.toString());
			System.out.println("Total: "+bag.getTotal());
			
			keyboardInput.close();							// Closes the keyboard input object
		} 
}
