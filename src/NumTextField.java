package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * JTextField template that can ONLY accept numbers as input, and sets an appropriate verifier
 */
public class NumTextField extends JTextField{

    /**
     * Constructor, sets up text field which only accepts numbers as input
     * @param s starting text
     */
    NumTextField(String s){
        this.setText(s);
        this.setForeground(new Color(32, 204, 2));
        this.setBackground(Color.black);
        this.setFont(new Font("Consolas",Font.PLAIN,30));
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setCaretColor(Color.white);

        /* Input Verifier: makes sure that the numbers entered are within range 5 - 30 */
        this.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String text = ((JTextField) input).getText();
                try {
                    int num = Integer.parseInt(text);
                    return (text.length()<=2 && num<=30 && num>=5);
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        });

        /* Key Listener filter: Makes sure to only accept digits as keyboard input */
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    NumTextField.super.setEditable(true);
                } else {
                    NumTextField.super.setEditable(false);
                }
            }
        });
        this.revalidate();
    }
}
