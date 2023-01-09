/**
 * CSCI 2110 Assignment 1
 * By Mihir Patel
 * B00915555
 *
 *  I have used basic java and OOPs concept in this class.
 *  I have created getters,setters,move method to move the piece as per the piece type and toString method in this class.
 *  I have also created addPiece method, which will add the piece at iputted position and displayBoard method to get the gameboard
 *  Additionally,I have also created an isNull method which will tell whether the position is null or not
 */

import java.awt.*;

public class Board {

    // Creating 2d array of 8*8 for the game board
    String[][] gameBoard = new String[8][8];

    /**
     * Constructor for class Board
     * Have entered '-' to all the position of 2d array to create the game board
     */
    public Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                gameBoard[i][j] = "-\t";
            }
        }
    }

    // getters and setters
    public String[][] getGameBoard() {
        return gameBoard;
    }
    public void setGameBoard(String[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    /**
     * This method will add the piece at the position inputted by the player
     * @param piece : class Piece
     */
    public void addPiece(Piece piece) {
        int xPos = piece.getPosition().x;
        int yPos = piece.getPosition().y;
        if (isNull(xPos,yPos)) {
            gameBoard[xPos][yPos] = piece.toString();
        }
    }

    /**
     * This method will check the type of the piece and will call the move method of the that particular type.
     * It will print an error msg if the user will try to move the piece of a X type by the piece of Y type
     * It will also print an error msg if the piece will be out of the board while moving
     * @param position : Position inputted by user from where he/she wants to start the game
     * @param direction : Direction in which player wants to move their piece
     * @param num : num of position by which the player wants to move the Piece
     * @param piece : class Piece
     */
    public void move(Point position,String direction,int num, Piece piece) {
        int xPos= position.x;
        int yPos=position.y;
        String data=gameBoard[xPos][yPos];
        Point move=new Point(xPos,yPos);
        if(piece instanceof SlowPiece && num == 1){
            move = ((SlowPiece) piece).move(direction);
        }
        else if(piece instanceof FastPiece){
            move = ((FastPiece) piece).move(direction,num);
        }

        if ((move.x>=0 && move.x<=7) && (move.y>=0 && move.y<=7)){
            if(move.x==xPos && move.y==yPos) {
                System.out.println("Move type and piece type doesn't match");
            }else{
                gameBoard[move.x][move.y] = data;
                gameBoard[xPos][yPos] = "-\t";
                System.out.printf("Piece at (%d,%d) moved %s by %d spaces\n", xPos, yPos, direction, num);
            }
        }else{
            System.out.println("Move range is out of the board");
        }
    }

    /**
     * This method will display the Board
     * It will not return anything as it is a void method
     */
    public void displayBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * This method will help me to check whether the particular position is null or not
     * @param xPos : x position of the point
     * @param yPos : y position of the point
     * @return true if the position is null or else false
     */
    public boolean isNull(int xPos,int yPos){
        return gameBoard[xPos][yPos].equals("-\t");
    }


}
