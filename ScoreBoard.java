import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreBoard extends JPanel implements ActionListener {
    JFrame frame;
    protected JTextField tF;
    protected JTextArea tA;
    private final static String newline = "\n";
    public JButton menu = new JButton("MENU");
    public ArrayList<String> scores = new ArrayList<>();
    public ScoreBoard(){
        frame = new JFrame("Score_Board");
        tF = new JTextField(5);
        tA = new JTextArea(2, 5);
        JScrollPane scrollPane = new JScrollPane(tA);
        tA.setEditable(false);

        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        add(tF, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);

        String text = tF.getText();
        fileReader();
        tA.append("USER: WIN/LOS/TIE" + newline);
        for (String score:scores){
            tA.append(score + newline);
        }

        frame.setSize(1000, 200);
        tA.setCaretPosition(tA.getDocument().getLength());
        // display the window.

        frame.setVisible(true);


    }
    private void fileReader() {
        try {
            //open the file.
            FileReader file = new FileReader("ScoreBoard.txt");

            // make a scanner
            Scanner in = new Scanner(file);


            // puts all words in arraylist
            while (in.hasNextLine()) {
                scores.add(in.nextLine());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
