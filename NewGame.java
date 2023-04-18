import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class T3B implements ActionListener {
    // each button listener stores the name of the button
    private final JButton button;
    private static boolean yourTurn;

    public static boolean isYourTurn() {
        return yourTurn;
    }

    // given the text and if it's the players turn, when it's created
    public T3B(JButton b) {
        yourTurn = true;
        button = b;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (isYourTurn()){
            if (button.getText().equals("")) {
                button.setText("X");
                yourTurn = true;

            }

        }
    }
}

public class NewGame {
    // create and set up the window.
    JFrame frame;
    public static JButton b1 = new JButton("");
    public static JButton b2 = new JButton("");
    public static JButton b3 = new JButton("");
    public static JButton b4 = new JButton("");
    public static JButton b5 = new JButton("");
    public static JButton b6 = new JButton("");
    public static JButton b7 = new JButton("");
    public static JButton b8 = new JButton("");
    public static JButton b9 = new JButton("");
    public static String wLT = "w/l/t";
    public static JButton Menu = new JButton("MENU");
    private boolean turn;
    private boolean GameOver = false;

    public boolean isGameOver(){
        return GameOver;
    }
    public void setGameOver(boolean gameOver) {
        GameOver = gameOver;
    }
    public boolean isTurn() {
        return turn;
    }
    public void setTurn(boolean turn) {
        this.turn = turn;
    }
    public static boolean won(String PorB){
        boolean a1 = b1.getText().equals(PorB);
        boolean a2 = b2.getText().equals(PorB);
        boolean a3 = b3.getText().equals(PorB);
        boolean b1 = b4.getText().equals(PorB);
        boolean b2 = b5.getText().equals(PorB);
        boolean b3 = b6.getText().equals(PorB);
        boolean c1 = b7.getText().equals(PorB);
        boolean c2 = b8.getText().equals(PorB);
        boolean c3 = b9.getText().equals(PorB);

        if (a1 && a2 && a3){
            return (true);
        } else if (a1 && b1 && c1) {
            return (true);
        } else if (a1 && b2 && c3) {
            return (true);
        } else if (a2 && b2 && c2) {
            return (true);
        } else if (a3 && b3 && c3) {
            return (true);
        } else if (a3 && b2 && c1) {
            return (true);
        } else return b1 && b2 && b3;
    }
    public static boolean tie(){
        return (!(b1.getText().equals("") || b2.getText().equals("") || b3.getText().equals("") || b4.getText().equals("") || b5.getText().equals("") || b6.getText().equals("") || b7.getText().equals("") || b8.getText().equals("") || b9.getText().equals("") ));
    }
    public static boolean fTurn() {
        Random random = new Random();
        int i = random.nextInt((2 - 0) + 0);
        return i == 1;
    }
    public static void setWLT(String wLT) {
        NewGame.wLT = wLT;
    }
    public static String getWLT() {
        return wLT;
    }

    public NewGame(JFrame f){
        f = new JFrame("Tic_Tac_Toe");
        frame = f;
        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(3, 3);
        grid.setLayout(layout);
        grid.add(b1);
        b1.addActionListener(new T3B(b1));
        grid.add(b2);
        b2.addActionListener(new T3B(b2));
        grid.add(b3);
        b3.addActionListener(new T3B(b3));
        grid.add(b4);
        b4.addActionListener(new T3B(b4));
        grid.add(b5);
        b5.addActionListener(new T3B(b5));
        grid.add(b6);
        b6.addActionListener(new T3B(b6));
        grid.add(b7);
        b7.addActionListener(new T3B(b7));
        grid.add(b8);
        b8.addActionListener(new T3B(b8));
        grid.add(b9);
        b9.addActionListener(new T3B(b9));
        // makes a vertical box layout for the grid of button.
        BoxLayout mainLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.getContentPane().setLayout(mainLayout);
        // add the grid
        frame.getContentPane().add(grid);
        frame.setPreferredSize(new Dimension(300, 300));
        grid.setPreferredSize(new Dimension(300, 300));


        // display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Ai benny = new Ai();
        setTurn(fTurn());

        while (!isGameOver()){

            if (isTurn()){

                while(isTurn()) {
                    /*
                    This is because the while loop will start Benny's turn before the player has made a choice.
                    so while it is the players turn and the player hasn't made a move it will stay the players turn.
                     */
                    boolean b = T3B.isYourTurn();
                    setTurn(b);
                }
                if(won("X")){
                    setWLT("1/0/0");
                }
                setGameOver(won("X"));

            } else {
                benny.getBChoice();
                if(won("0")){
                    setWLT("0/1/0");
                }
                setGameOver(won("O"));

                setTurn(true);
            }
            if (tie()){
                setWLT("0/0/1");
                setGameOver(tie());
            }
        }

    }

}
