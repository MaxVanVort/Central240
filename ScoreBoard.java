import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreBoard extends JPanel implements ActionListener {
    protected JTextField tF;
    protected JTextArea tA;
    private final static String newline = "\n";
    public ArrayList<String> scores = new ArrayList<>();
    Player user = Player.user.getPlayer();
    int win;
    int los;
    int tie;
    public ScoreBoard(){

        tF = new JTextField(user.getUsername(),20);
        tA = new JTextArea(13, 13);
        if (!tA.isVisible()){

        }
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

                user.set(neWin, newLos,newTie);
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
    public void newScores(){
        try {
            // Step 1:  Create an object of FileOutputStream
            FileWriter outputStream = new FileWriter("ScoreBoard.txt");
            for (String line : scores) {

                int currentLine = scores.indexOf(line);

                outputStream.write(scores.get(currentLine) + newline);

            }

            outputStream.close();


        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
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
            int currentLine = scores.indexOf(score);

            if (user.getUsername().equals(userName)){
                int neWin = Integer.parseInt(score.substring(score.indexOf(":")+2, score.indexOf("/")));
                int newLos = Integer.parseInt(score.substring(score.indexOf("/")+1, score.lastIndexOf("/")));
                int newTie = Integer.parseInt(score.substring(score.lastIndexOf("/")+1));

                win = Integer.parseInt(newScore.substring(newScore.indexOf(":")+2, newScore.indexOf("/")));
                los = Integer.parseInt(newScore.substring(newScore.indexOf("/")+1, newScore.lastIndexOf("/")));
                tie = Integer.parseInt(newScore.substring(newScore.lastIndexOf("/")+1));

                user.set(neWin, newLos, newTie);
                scores.set(scores.indexOf(score),user.getScore());
                newUserName = false;
                tA.append(">" + scores.get(currentLine) + "<" + newline);
            } else { tA.append(scores.get(currentLine) + newline); }


        }

        if (newUserName){
            user.set(0,0,0);
            tA.append(">" + user.getScore() + "<" + newline);
            scores.add(user.getScore());
            newScores();
        }
        tF.selectAll();
        tA.setCaretPosition(tA.getDocument().getLength());


    }


}
