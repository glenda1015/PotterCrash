/**
 * Assignment 5: Potter Crash
 * Glenda Garcia
 * CSIS 3460: Object Oriented Design
 * April 28th, 2022
 */
package view;

import javax.swing.*;
import java.awt.event.*;

public class ButtonView extends JPanel {

	 
	/**
	 * Simple button view that contains a New Game button and a levelSelector combo box.
	 * Only the NewGame button listener is currently implemented.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton newGameButton;
	private JComboBox levelSelector;
	private JLabel levelLabel;
	
	public ButtonView(ActionListener gameButtonListener, ActionListener matchButtonListener) {
		
		levelLabel = new JLabel();
		levelLabel.setText("Min Matches: ");
		add(levelLabel);
		
		levelSelector = new JComboBox();
		levelSelector.addItem("3");
		levelSelector.addItem("4");
		levelSelector.addItem("5");
		levelSelector.addActionListener(matchButtonListener);

		add(levelSelector);
		
		newGameButton = new JButton();
		newGameButton.setText("New Game");
		newGameButton.addActionListener(gameButtonListener);
		add(newGameButton);
	}

	public int getValue(){
		return Integer.valueOf(levelSelector.getSelectedItem().toString());
	}
}
