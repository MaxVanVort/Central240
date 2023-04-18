public class Player {
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
    public String getScore(){
        return (username + ": " + Integer.toString(this.w) +"/"+ Integer.toString(this.l) +"/"+ Integer.toString(this.t) );
    }
    public void set(String wins, String losses, String tie ){
        w = Integer.parseInt(wins);
        l = Integer.parseInt(losses);
        t = Integer.parseInt(tie);
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String u){
        this.username=u;
    }

}
