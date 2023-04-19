import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class NewGame implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame();
    //JPanel title_panel = new JPanel();
    JPanel grid = new JPanel();
    //JLabel textfield = new JLabel();
    boolean gameOver = false;

    ArrayList<JButton> buttons = new ArrayList<>();
    boolean yourTurn;

    NewGame(){
        frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
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
        BoxLayout mainLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
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
                        }
                    }
                }


            }
        } else {

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
                Player.user.set("1","0","0");
            } else if (PorB.equals("O")) {
                buttons.get(0).setBackground(Color.RED);
                buttons.get(1).setBackground(Color.RED);
                buttons.get(2).setBackground(Color.RED);

                buttons.get(0).setText("L");
                buttons.get(1).setText("O");
                buttons.get(2).setText("S");
                Player.user.set("0","1","0");
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
                Player.user.set("1","0","0");
            } else if (PorB.equals("O")) {
                buttons.get(3).setBackground(Color.RED);
                buttons.get(4).setBackground(Color.RED);
                buttons.get(5).setBackground(Color.RED);

                buttons.get(3).setText("L");
                buttons.get(4).setText("O");
                buttons.get(5).setText("S");
                Player.user.set("0","1","0");
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
                Player.user.set("1","0","0");
            }else if (PorB.equals("O")) {
                buttons.get(6).setBackground(Color.RED);
                buttons.get(7).setBackground(Color.RED);
                buttons.get(8).setBackground(Color.RED);

                buttons.get(6).setText("L");
                buttons.get(7).setText("O");
                buttons.get(8).setText("S");
                Player.user.set("0","1","0");
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
                Player.user.set("1","0","0");
            }else if (PorB.equals("O")) {
                buttons.get(0).setBackground(Color.RED);
                buttons.get(3).setBackground(Color.RED);
                buttons.get(6).setBackground(Color.RED);

                buttons.get(0).setText("L");
                buttons.get(3).setText("O");
                buttons.get(6).setText("S");
                Player.user.set("0","1","0");
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
                Player.user.set("1","0","0");
            } else if (PorB.equals("O")) {
                buttons.get(1).setBackground(Color.RED);
                buttons.get(4).setBackground(Color.RED);
                buttons.get(7).setBackground(Color.RED);

                buttons.get(1).setText("L");
                buttons.get(4).setText("O");
                buttons.get(7).setText("S");
                Player.user.set("0","1","0");
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
                Player.user.set("1","0","0");
            }else if (PorB.equals("O")) {
                buttons.get(2).setBackground(Color.RED);
                buttons.get(5).setBackground(Color.RED);
                buttons.get(8).setBackground(Color.RED);

                buttons.get(2).setText("L");
                buttons.get(5).setText("O");
                buttons.get(8).setText("S");
                Player.user.set("0","1","0");
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
                Player.user.set("1","0","0");
            } else if (PorB.equals("O")) {
                buttons.get(0).setBackground(Color.RED);
                buttons.get(4).setBackground(Color.RED);
                buttons.get(8).setBackground(Color.RED);

                buttons.get(0).setText("L");
                buttons.get(4).setText("O");
                buttons.get(8).setText("S");
                Player.user.set("0","1","0");
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
                Player.user.set("0","1","0");
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
                Player.user.set("0","0","1");
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
    /*public boolean nextTo (int button_, JButton next_to){
        return switch (button_) {
            case 1 -> (next_to == buttons.get(0) || next_to == buttons.get(4) || next_to == buttons.get(3));
            case 2 -> (next_to == buttons.get(0) || next_to == buttons.get(4) || next_to == buttons.get(2));
            case 3 -> (next_to == buttons.get(1) || next_to == buttons.get(4) || next_to == buttons.get(5));
            case 4 -> (next_to == buttons.get(0) || next_to == buttons.get(4) || next_to == buttons.get(6));
            case 5 -> (true);
            case 6 -> (next_to == buttons.get(2) || next_to == buttons.get(4) || next_to == buttons.get(8));
            case 7 -> (next_to == buttons.get(7) || next_to == buttons.get(4) || next_to == buttons.get(3));
            case 8 -> (next_to == buttons.get(6) || next_to == buttons.get(4) || next_to == buttons.get(8));
            case 9 -> (next_to == buttons.get(7) || next_to == buttons.get(4) || next_to == buttons.get(5));
            default -> false;
        };
    }*/

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

}