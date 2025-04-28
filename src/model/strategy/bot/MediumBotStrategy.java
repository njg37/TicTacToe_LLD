package model.strategy.bot;

import model.Board;
import model.Cell;
import model.Move;
import model.PlayerSymbol;
import model.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MediumBotStrategy implements MoveStrategy {
    private PlayerSymbol botSymbol;

    public MediumBotStrategy(PlayerSymbol botSymbol) {
        this.botSymbol = botSymbol;
    }

    @Override
    public Move getMove(Board board) {
        int size = board.getSize();
        Cell[][] grid = board.getGrid();

        PlayerSymbol opponentSymbol = (botSymbol == PlayerSymbol.X) ? PlayerSymbol.O : PlayerSymbol.X;

        // 1. Try to win
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j].isEmpty()) {
                    grid[i][j].setSymbol(botSymbol);
                    if (board.checkWin(i, j, botSymbol)) {
                        grid[i][j].setSymbol(PlayerSymbol.EMPTY);
                        return new Move(i, j);
                    }
                    grid[i][j].setSymbol(PlayerSymbol.EMPTY);
                }
            }
        }

        // 2. Try to block
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j].isEmpty()) {
                    grid[i][j].setSymbol(opponentSymbol);
                    if (board.checkWin(i, j, opponentSymbol)) {
                        grid[i][j].setSymbol(PlayerSymbol.EMPTY);
                        return new Move(i, j);
                    }
                    grid[i][j].setSymbol(PlayerSymbol.EMPTY);
                }
            }
        }

        List<Move> availableMoves = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j].isEmpty()) {
                    availableMoves.add(new Move(i, j));
                }
            }
        }
        if (!availableMoves.isEmpty()) {
            return availableMoves.get(new Random().nextInt(availableMoves.size()));
        }

        return null;
    }
}