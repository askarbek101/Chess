package board;

public class Board {
    public String[][] chessBoard = {
            {"r","n","b","q","k","b","n","r"},
            {"p","p","p","p","p","p","p","p"},
            {"-","-","-","-","-","-","-","-"},
            {"-","-","-","-","-","-","-","-"},
            {"-","-","-","-","-","-","-","-"},
            {"-","-","-","-","-","-","-","-"},
            {"P","P","P","P","P","P","P","P"},
            {"R","N","B","Q","K","B","N","R"},
    };

    public void setChessBoard(String[][] chessBoard) {
        this.chessBoard = chessBoard;
    }
}
