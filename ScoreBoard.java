import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ScoreBoard extends Menu implements ActionListener {
    protected JTextField tF=new JTextField();
    protected JTextArea tA=new JTextArea();
    public JButton menu=new JButton("MENU");
    public JFrame Scoreboard(JFrame frame){
        return null;
    }
    public FileReader File;
    {
        try {
            File = new FileReader("ScoreBoard");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
