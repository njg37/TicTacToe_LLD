package model.strategy;

import model.Board;
import model.Cell;
import model.Move;

public class BotMoveStrategy implements MoveStrategy{
    @Override
    public Move getMove(Board board){
        int size=board.getSize();
        for (int row=0;row<size;row++){
            for (int col=0;col<size;col++){
                Cell cell=board.getGrid()[row][col];
                if (cell.isEmpty()){
                    return new  Move(row,col);
                }
            }
        }
        return null;
    }
}
