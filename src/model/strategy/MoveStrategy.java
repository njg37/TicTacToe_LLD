package model.strategy;

import model.Board;
import model.Move;

public interface MoveStrategy {
    Move getMove(Board board);
}
