import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreBoard extends JPanel implements ActionListener {
    protected JTextField tF;
    protected JTextArea tA;
    private final static String newline = "\n";
    public JButton menu = new JButton("MENU");
    public ArrayList<String> scores = new ArrayList<>();
    Player user = Player.user.getPlayer();
    int win;
    int los;
    int tie;
    public ScoreBoard(){

        tF = new JTextField("Player",20);
        tA = new JTextArea(13, 13);
        tA.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(tA);

        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(tF, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);

        fileReader();
        tA.append("USER: WIN/LOS/TIE" + newline);
        for (String score:scores){
            String userName = score.substring(0, score.indexOf(":") );
            String newScore = user.getScore();
            if (user.getUsername().equals(userName)){
                int neWin = Integer.parseInt(score.substring(score.indexOf(":")+2, score.indexOf("/")));
                int newLos = Integer.parseInt(score.substring(score.indexOf("/")+1, score.lastIndexOf("/")));
                int newTie = Integer.parseInt(score.substring(score.lastIndexOf("/")+1));

                win = Integer.parseInt(newScore.substring(newScore.indexOf(":")+2, newScore.indexOf("/")));
                los = Integer.parseInt(newScore.substring(newScore.indexOf("/")+1, newScore.lastIndexOf("/")));
                tie = Integer.parseInt(newScore.substring(newScore.lastIndexOf("/")+1));

                user.set(win+neWin, los+newLos,tie+newTie);
                scores.set(scores.indexOf(score),user.getScore());
            } else { user.set(win,los,tie); }

            tA.append(score + newline);
        }
        tF.addActionListener(this);
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
        String text = tF.getText();


        while ( text.contains(":") ){
            String front = text.substring(0,text.indexOf(":"));
            String back = text.substring(text.indexOf(":")+1);
            text = front + back;
        }
        while ( text.contains("/") ){
            String front = text.substring(0,text.indexOf("/"));
            String back = text.substring(text.indexOf("/")+1);
            text = front + back;
        }
        if (text.equals("Bny")){
            text = "Benny";
        }
        user.setUsername(text);
        boolean newUserName = true;
        tA.setText("");
        tA.append("USER: WIN/LOS/TIE" + newline);
        for (String score:scores){
            String userName = score.substring(0, score.indexOf(":") );
            String newScore = user.getScore();
            if (user.getUsername().equals(userName)){
                win = Integer.parseInt(score.substring(score.indexOf(":")+2, score.indexOf("/")));
                los = Integer.parseInt(score.substring(score.indexOf("/")+1, score.lastIndexOf("/")));
                tie = Integer.parseInt(score.substring(score.lastIndexOf("/")+1));

                int neWin = Integer.parseInt(newScore.substring(newScore.indexOf(":")+2, newScore.indexOf("/")));
                int newLos = Integer.parseInt(newScore.substring(newScore.indexOf("/")+1, newScore.lastIndexOf("/")));
                int newTie = Integer.parseInt(newScore.substring(newScore.lastIndexOf("/")+1));

                user.set(win+neWin, los+newLos,tie+newTie);
                scores.set(scores.indexOf(score),user.getScore());
                newUserName = false;
            } else { user.set(win,los,tie); }

            tA.append(score + newline);
        }

        if (newUserName){
            tA.append(">" + user.getScore() + "<" + newline);
        }
        tF.selectAll();
        tA.setCaretPosition(tA.getDocument().getLength());
    }


}
