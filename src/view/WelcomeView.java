/**
 * Assignment 5:  Potter Crash
 * Glenda Garcia
 * CSIS 3460: Object Oriented Design
 * April 28th, 2022
 */
package view;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class WelcomeView extends JFrame {
    private static final long serialVersionUID = 1L;
    private GameView gameV;
    private JButton startGameButton;
    ActionListener startGameListener;
    public WelcomeView(int width, int height, GameView gameV, ActionListener startGameListener){

        super();
        this.gameV = gameV;
        setResizable(false);
        setTitle(gameV.getTitle());

        try {
            setContentPane(
                    new JLabel(new ImageIcon(ImageIO.read(new File("Resources/images/background.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }



        // Set up some reasonable sizes for the gameview
        setBounds(500,150,width, height);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //start game button
        startGameButton = new JButton("Start Game");
        startGameButton.setPreferredSize(new Dimension(150,60));
        startGameButton.addActionListener(startGameListener);
        add(startGameButton, constraints);

        setVisible(true);
    }
}

