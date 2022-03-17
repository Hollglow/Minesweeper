package src;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Panel containing all the fields. Fields are actually buttons lined up in a grid using GridLayout inside this panel
 */
public class GameField extends JPanel{
    Game parent;
    int revealed = 0;
    int n,m,bombs;
    Field[][] fields;

    /**
     * Reveals squares adjacent to the square provided as parameter
     *
     * @param i x coordinate of center tile
     * @param j y coordinate of center tile
     */
    public void RevealAround(int i,int j){
        for(int x=-1;x<=1;x++){
            for(int y=-1;y<=1;y++){
                if(i+x>=0 && i+x<n && j+y>=0 && j+y<m){
                    this.fields[i+x][j+y].Reveal();
                }
            }
        }
    }

    /**
     * Constructor, sets up game field panel
     *
     * @param n height of playing field
     * @param m width of playing field
     * @param bombs number of bombs
     * @param parent parent JComponent
     */
    GameField(int n,int m,int bombs,Game parent){
        this.parent=parent;
        this.n = n;
        this.m = m;
        this.bombs = bombs;
        fields = new Field[n][m];
        this.setBounds(1,100,m*30,n*30);
        this.setLayout(new GridLayout(n,m));
        this.setOpaque(false);

        for(int i=0;i< n;i++){
            for(int j=0;j<m;j++){
                fields[i][j]= new Field(i,j);
                this.add(fields[i][j]);
            }
        }
        Generate();
    }

    /**
     * Generates bombs inside the field
     */
    public void Generate(){
        int max = n*m;
        int randomNum;

        for(int x=0;x<bombs;x++){
           randomNum = ThreadLocalRandom.current().nextInt(0, max);
           int j = randomNum / n;
           int i = randomNum % n;
           if(fields[i][j].bomb){
               x--;
           }
           else
           {
               Add(i,j);
           }
        }
    }

    /**
     * Simple function to add a single bomb
     *
     * @param i x coordinate of tile
     * @param j y coordinate of tile
     */
    public void Add(int i,int j){
        fields[i][j].bomb=true;
        fields[i][j].num=0;
        for(int x=-1;x<=1;x++){
            for(int y=-1;y<=1;y++){
                if(i+x>=0 && i+x<n && j+y>=0 && j+y<m && !fields[i+x][j+y].bomb){
                    this.fields[i+x][j+y].num++;
                }
            }
        }
    }

    /**
     * Simple function to remove a bomb
     *
     * @param i x coordinate of tile
     * @param j y coordinate of tile
     */
    public void Remove(int i,int j){
        if(fields[i][j].bomb){
            fields[i][j].num=0;
            for(int x=-1;x<=1;x++){
                for(int y=-1;y<=1;y++){
                    if(i+x>=0 && i+x<n && j+y>=0 && j+y<m){
                        if(fields[i+x][j+y].bomb){
                            fields[i][j].num++;
                        }
                        else{
                            this.fields[i+x][j+y].num--;
                        }
                    }
                }
            }
            fields[i][j].bomb=false;
            fields[i][j].num--;
        }
    }

    /**
     * Function called to reset the playing field for a new game to be played
     */
    public void Reset(){
        Field.started=false;
        Field.over=false;
        parent.dispose();
        MainFrame.width=800;
        MainFrame.height=800;
        parent.parent.setVisible(true);
    }
    /**
     * Exits application
     */
    public void Exit(){
        parent.parent.dispose();
        parent.dispose();
    }

    /**
     * Prints winning message
     */
    public void Win(){
        parent.clock.stop();

        if (JOptionPane.showOptionDialog(null, "You Won! Try Again?", "Congratulations!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == 0) {
            Reset();
        } else {
            Exit();
        }
    }
    /**
     * Game Over message
     */
    public void GameOver(){
        int counter=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                fields[i][j].Reveal();
                if(fields[i][j].bomb){
                    counter++;
                }
            }
        }
        parent.clock.stop();

        if (JOptionPane.showOptionDialog(null, "Try Again?", "Game Over!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null) == 0) {
            Reset();
        } else {
            Exit();
        }
    }
}
