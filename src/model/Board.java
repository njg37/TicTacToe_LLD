package model;

public class Board {
    private int size;
    private Cell[][] grid;

    public Board(int size){
        this.size=size;
        this.grid=new Cell[size][size];

        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                grid[i][j]=new Cell(i,j);
            }
        }
    }

    public void DisplayBoard(){
        for(int i=0;i<size;i
                ++){
            for(int j=0;j<size;j++){
                if(grid[i][j]==null){
                    System.out.print("- ");
                }else {
                    System.out.print(grid[i][j].getSymbol()+" ");
                }
            }
            System.out.println();
        }
    }


    public boolean placeMove(int row, int col, PlayerSymbol symbol){
        if(!isValidMove(row,col)){
            return false;
        }
        grid[row][col].setSymbol(symbol);
        return true;
    }
    public boolean isValidMove(int row, int col){
        if (row<0 || row>=size || col<0 || col>=size ) {
            return false;
        } else if (!grid[row][col].isEmpty()) {
            return false;
        }
        return true;
//        return row >= 0 && row < size &&
//                col >= 0 && col < size &&
//                grid[row][col].isEmpty();

    }
    public boolean checkWin(int row, int col, PlayerSymbol symbol){
        boolean winInRow=true;
        for(int i=0;i<size;i++){
            if (grid[row][i].getSymbol()!=symbol){
                winInRow= false;
                break;
            }
        }
        boolean winInCol=true;
        for (int i=0;i<size;i++){
            if (grid[i][col].getSymbol()!=symbol){
                winInCol= false;
                break;
            }
        }

        boolean winInDiagonal = false;
        if (row==col) {
            winInDiagonal=true;
            for (int i = 0; i < size; i++) {
                int j = i;
                if (grid[i][j].getSymbol() != symbol) {
                    winInDiagonal = false;
                    break;
                }


            };
        }
        boolean winInAntiDiagonal=false;
        if(row+col==size-1){
            winInAntiDiagonal=true;
            for(int i=0;i<size;i++){
                int j=size-1-i;
                if (grid[i][j].getSymbol()!=symbol){
                    winInAntiDiagonal=false;
                    break;
                }
            }
        }
        return  winInRow || winInCol || winInDiagonal || winInAntiDiagonal;
        
    }
    public boolean isFull(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(grid[i][j].isEmpty()){
                    return false;
                }
            }
        }
        return true;
    }
    public int getSize(){
        return size;
    }
    public Cell[][] getGrid(){
        return grid;
    }
}
