import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ScoreBoard extends Menu implements ActionListener {
    JFrame frame;
    public static JButton sb1 = new JButton("Score");
    public static JButton sb2 = new JButton("Wins");
    public static JButton sb3 = new JButton("User: ");
    public static JButton sb4 = new JButton("*USER WINS HERE*");
    public static JButton sb5 = new JButton("Benny: ");
    public static JButton sb6 = new JButton("*BENNY WINS HERE*");
    public static JButton sb7 = new JButton("Ties: ");
    public static JButton sb8 = new JButton("*TIES HERE*");
    protected JTextField tF=new JTextField();
    protected JTextArea tA=new JTextArea();
    public JButton menu=new JButton("MENU");
    public JFrame Scoreboard(JFrame frame){
        frame=new JFrame("Score_Board");
        JPanel sDisplay = new JPanel();
        GridLayout sbLayout = new GridLayout(4,2);
        sDisplay.setLayout(sbLayout);
        sDisplay.add(sb1);
        sDisplay.add(sb2);
        sDisplay.add(sb3);
        sDisplay.add(sb4);
        sDisplay.add(sb5);
        sDisplay.add(sb6);
        sDisplay.add(sb7);
        sDisplay.add(sb8);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(300, 300));
        sDisplay.setPreferredSize(new Dimension(300, 300));
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
