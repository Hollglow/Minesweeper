package src;
import javax.swing.*;
import java.awt.*;

    /**
     * Convenient constructor for a JLabel with attached image. Used as default template
     * If required additional changes are made on different invoked instances where they are used
     */
    public class ImagedLabel extends JLabel{
    ImageIcon imageIcon;

    ImagedLabel(String text, int x,int y,int width, int height){
        this(null,text,x,y,width,height);
    }

        /**
         * Constructor, sets up label combined with an image
         *
         * @param image image to be used
         * @param text label text
         * @param x x coordinate of label
         * @param y y coordinate of label
         * @param width width of label
         * @param height height of label
         */
    ImagedLabel(ImageIcon image, String text, int x,int y,int width, int height){

        /* set text of label */
        this.setText(text);

        if(image!=null){
            this.setIcon(image);
            this.imageIcon=image;
        }

        /* set text LEFT,CENTER, RIGHT of imageIcon */
        this.setHorizontalTextPosition(JLabel.RIGHT);
        /* set text TOP,CENTER, BOTTOM of imageIcon */
        this.setVerticalTextPosition(JLabel.CENTER);
        /* set font color of text */
        this.setForeground(new Color(218, 15, 15));
        /* set font of text */
        this.setFont(new Font("Tahoma",Font.ITALIC,50));

        /* set gap of text to image */
        this.setIconTextGap(25);
        /* display background color */
        this.setOpaque(false);
        this.setBackground(new Color(20,20,20));

        /* set vertical position of icon+text within label */
        this.setVerticalAlignment(JLabel.CENTER);
        /* set horizontal position of icon+text within label */
        this.setHorizontalAlignment(JLabel.CENTER);

        /* set x,y position within frame as well as dimensions */
        this.setBounds(x, y, width, height);
        this.revalidate();
    }

        /**
         * Method to quickly transform the Icon size used inside the label
         *
         * @param x x coordinate of tile
         * @param y y coordinate of tile
         */
    public void ChangeImageSize(int x,int y){
        Image image= imageIcon.getImage();
        /* scale it the smooth way */
        Image newImg = image.getScaledInstance(x, y,  Image.SCALE_SMOOTH);
        /* transform it back */
        imageIcon = new ImageIcon(newImg);
        /* set it back */
        this.setIcon(imageIcon);
    }


}
