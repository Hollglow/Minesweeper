package src;
import javax.swing.*;
import java.awt.*;

/**simple non-editable display for the timer and bomb counter*/
public class Display extends JTextField {
    /**
     * Constructor, sets up a non editable display box
     *
     * @param s starting text
     */
    Display(String s){
        this.setText(s);
        this.setForeground(new Color(32, 204, 2));
        this.setBackground(Color.black);
        this.setFont(new Font("Consolas",Font.PLAIN,25));
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setEditable(false);
        this.setMargin(new Insets(1,1,1,1));
    }
}
