package ly.generalassemb.drewmahrt.tictactoe;

/**
 * Created by David on 4/22/2016.
 */
public class Player {

    private String name;
    private boolean myTurn;

    public Player(String name) {
        this.name = name;
        myTurn = false;
    }

    public boolean isMyTurn() {
        return myTurn;
    }

    public void setMyTurn(boolean myTurn) {
        this.myTurn = myTurn;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
