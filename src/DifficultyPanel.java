package src;
import javax.swing.*;
import java.awt.*;

    /**
     * JPanel template created for convenience
     * This panel contains all the difficulty selection elements: Buttons, labels, input fields etc
     */
public class DifficultyPanel extends JPanel {

    JButton easy = new JButton("Easy"); //Difficulty buttons
    JButton medium = new JButton("Medium");
    JButton hard = new JButton("Hard");
    JButton custom = new JButton("Custom");
    JLabel warning = new JLabel("");

    ImagedLabel ea = new ImagedLabel(new ImageIcon("grn.png"),"9  X 9 ",25,20,300,80);
    ImagedLabel md = new ImagedLabel(new ImageIcon("ora.png"),"14 X 14",25,140,300,80);
    ImagedLabel hr = new ImagedLabel(new ImageIcon("red.png"),"16 X 30",25,260,300,80);

    ImagedLabel eaB = new ImagedLabel(new ImageIcon("logo.png"),"10",25,43,300,80);
    ImagedLabel mdB = new ImagedLabel(new ImageIcon("logo.png"),"40",25,163,300,80);
    ImagedLabel hrB = new ImagedLabel(new ImageIcon("logo.png"),"99",25,283,300,80);

    ImagedLabel cust = new ImagedLabel("             X",25,380,300,80);
    ImagedLabel custbmb = new ImagedLabel(new ImageIcon("logo.png"),"",60,423,50,50);

    NumTextField n = new NumTextField("14");
    NumTextField m = new NumTextField("14");
    NumTextField bmb = new NumTextField("40");

        /**
         * Constructor, sets up difficulty selector JPanel inside menu
         */
    DifficultyPanel(){
        
        this.setBackground(new Color(156, 156, 156, 50));
        this.setBounds(25,250,730,485);

        int width = 400;
        int height = 80;
        int x = 300;

        easy.setFont(new Font("Arial",Font.BOLD,60));
        medium.setFont(new Font("Arial",Font.BOLD,60));
        hard.setFont(new Font("Arial",Font.BOLD,60));
        custom.setFont(new Font("Arial",Font.BOLD,60));
        warning.setFont(new Font("Arial",Font.BOLD,20));

        easy.setBounds(x,20, width, height);
        medium.setBounds(x,140, width, height);
        hard.setBounds(x,260, width, height);
        custom.setBounds(x,380, width, height);
        warning.setBounds(40,462,250,20);

        warning.setHorizontalAlignment(JLabel.CENTER);
        warning.setVerticalAlignment(JLabel.CENTER);

        easy.setForeground(new Color(33, 250, 10));
        medium.setForeground(new Color(234, 148, 46));
        hard.setForeground(new Color(231, 6, 6));
        custom.setForeground(new Color(0, 0, 0));
        warning.setForeground(new Color(255, 0, 0));
        warning.setBackground(new Color(0, 0, 0));

        warning.setOpaque(true);

        easy.setBackground(Color.gray);
        medium.setBackground(Color.gray);
        hard.setBackground(Color.gray);
        custom.setBackground(Color.gray);

        easy.setFocusable(false);
        medium.setFocusable(false);
        hard.setFocusable(false);
        custom.setFocusable(false);

        /* adding finished buttons and warning label */
        this.add(easy);
        this.add(medium);
        this.add(hard);
        this.add(custom);
        this.add(warning);

        ea.ChangeImageSize(50,80);
        md.ChangeImageSize(50,80);
        hr.ChangeImageSize(50,80);

        ea.setFont(new Font("Arial",Font.PLAIN,40));
        md.setFont(new Font("Arial",Font.PLAIN,40));
        hr.setFont(new Font("Arial",Font.PLAIN,40));
        cust.setFont(new Font("Arial",Font.PLAIN,30));

        ea.setOpaque(true);
        md.setOpaque(true);
        hr.setOpaque(true);
        cust.setOpaque(true);

        ea.setBackground(new Color(171, 171, 171));
        md.setBackground(new Color(171, 171, 171));
        hr.setBackground(new Color(171, 171, 171));
        cust.setBackground(new Color(171, 171, 171));

        ea.setForeground(new Color(220, 171, 171));
        md.setForeground(new Color(220, 171, 171));
        hr.setForeground(new Color(220, 171, 171));
        cust.setForeground(new Color(220, 171, 171));

        ea.setVerticalTextPosition(JLabel.TOP);
        ea.setIconTextGap(34);
        md.setVerticalTextPosition(JLabel.TOP);
        hr.setVerticalTextPosition(JLabel.TOP);
        cust.setVerticalTextPosition(JLabel.TOP);

        ea.setHorizontalAlignment(JLabel.LEFT);
        md.setHorizontalAlignment(JLabel.LEFT);
        hr.setHorizontalAlignment(JLabel.LEFT);
        cust.setHorizontalAlignment(JLabel.LEFT);
        cust.setVerticalAlignment(JLabel.TOP);
        custbmb.setVerticalAlignment(JLabel.TOP);

        eaB.ChangeImageSize(30,30);
        mdB.ChangeImageSize(30,30);
        hrB.ChangeImageSize(30,30);
        custbmb.ChangeImageSize(30,30);

        eaB.setFont(new Font("Arial",Font.PLAIN,40));
        mdB.setFont(new Font("Arial",Font.PLAIN,40));
        hrB.setFont(new Font("Arial",Font.PLAIN,40));

        n.setBounds(40,380,60,35);
        m.setBounds(180,380,60,35);
        bmb.setBounds(110,420,60,35);

        /* adding input fields */
        this.add(n);
        this.add(m);
        this.add(bmb);

        /* various design labels */
        this.add(eaB);
        this.add(mdB);
        this.add(hrB);

        this.add(ea);
        this.add(md);
        this.add(hr);

        this.add(custbmb);
        this.add(cust);

        this.setLayout(null);
        this.setVisible(true);
        this.revalidate();
    }
}
