import java.util.ArrayList;

public class Player {
    public static Player user;
    private String username;
    private int w;
    private int l;
    private int t;
    public Player(){
        username = "Player";
        w = 0;
        l = 0;
        t = 0;
    }
    public Player(String player){
        this.username = player;
        this.w = 0;
        this.l = 0;
        this.t = 0;
    }
    public String getScore(){
        return (username + ": " + this.w +"/"+ this.l +"/"+ this.t );
    }
    public void set(String wins, String losses, String tie ){
        this.w += Integer.parseInt(wins);
        this.l += Integer.parseInt(losses);
        this.t += Integer.parseInt(tie);
    }
    public void set(int wins, int losses, int tie ){
        this.w = wins;
        this.l = losses;
        this.t = tie;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String u){
        this.username=u;
    }

    public void get(Player player){
        user = player;
    }
    public Player getPlayer(){
        return user;
    }

}
