import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NewGame implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame();
    //JPanel title_panel = new JPanel();
    JPanel grid = new JPanel();
    //JLabel textField = new JLabel();
    boolean gameOver = false;
    public ArrayList<String> scores = new ArrayList<>();

    ArrayList<JButton> buttons = new ArrayList<>();
    boolean yourTurn;

    private boolean WIN = false;
    private boolean LOS = false;
    private boolean TIE = false;

    NewGame(){
        frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);


        for(int i=0;i<9;i++){
            buttons.add(i,new JButton());
            buttons.get(i).setText("");
            grid.add(buttons.get(i));
            buttons.get(i).setFocusable(false);
            buttons.get(i).addActionListener(this);
        }
        fTurn();
        frame.setSize(300,300);
        grid.setLayout(new GridLayout(3, 3));
        grid.setBackground(new Color(150,150,150));
        // makes a vertical box layout for the grid of button.
        BoxLayout mainLayout = new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS);
        frame.getContentPane().setLayout(mainLayout);
        // add the grid
        frame.getContentPane().add(grid);


        frame.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (!gameOver) {

            for (int i = 0; i < 9; i++) {
                if (e.getSource() == buttons.get(i)) {
                    if (yourTurn) {
                        if (buttons.get(i).getText().equals("")) {
                            buttons.get(i).setText("X");
                            if( won("X")){
                                win("X");
                            }
                            win("");
                            yourTurn = false;

                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            if (!gameOver) {
                                aiBenny();
                                win("O");
                                win("");
                            }
                            if (gameOver){
                                updateScores();
                            }
                        }
                    }
                }


            }
        }


    }


    public void fTurn() {
        yourTurn = random.nextInt(2) == 1;
        if (!yourTurn){
            aiBenny();
            yourTurn = true;
        }

    }
    public boolean won(String PorB){
        boolean b1 = buttons.get(0).getText().equals(PorB);
        boolean b2 = buttons.get(1).getText().equals(PorB);
        boolean b3 = buttons.get(2).getText().equals(PorB);
        boolean b4 = buttons.get(3).getText().equals(PorB);
        boolean b5 = buttons.get(4).getText().equals(PorB);
        boolean b6 = buttons.get(5).getText().equals(PorB);
        boolean b7 = buttons.get(6).getText().equals(PorB);
        boolean b8 = buttons.get(7).getText().equals(PorB);
        boolean b9 = buttons.get(8).getText().equals(PorB);

        if (b1 && b2 && b3){
            return (true);
        }else if (b4 && b5 && b6){
            return (true);
        }else if (b7 && b8 && b9){
            return (true);
        }else if (b1 && b4 && b7){
            return (true);
        }else if (b2 && b5 && b8){
            return (true);
        }else if (b3 && b6 && b9){
            return (true);
        }else if (b1 && b5 && b9){
            return (true);
        } else if (b3 && b5 && b7){
            return (true);
        }else return false;

    }

    public void win(String PorB){
        boolean b1 = buttons.get(0).getText().equals(PorB);
        boolean b2 = buttons.get(1).getText().equals(PorB);
        boolean b3 = buttons.get(2).getText().equals(PorB);
        boolean b4 = buttons.get(3).getText().equals(PorB);
        boolean b5 = buttons.get(4).getText().equals(PorB);
        boolean b6 = buttons.get(5).getText().equals(PorB);
        boolean b7 = buttons.get(6).getText().equals(PorB);
        boolean b8 = buttons.get(7).getText().equals(PorB);
        boolean b9 = buttons.get(8).getText().equals(PorB);

        if (!PorB.equals("")) {

            if (b1 && b2 && b3) {

            if (PorB.equals("X")) {
                buttons.get(0).setBackground(Color.GREEN);
                buttons.get(1).setBackground(Color.GREEN);
                buttons.get(2).setBackground(Color.GREEN);

                buttons.get(0).setText("W");
                buttons.get(1).setText("I");
                buttons.get(2).setText("N");
                WIN = true;
            } else if (PorB.equals("O")) {
                buttons.get(0).setBackground(Color.RED);
                buttons.get(1).setBackground(Color.RED);
                buttons.get(2).setBackground(Color.RED);

                buttons.get(0).setText("L");
                buttons.get(1).setText("O");
                buttons.get(2).setText("S");
                LOS = true;
            }
            gameOver = true;
            for (int i = 0; i < 9; i++) {

                buttons.get(i).setEnabled(false);
            }
        } else if (b4 && b5 && b6) {

            if (PorB.equals("X")) {
                buttons.get(3).setBackground(Color.GREEN);
                buttons.get(4).setBackground(Color.GREEN);
                buttons.get(5).setBackground(Color.GREEN);

                buttons.get(3).setText("W");
                buttons.get(4).setText("I");
                buttons.get(5).setText("N");

            } else if (PorB.equals("O")) {
                buttons.get(3).setBackground(Color.RED);
                buttons.get(4).setBackground(Color.RED);
                buttons.get(5).setBackground(Color.RED);

                buttons.get(3).setText("L");
                buttons.get(4).setText("O");
                buttons.get(5).setText("S");
            }
            gameOver = true;
            for (int i = 0; i < 9; i++) {
                buttons.get(i).setEnabled(false);
            }

        } else if (b7 && b8 && b9) {

            if (PorB.equals("X")) {
                buttons.get(6).setBackground(Color.GREEN);
                buttons.get(7).setBackground(Color.GREEN);
                buttons.get(8).setBackground(Color.GREEN);

                buttons.get(6).setText("W");
                buttons.get(7).setText("I");
                buttons.get(8).setText("N");
            }else if (PorB.equals("O")) {
                buttons.get(6).setBackground(Color.RED);
                buttons.get(7).setBackground(Color.RED);
                buttons.get(8).setBackground(Color.RED);

                buttons.get(6).setText("L");
                buttons.get(7).setText("O");
                buttons.get(8).setText("S");
            }
            gameOver = true;
            for (int i = 0; i < 9; i++) {
                buttons.get(i).setEnabled(false);
            }
        } else if (b1 && b4 && b7) {

            if (PorB.equals("X")) {
                buttons.get(0).setBackground(Color.GREEN);
                buttons.get(3).setBackground(Color.GREEN);
                buttons.get(6).setBackground(Color.GREEN);

                buttons.get(0).setText("W");
                buttons.get(3).setText("I");
                buttons.get(6).setText("N");
            }else if (PorB.equals("O")) {
                buttons.get(0).setBackground(Color.RED);
                buttons.get(3).setBackground(Color.RED);
                buttons.get(6).setBackground(Color.RED);

                buttons.get(0).setText("L");
                buttons.get(3).setText("O");
                buttons.get(6).setText("S");
            }
            gameOver = true;
            for (int i = 0; i < 9; i++) {
                buttons.get(i).setEnabled(false);
            }
        } else if (b2 && b5 && b8) {

            if (PorB.equals("X")) {
                buttons.get(1).setBackground(Color.GREEN);
                buttons.get(4).setBackground(Color.GREEN);
                buttons.get(7).setBackground(Color.GREEN);

                buttons.get(1).setText("W");
                buttons.get(4).setText("I");
                buttons.get(7).setText("N");
            } else if (PorB.equals("O")) {
                buttons.get(1).setBackground(Color.RED);
                buttons.get(4).setBackground(Color.RED);
                buttons.get(7).setBackground(Color.RED);

                buttons.get(1).setText("L");
                buttons.get(4).setText("O");
                buttons.get(7).setText("S");
            }
            gameOver = true;
            for (int i = 0; i < 9; i++) {
                buttons.get(i).setEnabled(false);
            }
        } else if (b3 && b6 && b9) {

            if (PorB.equals("X")) {
                buttons.get(2).setBackground(Color.GREEN);
                buttons.get(5).setBackground(Color.GREEN);
                buttons.get(8).setBackground(Color.GREEN);

                buttons.get(2).setText("W");
                buttons.get(5).setText("I");
                buttons.get(8).setText("N");
            }else if (PorB.equals("O")) {
                buttons.get(2).setBackground(Color.RED);
                buttons.get(5).setBackground(Color.RED);
                buttons.get(8).setBackground(Color.RED);

                buttons.get(2).setText("L");
                buttons.get(5).setText("O");
                buttons.get(8).setText("S");
            }
            gameOver = true;
            for (int i = 0; i < 9; i++) {
                buttons.get(i).setEnabled(false);
            }
        } else if (b1 && b5 && b9) {

            if (PorB.equals("X")) {
                buttons.get(0).setBackground(Color.GREEN);
                buttons.get(4).setBackground(Color.GREEN);
                buttons.get(8).setBackground(Color.GREEN);

                buttons.get(0).setText("W");
                buttons.get(4).setText("I");
                buttons.get(8).setText("N");
            } else if (PorB.equals("O")) {
                buttons.get(0).setBackground(Color.RED);
                buttons.get(4).setBackground(Color.RED);
                buttons.get(8).setBackground(Color.RED);

                buttons.get(0).setText("L");
                buttons.get(4).setText("O");
                buttons.get(8).setText("S");
            }
            gameOver = true;
            for (int i = 0; i < 9; i++) {
                buttons.get(i).setEnabled(false);
            }
        } else if (b3 && b5 && b7) {

            if (PorB.equals("X")) {
                buttons.get(2).setBackground(Color.GREEN);
                buttons.get(4).setBackground(Color.GREEN);
                buttons.get(6).setBackground(Color.GREEN);

                buttons.get(2).setText("W");
                buttons.get(4).setText("I");
                buttons.get(6).setText("N");
                Player.user.set("1","0","0");
            } else if (PorB.equals("O")) {
                buttons.get(2).setBackground(Color.RED);
                buttons.get(4).setBackground(Color.RED);
                buttons.get(6).setBackground(Color.RED);

                buttons.get(2).setText("L");
                buttons.get(4).setText("O");
                buttons.get(6).setText("S");
            }
            gameOver = true;
            for (int i = 0; i < 9; i++) {
                buttons.get(i).setEnabled(false);
            }
        }
    } else {
        //tie
            if (!(b1 || b2 || b3 || b4 || b5 || b6 || b7 || b8 || b9)) {
                buttons.get(0).setBackground(Color.BLUE);
                buttons.get(1).setBackground(Color.BLUE);
                buttons.get(2).setBackground(Color.BLUE);
                buttons.get(3).setBackground(Color.BLUE);
                buttons.get(4).setBackground(Color.BLUE);
                buttons.get(5).setBackground(Color.BLUE);
                buttons.get(6).setBackground(Color.BLUE);
                buttons.get(7).setBackground(Color.BLUE);
                buttons.get(8).setBackground(Color.BLUE);
                gameOver = true;

                buttons.get(0).setText("T");
                buttons.get(1).setText("I");
                buttons.get(2).setText("E");

                buttons.get(3).setText("T");
                buttons.get(4).setText("I");
                buttons.get(5).setText("E");

                buttons.get(6).setText("T");
                buttons.get(7).setText("I");
                buttons.get(8).setText("E");
                TIE = true;
                for (int i = 0; i < 9; i++) {
                    buttons.get(i).setEnabled(false);
                }
            }

    }



    }
    public int fTurn(int min, int max) {
        Random random = new Random();
        return (random.nextInt(max - min) + min);
    }

    public void aiBenny() {
        JButton bChoice;
        ArrayList<JButton> bestOption = new ArrayList<>();
        ArrayList<JButton> secondBestOptions = new ArrayList<>();
        ArrayList<JButton> options = new ArrayList<>();


        for (JButton i : buttons) {

            if (i.getText().equals("")) {
                options.add(i);
            }

        }
        if (options.size() == 0) {
            gameOver = true;

        } else {
            for (JButton is : options) {

                //checks to see if the AI could win with this option.
                is.setText("O");
                if (won("O")) {
                    // find the button in options, finds the matching button in keys, and gets the index of the button in keys and adds it to bestOptions.
                    bestOption.add(is);
                }
                //Checks to see if this option could stop you.
                is.setText("X");
                if (won("X")) {
                    secondBestOptions.add(is);
                }
                is.setText("");
            }


            if (bestOption.size() != 0) {
                bChoice = bestOption.get(fTurn(0, bestOption.size()));

            } else if (secondBestOptions.size() != 0) {
                bChoice = secondBestOptions.get(fTurn(0, secondBestOptions.size()));
            } else {
                bChoice = options.get(fTurn(0, options.size()));
            }
            bestOption.clear();
            secondBestOptions.clear();
            options.clear();

            bChoice.setText("O");
            win("O");
            yourTurn = true;
        }
    }
    public void updateScores(){
        final String newline = "\n";
        try {
            // Step 1:  Create an object of FileOutputStream
            fileReader();
            FileWriter outputStream = new FileWriter("ScoreBoard.txt");
            for (String line : scores) {
                String userName = line.substring(0, line.indexOf(":") );
                int neWin = Integer.parseInt(line.substring(line.indexOf(":")+2, line.indexOf("/")));
                int newLos = Integer.parseInt(line.substring(line.indexOf("/")+1, line.lastIndexOf("/")));
                int newTie = Integer.parseInt(line.substring(line.lastIndexOf("/")+1));
                int currentLine = scores.indexOf(line);

                if (Player.user.getUsername().equals(userName)){

                    if (WIN){
                        Player.user.set(neWin+1, newLos,newTie);
                    } else if (LOS){
                        Player.user.set(neWin, newLos+1,newTie);
                    } else if (TIE){
                        Player.user.set(neWin, newLos,newTie+1);
                    } else{
                        Player.user.set(neWin, newLos,newTie);
                    }
                    scores.set(currentLine,Player.user.getScore());
                }
                if (line.substring(0,line.indexOf(":")).equals("Bny")){
                    if (WIN){
                        scores.set(currentLine,"Bny: " + (neWin) + "/" + (newLos+1)+"/"+(newTie) );
                    } else if (LOS){
                        scores.set(currentLine,"Bny: " + (neWin+1) + "/" + (newLos)+"/"+(newTie) );
                    } else if (TIE){
                        scores.set(currentLine,"Bny: " + (neWin) + "/" + (newLos)+"/"+(newTie+1) );
                    }
                }


                outputStream.write(scores.get(currentLine) + newline);


            }

            outputStream.close();


        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
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

}