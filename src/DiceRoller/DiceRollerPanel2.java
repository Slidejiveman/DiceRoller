package DiceRoller;

// Allows for work with the GUI
import javax.swing.*;

import diceProblemDomain.DiceBag;
import diceProblemDomain.NumberOfDiceRangeException;
import diceProblemDomain.NumberOfFacesRangeException;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
/**
 * DiceRollerPanel2 is so named because the first iteration of DiceRoller was lost after the
 * author upgraded to Windows 10. This object is a user created panel that displays all of the
 * desired bits of information to the user.
 * @author RyderDale
 * @package DiceRoller: GUI elements for the user
 */
public class DiceRollerPanel2 extends JPanel
{
	private int numberOfDice = 0;
	private int numberOfFaces = 0;
	private DiceBag bag;
	private JButton rollButton;
	private JLabel diceRollerLabel;
	private JLabel numberOfDiceLabel;
	private JLabel numberOfFacesLabel;
	private JLabel errorMessageLabel;
	private JTextField numberOfDiceField;
	private JTextField numberOfFacesField;
	
	/**
	 * DiceRollerPanel2 is the constructor. When called, it generates all of the needed graphical
	 * user interface elements and adds them to the panel. Additionally, it also controls the
	 * window formatting.
	 */
	public DiceRollerPanel2()
	{
		rollButton = new JButton("Roll!");
		rollButton.addActionListener(new RollButtonListener());
		diceRollerLabel = new JLabel("Total :");
		numberOfDiceLabel = new JLabel("Enter Number Of Dice :");
		numberOfFacesLabel = new JLabel("Enter Dice Faces :");
		errorMessageLabel = new JLabel("");
		numberOfDiceField = new JTextField(5);
		numberOfDiceField.addActionListener(new NumberOfDiceFieldListener());
		numberOfFacesField = new JTextField(5);
		numberOfFacesField.addActionListener(new NumberOfFacesFieldListener());
		
		// Add information to the panel
		add(numberOfDiceLabel);
		add(numberOfDiceField);
		add(numberOfFacesLabel);
		add(numberOfFacesField);
		add(rollButton);
		add(diceRollerLabel);
		add(errorMessageLabel);
		
		//format window
		setBackground(Color.white);
		setPreferredSize(new Dimension(200, 200));
	}
		
		//********************************************************
		// Class Listeners
		//********************************************************
	
		/**
		 * RollButtonListener is a subclass to DiceRollerPanel2. This listener watches for 
		 * the ActionEvent corresponding to when the user clicks the "Roll" button. It then 
		 * responds by rolling the DiceBag and displaying relevant information.
		 * @author RyderDale
		 */
		private class RollButtonListener implements ActionListener
		{
			/**
			 * actionPerformed is the function that creates the entryText and errorMessage
			 * string variables. These variables are then filled with the relevant text to show.
			 * After this, the Listener tries to create a DiceBag with the user entered 
			 * information. If there is an error, it handles the exception, or the program
			 * terminates. Otherwise, it rolls and displays the total.
			 * @param event: an ActionEvent corresponding to a click of the mouse.
			 */
			public void actionPerformed(ActionEvent event)
			{
				String entryText;
				String errorMessage;
				
				entryText = numberOfDiceField.getText();
				numberOfDice = Integer.parseInt(entryText);
				
				entryText = numberOfFacesField.getText();
				numberOfFaces = Integer.parseInt(entryText);
				
				// null string to refresh the error text
				errorMessageLabel.setText("");
				
				try
				{
					bag = new DiceBag(numberOfFaces, numberOfDice);
				}
				catch (NumberOfFacesRangeException exception)
				{
					errorMessage = exception.getMessage();
					errorMessageLabel.setText(errorMessage);
					diceRollerLabel.setText ("Total: Error");
					return;					// Leaves the method
				}
				catch (NumberOfDiceRangeException exception)
				{
					errorMessage = exception.getMessage();
					errorMessageLabel.setText(errorMessage);
					diceRollerLabel.setText ("Total: Error");
					return;
				}
				bag.roll();
				diceRollerLabel.setText("Total: "+bag.getTotal() +" = " + bag.toString());
			}
		}
		/**
		 * NumberOfDiceFieldListener has only one job that is handled by its
		 * function actionPerformed method. This method has only one function, which is to
		 * move the focus into the text field if the user clicks it. It implements ActionListener,
		 * so it has all of the capabilities of ActionListener with the addition of the newly
		 * defined actionPerformed method.
		 * @author RyderDale
		 *
		 */
		private class NumberOfDiceFieldListener implements ActionListener
		{
			/**
			 * actionPerformed moves the focus into the text field when it is clicked.
			 * @param event: an ActionEvent corresponding to the click of the mouse
			 */
			public void actionPerformed(ActionEvent event)
			{
				numberOfDiceField.requestFocusInWindow();
			}
		}
		/**
		 * NumberOfFacesFieldListener functions just as NumberOfDiceFieldListener does. It
		 * moves the focus into the appropriate text field when the user clicks it.
		 * @author RyderDale
		 *
		 */
		private class NumberOfFacesFieldListener implements ActionListener
		{
			/**
			 * actionPerformed in this section requests the focus into the numberOfFacesField
			 * if it is clicked.
			 * @param event: an ActionEvent corresponding to the click of the mouse
			 */
			public void actionPerformed(ActionEvent event)
			{
				numberOfFacesField.requestFocusInWindow();
			}
			
		}
}