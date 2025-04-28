package model;

import model.strategy.HumanMoveStrategy;
import model.strategy.MoveStrategy;

import model.strategy.bot.EasyBotStrategy;
import model.strategy.bot.MediumBotStrategy;
import model.strategy.bot.HardBotStrategy;


import java.util.Scanner;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private int boardSize;
    Scanner sc = new Scanner(System.in);
    public Game(){
        System.out.println("Board Size ");
        boardSize=sc.nextInt();
        board=new Board(boardSize);

        System.out.println("Do you want to play against 1. Human or 2. Bot ");
        int choice= sc.nextInt();



        System.out.println("Player1 Name ");
        String name1= sc.next();
        System.out.println("Player1 Symbol (X or O)");
        String symbolInput1=sc.next();
        PlayerSymbol symbol1=PlayerSymbol.valueOf(symbolInput1.toUpperCase());
        MoveStrategy moveStrategy1;

        moveStrategy1=new HumanMoveStrategy();
        player1=new Player(name1,symbol1,moveStrategy1);

        PlayerSymbol symbol2 = (symbol1==PlayerSymbol.X)? PlayerSymbol.O:PlayerSymbol.X;
        MoveStrategy moveStrategy2;

        if(choice==1){
            System.out.println("Player2 Name ");
            String name2=sc.next();
            moveStrategy2=new HumanMoveStrategy();
            player2=new Player(name2,symbol2,moveStrategy2);
        } else {
            System.out.println("Enter Difficulty Level: 1.Easy 2.Medium 3.Hard");
            int level=sc.nextInt();
            switch (level) {
                case 1:
                    moveStrategy2 = new EasyBotStrategy();
                    break;
                case 2:
                    moveStrategy2 = new MediumBotStrategy(symbol2);
                    break;
//                case 3:
//                    moveStrategy2 = new HardBotStrategy();
//                    break;
                default:
                    System.out.println("Invalid difficulty level.");
                    return; // Exit or handle invalid input gracefully
            }


            player2=new Player("Bot",symbol2,moveStrategy2);
        }
        currentPlayer=player1.getSymbol()==PlayerSymbol.X?player1:player2;


    }
    public void Play(){
        while (true){

            System.out.println(currentPlayer.getName()+"'s turn ("+ currentPlayer.getSymbol()+")");
            board.DisplayBoard();
            Move move=currentPlayer.getMove(board);

            if(!board.placeMove(move.getRow(),move.getCol(),currentPlayer.getSymbol())){
                System.out.println("Invalid move ");
                continue;
            }
            board.DisplayBoard();
            if(board.checkWin(move.getRow(), move.getCol(), currentPlayer.getSymbol())){
                System.out.println(currentPlayer.getName()+"Wins");
                break;
            }
            if(board.isFull()){
                System.out.println("Its Draw");
                break;
            }
            currentPlayer=(currentPlayer==player1)?player2:player1;


        }
    }

}
