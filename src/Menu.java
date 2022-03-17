package src;
import javax.swing.*;
import java.awt.*;

/**Creates new JPanel to display the menu*/
public class Menu extends JPanel {
    DifficultyPanel difficultyPanel;
    /** Constructor, sets up the main menu of the game*/
    Menu(){
        this.setBounds(0,0,MainFrame.width,MainFrame.height);
        this.setOpaque(false);
        this.setLayout(null);
        ImageIcon image = new ImageIcon("logo.png");

        ImagedLabel title = new ImagedLabel(image,"Minesweeper",0,0,800,150);
        title.setOpaque(true);
        title.ChangeImageSize(50,50);

        ImagedLabel difficultyLabel = new ImagedLabel("Select Difficulty:",0,180,800,50);
        difficultyLabel.setFont(new Font("Tahoma",Font.BOLD,35));
        difficultyLabel.setForeground(Color.WHITE);

        difficultyPanel = new DifficultyPanel();
        this.add(difficultyPanel);
        this.add(difficultyLabel);
        this.add(title);
        this.setVisible(true);
        this.revalidate();
    }


}
