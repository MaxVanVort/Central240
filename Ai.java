import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Ai {
    JButton bChoice;
    static ArrayList<JButton> bestOption = new ArrayList<>();
    static ArrayList<JButton> secondBestOptions = new ArrayList<>();
    static ArrayList<JButton> options = new ArrayList<>();
    public static int fTurn(int min, int max) {
        Random random = new Random();
        return (random.nextInt(max - min) + min);
    }
    public boolean nextTo (int button_, JButton next_to){
        return switch (button_) {
            case 1 -> (next_to == NewGame.b2 || next_to == NewGame.b5 || next_to == NewGame.b4);
            case 2 -> (next_to == NewGame.b1 || next_to == NewGame.b5 || next_to == NewGame.b3);
            case 3 -> (next_to == NewGame.b2 || next_to == NewGame.b5 || next_to == NewGame.b6);
            case 4 -> (next_to == NewGame.b1 || next_to == NewGame.b5 || next_to == NewGame.b7);
            case 5 -> (true);
            case 6 -> (next_to == NewGame.b3 || next_to == NewGame.b5 || next_to == NewGame.b9);
            case 7 -> (next_to == NewGame.b8 || next_to == NewGame.b5 || next_to == NewGame.b4);
            case 8 -> (next_to == NewGame.b7 || next_to == NewGame.b5 || next_to == NewGame.b9);
            case 9 -> (next_to == NewGame.b8 || next_to == NewGame.b5 || next_to == NewGame.b6);
            default -> false;
        };
    }
    //finds the buttons at a certain index 0-8
    public static JButton Button_(int ID){
        return switch (ID) {
            case 1 -> (NewGame.b1);
            case 2 -> (NewGame.b2);
            case 3 -> (NewGame.b3);
            case 4 -> (NewGame.b4);
            case 5 -> (NewGame.b5);
            case 6 -> (NewGame.b6);
            case 7 -> (NewGame.b7);
            case 8 -> (NewGame.b8);
            case 9 -> (NewGame.b9);
            default -> NewGame.b1;
        };

    }
    public Ai(){
        JButton bChoice;
    }

    public void getBChoice() {
        // Tells the AI its basic options.
        for (int i = 1; i < 10; i++) {

            if (Button_(i).getText().equals("")) {
                options.add(Button_(i));
                if ( i==5 ) {
                    options.add(Button_(i));
                }
                //If the option is next to an "O" then add it again.
                for (int I = 1; I < 10; I++)  {
                    if (nextTo(i, Button_(I))) {
                        options.add(Button_(i));
                    }
                }
            }
        }

        for (JButton is : options) {

            //checks to see if the AI could win with this option.
            is.setText("O");
            if (NewGame.won("O")) {
                // find the button in options, finds the matching button in keys, and gets the index of the button in keys and adds it to bestOptions.
                bestOption.add(is);
            }
            //Checks to see if this option could stop you.
            is.setText("X");
            if (NewGame.won("X")) {
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

        bChoice.setText("0");
    }

}
