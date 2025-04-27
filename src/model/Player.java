package model;

import model.strategy.MoveStrategy;

public class Player {
    private String name;
    private PlayerSymbol symbol;
    private MoveStrategy moveStrategy;

    public  Player(String name, PlayerSymbol symbol, MoveStrategy moveStrategy){
        this.name=name;
        this.symbol=symbol;
        this.moveStrategy=moveStrategy;
    }

    public String getName(){
        return name;
    }

    public PlayerSymbol getSymbol() {
        return symbol;
    }
    public Move getMove(Board board){
        return moveStrategy.getMove(board);
    }
}
