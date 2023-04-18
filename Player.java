public class Player {
    private String username;
    public boolean yourTurn;
    public void get(){
        yourTurn=true;

    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String u){
        username=u;
    }
    public Player(){

    }
}
