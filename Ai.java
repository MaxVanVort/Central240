import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Ai {
    private JButton jChoice;
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
    public Ai(){


    }
}
