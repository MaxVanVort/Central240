import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ScoreBoard extends Menu{
    protected JTextField tF=new JTextField();
    protected JTextArea tA=new JTextArea();
    public JButton menu=new JButton();
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
}
