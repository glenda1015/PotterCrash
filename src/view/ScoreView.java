/**
 * Assignment 5: Potter Crash
 * Glenda Garcia
 * CSIS 3460: Object Oriented Design
 * April 28th, 2022
 */
package view;

import javax.swing.*;
import java.awt.*;

public class ScoreView extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	private JLabel scoreLabel;
	
	public ScoreView() {
		scoreLabel = new JLabel("Score: 0");
		scoreLabel.setFont(new Font("Serif", Font.BOLD, 20));
		add(scoreLabel);
	}
	
	public void updateScore(int score) {
		scoreLabel.setText("Score: " + score);
	}
}