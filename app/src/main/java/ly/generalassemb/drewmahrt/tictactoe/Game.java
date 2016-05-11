package ly.generalassemb.drewmahrt.tictactoe;

/**
 * Created by David on 5/11/2016.
 */
public class Game {

    private String[][] board;

    public Game() {
        board = new String[3][3];
    }

    public void updateBoardAtLocation(int row, int col, String move) {
        board[row][col] = move;
    }

    public String[][] getBoard() {
        return board;
    }

}
