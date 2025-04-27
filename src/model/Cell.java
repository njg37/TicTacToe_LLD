package model;

public class Cell {
    private int row;
    private int col;
    private PlayerSymbol symbol;

    public Cell(int row, int col){
        this.row=row;
        this.col=col;
        this.symbol=PlayerSymbol.EMPTY;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public void setRow(int row){
        this.row=row;
    }
    public  void setCol(int col){
        this.col=col;
    }
    public void setSymbol(PlayerSymbol symbol){
        this.symbol=symbol;
    }
    public PlayerSymbol getSymbol(){
        return symbol;
    }
    public boolean isEmpty(){
        return symbol==PlayerSymbol.EMPTY;
    }
}
