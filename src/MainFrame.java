package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Main window class.
 */
public class MainFrame extends JFrame implements ActionListener {

    /**
     * Frame Size
     */
    static int width = 800, height = 800;
    Menu menu = new Menu();
    Game game;

    /**
     * Constructor, sets up main window for game to be played in
     */
    MainFrame() {

        /* sets title of frame */
        this.setTitle("Minesweeper");
        /* exit from application */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* prevent frame from being resized */
        this.setResizable(false);
        /* sets the x-dimension, and y-dimension of frame */
        this.setSize(width, height);

        /* Label manager set to manual */
        this.setLayout(null);
        /* frame appears in the middle of screen */
        this.setLocationRelativeTo(null);
        /* make frame visible */
        this.setVisible(true);

        /* create an ImageIcon */
        ImageIcon image = new ImageIcon("logo.png");
        /* change icon of frame */
        this.setIconImage(image.getImage());
        /* change color of background */
        this.getContentPane().setBackground(new Color(50, 50, 50));

        menu.difficultyPanel.easy.addActionListener(this);
        menu.difficultyPanel.medium.addActionListener(this);
        menu.difficultyPanel.hard.addActionListener(this);
        menu.difficultyPanel.custom.addActionListener(this);

        add(menu);

        this.revalidate();
    }

    /**
     * update static fields of main frame (Used for JComponent alignment calculation)
     *
     * @param width new width of window
     * @param height new height of window
     */
    public void UpdateSize(int width, int height) {
        MainFrame.width = width;
        MainFrame.height = height;
    }

    /**
     * Handles button presses. Initializes appropriate game
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        menu.difficultyPanel.warning.setText("");
        if (e.getSource() == menu.difficultyPanel.easy) {
            /* sets main frame invisible while game plays */
            this.setVisible(false);

            int n = 9, m = 9, bomb = 10;
            UpdateSize(m * 30 + 18, n * 30 + 140);

            /* initializes new game */
            game = new Game(n, m, bomb,this);
        }
        if (e.getSource() == menu.difficultyPanel.medium) {
            this.setVisible(false);

            int n = 14, m = 14, bomb = 40;
            UpdateSize(m * 30 + 18, n * 30 + 140);

            game = new Game(n, m, bomb,this);
        }
        if (e.getSource() == menu.difficultyPanel.hard) {
            this.setVisible(false);

            int n = 16, m = 30, bomb = 99;
            UpdateSize(m * 30 + 18, n * 30 + 140);

            game = new Game(n, m, bomb,this);
        }
        if (e.getSource() == menu.difficultyPanel.custom) {
            /* Custom field requires extra checking. Field must contain enough space for at least 9 bomb-free fields */
            int n, m, bomb;
            n = Integer.parseInt(menu.difficultyPanel.n.getText());
            m = Integer.parseInt(menu.difficultyPanel.m.getText());
            bomb = Integer.parseInt(menu.difficultyPanel.bmb.getText());

            if (n * m >= bomb+9 && n >= 5 && n <= 30 && m >= 5 && m <= 30) {
                this.setVisible(false);
                UpdateSize(m * 30 + 18, n * 30 + 140);

                game = new Game(n, m, bomb,this);
            }
            else {
                menu.difficultyPanel.warning.setText("Bad Custom Parameters");
            }

        }

    }
}
