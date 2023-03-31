import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Random;
class ButtonListener implements ActionListener {
    // each button listener stores the name of the button
    private String text;
    protected JButton button;
    public static int turn;



    // given the text when it's created
    public ButtonListener(String t,JButton b, int T) {
        text = t;
        button = b;
        turn = T;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (turn == 1) {
            if (text.equals("")) {
                button.setText("X");
                text = "X";
                turn = 0;

            }
        } else {
            if (text.equals("")) {
                button.setText("O");
                text = "O";
                turn = 1;
            }
        }

    }
}
class Label extends JPanel {
    boolean nTurn = false;
    JLabel currentLabel;
    int newTurn;

    public Label(int turn) {
        String wTurn;
        if (turn == 0) {
            wTurn = "AI's turn...";
        } else wTurn = "Your turn.";
        if (!nTurn) {
            //creates a Label and set position
            JLabel label = new JLabel(wTurn, JLabel.CENTER);
            currentLabel = label;
            newTurn = turn;
            add(label);
            nTurn = true;
        } else {
            cLabel( newTurn, currentLabel);
        }
    }
    public void cLabel(int turn,JLabel label) {
        String wTurn;
        if (turn == 0) {
            wTurn = "AI's turn...";
        } else wTurn = "Your turn.";
        //creates a Label and set position
        label.setText(wTurn);
    }
}

public class NewGame {
    protected static int turn;
    public static void addButton(String text, JPanel f, int turn){
        //add a button object
        JButton button = new JButton(text);
        button.addActionListener(new ButtonListener(text,button,turn ));
        f.add(button);
    }

   //a coin flip for who goes first
    public static int fTurn(int min, int max) {
        Random random = new Random();
        return (random.nextInt(max - min) + min);
    }
    // setting the turn
    public static int firstTurn(){
        turn = fTurn(0,2);
        return turn;
    }

    public static void main(String[] args) {
        // create and set up the window.
        JFrame frame = new JFrame("Tic_Tac_Toe");
        // make the program not close when the window closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Add label and first turn
        frame.add(new Label(firstTurn()));

        // we need a "panel" for the grid buttons
        JPanel grid = new JPanel();

        // create a grid layout for the 16 buttons other than clear and equals
        GridLayout layout = new GridLayout(3, 3);
        grid.setLayout(layout);
        // add some buttons
        for (int i=0; i < 9; i++){
            addButton("", grid, turn );
        }
        // now we create a vertical box layout for the text box, grid of buttons
        // and the row of buttons at the bottom
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
    }

}
