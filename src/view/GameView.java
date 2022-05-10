/**
 * Assignment 5: Potter Crash
 * Glenda Garcia
 * CSIS 3460: Object Oriented Design
 * April 28th, 2022
 */
package view;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class GameView extends JFrame {
	// Create the HUD Panel
	// Create the Board

	private static final long serialVersionUID = 1L;
	private ScoreView scoreView;
	private ButtonView buttonView;
	private BoardView boardView;
	
	private int score;
	private int matchSize = 3;
	
	// Setting default to 8x8
	int rows = 8, cols = 8;
	int width, height;
	

	ActionListener newGameListener;
	ActionListener tileTouchedListener;
	ActionListener matchButtonListener;


	/**
	 * @param title
	 * @throws HeadlessException
	 */
	
	
	public GameView(String title, int rows, int cols, int width, int height,MouseListener listener, ActionListener newGameListener, ActionListener tileTouched, ActionListener matchButton) throws HeadlessException {
		super(title);
		setResizable(false);
		
		this.width = width;
		this.height = height;
		score = 0;
		this.rows = rows;
		this.cols = cols;
		
		this.newGameListener = newGameListener;
		this.tileTouchedListener = tileTouched;
		this.matchButtonListener = matchButton;
		
		// Set up some reasonable sizes for the gameview
		setBounds(500,150,width, height);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		scoreView = new ScoreView();
    	add(scoreView, BorderLayout.NORTH);


		buttonView = new ButtonView(newGameListener, matchButton);
    	add(buttonView, BorderLayout.SOUTH);
		
		boardView = new BoardView(rows,cols, tileTouchedListener, matchSize);
		add(boardView, BorderLayout.CENTER);
	}

	public int getScore(){
		return score;
	}

	// Delegate to boardView
	public boolean isMoveAvailable() {
		if (boardView.isMoveAvailable())
		{
			return true;
		}
		else {
			return false;
		}
	}

	//New game when user clicks on a new match size
	public void newGame() {

		// Recreate some components and update the GUI.
		Container c = getContentPane();
		c.remove(boardView);
		c.invalidate();
		pack();

		int matchSize = buttonView.getValue();
		boardView = null;
		score = 0;
		scoreView.updateScore(score);

		boardView = new BoardView(rows,cols, tileTouchedListener, matchSize);

		add(boardView, BorderLayout.CENTER);
		pack();
		revalidate();
		setBounds(500,150,width, height);

		System.out.println(boardView);  // debug

		setVisible(true);
	}



	//Call this method to start and update the GUI
	public void newGame(int matchSize) {
		// Recreate some components and update the GUI.
		Container c = getContentPane();
		c.remove(boardView);
		c.invalidate();
		pack();

		this.matchSize = matchSize;
		boardView = null;
		score = 0;
		scoreView.updateScore(score);

		boardView = new BoardView(rows,cols, tileTouchedListener, matchSize);

		add(boardView, BorderLayout.CENTER);
		pack();
		revalidate();
		setBounds(500,150,width, height);

		System.out.println(boardView);  // debug

		setVisible(true);
	}
	
	public void processTouchedTile(TileView tv) {
		// Method is called when a tileview is touched

		score += boardView.processTouchedTile(tv);
		scoreView.updateScore(score);

		System.out.println("GameView == processing tile touch");
		
		System.out.println(boardView); // debug
	}

	public void setMatchSize(int matchSize){
		this.matchSize = matchSize;
		boardView.setMatchSize(matchSize);
	}
}