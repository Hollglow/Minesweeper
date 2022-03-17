package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**Creates new JFrame for the game to be played on*/
public class Game extends JFrame {
    int time = 0;
    Display timer = new Display(String.format("%03d",0));
    Display bombCount = new Display("");
    JLabel timeLabel = new JLabel("Time");
    JLabel bombLabel = new JLabel("Bombs");
    MainFrame parent;

    /**
     * lambda for timer increment function
     */
    ActionListener increment = e -> {
        time++;
        if(time<=999)
            timer.setText(String.format("%03d",time));
    };

    Timer clock = new Timer(1000, increment);
    /**Constructor, sets up playing field window
     *
     * @param n height of game field
     * @param m width of game field
     * @param bombs number of bombs to be generated
     * @param parent parent JComponent
     * */
    Game(int n, int m, int bombs,MainFrame parent) {
        /* sets title of frame */
        this.setTitle("Minesweeper");
        /* exit from application */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* prevent frame from being resized */
        this.setResizable(false);
        /* sets the x-dimension, and y-dimension of frame */
        this.setSize(MainFrame.width, MainFrame.height);
        /* make frame visible */
        this.setVisible(true);
        /* Label manager set to manual */
        this.setLayout(null);
        /* frame appears in the middle of screen */
        this.setLocationRelativeTo(null);

        /* create an ImageIcon */
        ImageIcon image = new ImageIcon("logo.png");
        /* change icon of frame */
        this.setIconImage(image.getImage());
        /* change color of background */
        this.getContentPane().setBackground(new Color(50, 50, 50));
        GameField gameField = new GameField(n, m, bombs,this);
        this.parent = parent;

        bombCount.setText(String.valueOf(bombs));
        bombCount.setBounds(MainFrame.width - 80, 20, 50, 30);
        bombLabel.setBounds(MainFrame.width - 80, 50, 50, 30);
        bombLabel.setForeground(Color.WHITE);
        bombLabel.setHorizontalAlignment(JLabel.CENTER);

        timer.setBounds(13, 20, 50, 30);
        timeLabel.setBounds(13, 50, 50, 30);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);

        clock.start();

        this.add(gameField);
        this.add(timeLabel);
        this.add(bombLabel);
        this.add(timer);
        this.add(bombCount);
    }
}
