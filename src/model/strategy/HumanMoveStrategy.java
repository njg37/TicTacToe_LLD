package model.strategy;

import model.Board;
import model.Move;

import java.util.Scanner;

public class HumanMoveStrategy implements MoveStrategy{
    private Scanner sc = new Scanner(System.in);
    @Override
    public Move getMove(Board board){
        System.out.println("Enter Row ");
        int row= sc.nextInt();
        System.out.println("Enter Col");
        int col= sc.nextInt();
        return new Move(row,col);
    }
}
