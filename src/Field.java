package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ThreadLocalRandom;

/** Single square inside playing field*/
public class Field extends JButton implements MouseListener {
    boolean revealed = false;
    static boolean started = false;
    static boolean over = false;
    int num = 0;
    boolean bomb = false;
    boolean flag = false;
    int i, j;

    /**
     * Constructor, sets up a single square in game field
     *
     * @param i x coordinate of square
     * @param j y coordinate of square
     */
    Field(int i, int j) {
        this.i = i;
        this.j = j;
        this.setForeground(new Color(255, 0, 0));
        this.setBackground(new Color(157, 157, 157));
        this.addMouseListener(this);
        this.setMargin(new Insets(1, 1, 1, 1));
        this.setFocusable(false);
    }

    /**
     * Reveals this single field. Reacts accordingly if it's a bomb
     */
    public void Reveal() {
        if (!this.revealed && !this.flag) {
            GameField f = (GameField) this.getParent();
            if (this.bomb) {
                //bomb hit, game over
                this.setIcon(new ImageIcon("bmb.png"));
                if (!Field.over) {
                    Field.over = true;
                    f.GameOver();
                }
            }
            if (this.num != 0) {
                this.setText(String.valueOf(this.num));
                this.setFont(new Font("Arial", Font.PLAIN, 18));
                this.setHorizontalTextPosition(JButton.CENTER);
                this.setVerticalAlignment(JButton.CENTER);

                switch (this.num) {
                    //Colors of different numbers
                    case 1 -> this.setForeground(Color.blue);
                    case 2 -> this.setForeground(Color.green);
                    case 3 -> this.setForeground(Color.red);
                    case 4 -> this.setForeground(Color.yellow);
                    case 5 -> this.setForeground(Color.pink);
                    case 6 -> this.setForeground(Color.orange);
                    case 7 -> this.setForeground(Color.black);
                }
                this.setBackground(new Color(229, 229, 229));
            }
            if (this.num == 0 && !this.bomb) {
                this.revealed = true;
                this.setBackground(new Color(229, 229, 229));
                f.RevealAround(i, j);
            }
            f.revealed++;
            this.revealed = true;
            if(f.revealed == f.n*f.m - f.bombs && !Field.over){
                f.Win();
            }
        }
    }

    /**
     * Function called on Right-Click. Flags a field and prevents it from being accidentally clicked
     */
    public void Flag() {
        if(!revealed) {
            GameField parent = (GameField) this.getParent();
            Game parentParent = parent.parent;
            if (flag) {
                parentParent.bombCount.setText(String.valueOf(Integer.parseInt(parentParent.bombCount.getText()) + 1));
                this.setIcon(null);
                flag = false;
            } else {
                parentParent.bombCount.setText(String.valueOf(Integer.parseInt(parentParent.bombCount.getText()) - 1));
                this.setIcon(new ImageIcon("flag.png"));
                flag = true;
            }
        }
    }


    /**
     * Function guarantees that first click is NOT a bomb. Also guarantees that the first field clicked has no bombs adjacent
     */
    public void Start() {
        GameField parent = (GameField) this.getParent();
        int removed = 0;
        if (this.bomb) {
            parent.Remove(i, j);
            removed++;
        }
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (i + x >= 0 && i + x < parent.n && j + y >= 0 && j + y < parent.m) {
                    if (parent.fields[i + x][j + y].bomb) {
                        parent.Remove(i + x, j + y);
                        removed++;
                    }
                }
            }
        }
        int max = parent.n * parent.m;
        int randomNum, j, i;

        while (removed > 0) {
            randomNum = ThreadLocalRandom.current().nextInt(0, max);
            j = randomNum / parent.n;
            i = randomNum % parent.n;
            if (!parent.fields[i][j].bomb && (int) Math.sqrt(((this.i - i) * (this.i - i)) + ((this.j - j) * (this.j - j))) > 1) {
                parent.Add(i, j);
                removed--;
            }
        }

    }

    /**
     * Mouse click handler. Left click: Reveal square
     * Right click: Flag square
     * Middle click: If clicked on revealed square, reveal all adjacent squares.
     * Acts as shortcut instead of clicking each separately
     *
     * @param e Mouse event that happened
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (!Field.started) {
            Start();
        }
        Field.started = true;
        if (e.getButton() == MouseEvent.BUTTON1) {
            Reveal();
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            Flag();
        }
        if (e.getButton() == MouseEvent.BUTTON2) {
            if (revealed) {
                GameField parent = (GameField) this.getParent();
                int count = 0;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        if (i + x >= 0 && i + x < parent.n && j + y >= 0 && j + y < parent.m && parent.fields[i + x][j + y].flag) {
                            count++;
                        }
                    }
                }
                if (count == this.num) {
                    parent.RevealAround(i, j);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
