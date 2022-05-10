/**
 * Assignment 5: Potter Crash
 * Glenda Garcia
 * CSIS 3460: Object Oriented Design
 * April 28th, 2022
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import view.GameView;
import view.WelcomeView;
import view.TileView;

public class GameController {
	private int score;
	int width, height;

	private int matchSize = 3;
	
	private int moveNumber = 0;
	
	private GameView gameView;
	private WelcomeView welcomeView;

	public GameController() {
		super();		
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				width = 770;
				height = 600;
				gameView = new GameView("Potter Crash",7,12, width, height,null,new NewGameListener(), new TileTouchedListener(), new matchButtonListener());

				welcomeView = new WelcomeView(width, height, gameView, new NewGameListener() );

				welcomeView.setVisible(true);
			}
		});
		
	}
	
	// Listener used to process touches on TileView
	class TileTouchedListener implements ActionListener {
		@Override 
		public void actionPerformed(ActionEvent event) {
			TileView tv = (TileView) event.getSource();
			System.out.println("Tile touched..." + tv.toString());

			// delegate to GameView!
			gameView.processTouchedTile(tv);

			score = gameView.getScore();

			// If no move is available display a message
			if (!gameView.isMoveAvailable()) {
				JOptionPane.showMessageDialog(gameView,
					    "Game Over! Points Collected: " + score);
			}
		}
	}
	
	// Listener used to process click on New Game Button
	class NewGameListener implements ActionListener {
		@Override 
		public void actionPerformed(ActionEvent event) {
			System.out.println("Starting new game...");
			welcomeView.setVisible(false);
			gameView.newGame();
		}
	}

	// Listener used to process click on the preferred minimum # of matches button
	class matchButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("New # of matches selected. Starting new game ...");
			JComboBox JCMatch = (JComboBox)e.getSource();
			String matchChoice = (String) JCMatch.getSelectedItem();
			int selectedMatch = Integer.parseInt(matchChoice);
			System.out.println("selected match ----- "+ selectedMatch);
			gameView.setMatchSize(selectedMatch);
			gameView.newGame(selectedMatch);
		}
	}
}