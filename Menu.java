import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Menu {
    JFrame frame;
    JLabel label;
    public static JButton newGameButton = new JButton("new game");
    public static JButton sbButton = new JButton("scorboard");
    public static JButton exitButton = new JButton("exit");
    public Menu(){

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
            NewGame ng = new NewGame(frame);
        }else if(){

        }
    }
}
