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
    public Menu(){
        frame = new JFrame("menu");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(new BorderLayout(20,15));
        frame.add(newGameButton).setSize(300,100);
        newGameButton.addActionListener(new ButtonListener(newGameButton,frame));
        frame.add(sbButton).setSize(300,100);
        sbButton.addActionListener(new ButtonListener(sbButton,frame));
        frame.add(exitButton).setSize(300,100);
        exitButton.addActionListener(new ButtonListener(exitButton,frame));
        frame.setSize(300,300);
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
        if(button.getText().equals ("new game")){
            NewGame ng = new NewGame();
        }else if(button.getText().equals ("exit")){
            System.exit (0);
        }{

        }
    }
}
