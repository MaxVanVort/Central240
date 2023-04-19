import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Menu {
    JFrame frame;
    JLabel label;
    public static JButton newGameButton = new JButton("NEW GAME");
    public static JButton sbButton = new JButton("SCOREBOARD");
    public static JButton exitButton = new JButton("EXIT");
    Player user = new Player();
    public Menu(){
        frame = new JFrame("Menu");
        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(3, 3);
        grid.setLayout(layout);
        user.get(user);


        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //frame.setLayout(new BorderLayout(20,15));
        grid.add(newGameButton).setSize(100,100);
        newGameButton.addActionListener(new ButtonListener(newGameButton,frame));
        grid.add(sbButton).setSize(100,100);
        exitButton.addActionListener(new ButtonListener(exitButton,frame));
        grid.add(exitButton).setSize(100,100);
        sbButton.addActionListener(new ButtonListener(sbButton,frame));
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
    }
    public static void main(String[] args) {
        new Menu();
    }
}
class ButtonListener implements ActionListener {
    private final JButton button;
    private JFrame frame;
    public ButtonListener(JButton b, JFrame f){
        button = b;
        frame = f;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(button.getText().equals ("NEW GAME")){
            new NewGame();
        }else if(button.getText().equals ("EXIT")){
            System.exit (0);
        } else if (button.getText().equals("SCOREBOARD")) {

            JFrame Score_Board = new JFrame("Score_Board");
            Score_Board.add(new ScoreBoard());
            Score_Board.setSize(300, 300);
            // create the box layout
            Score_Board.getContentPane().setLayout(new BoxLayout(Score_Board.getContentPane(), BoxLayout.Y_AXIS));
            // display the window.

            Score_Board.pack();
            Score_Board.setLocationRelativeTo(null);
            Score_Board.setVisible(true);

        }

    }
}
