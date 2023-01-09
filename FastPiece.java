/**
 * CSCI 2110 Assignment 1
 * By Mihir Patel
 * B00915555
 *
 *  I have used basic java and OOPs concept in this class.
 *  I have created getters,setters,move method to move the position and toString method in this class.
 *  FastPiece class will extend the Piece class
 */

import java.awt.*;

public class FastPiece extends Piece {

    /**
     * Constructor 1 for the FastPiece class
     * @param Name : Name of the player
     * @param colour : Colour chosen by a player
     * @param position : Position from where the player will start the boardgame
     */
    public FastPiece(String Name, String colour, Point position) {
        super(Name, colour, position);
    }

    /**
     * Constructor 2 for class FastPiece
     * @param position : Position from where the player will start the boardgame
     */
    public FastPiece(Point position) {
        super(position);
    }

    /**
     * Constructor 3 for the FastPiece class, empty constructor
     */
    public FastPiece() {

    }


    /**
     * This method can move the piece right or left by any number of position until the Piece is in the range of Board
     * @param direction : Direction in which player wants to move their piece
     * @return a Point - New Point after changing the position
     */
    public Point move(String direction, int n) {
        Point newPos = new Point(getPosition().x, getPosition().y);
        if (direction.equals("left")) {
            newPos.y = (getPosition().y - n);
        } else if (direction.equals("right")) {
            newPos.y = (getPosition().y + n);
        }


        if (newPos.y >= 0 && newPos.y <= 7) {
            setPosition(newPos);
        }
        return newPos;
    }


    // This method overrides the Piece toString method, along with it, it will add F to the output which shows that the piece is FastPiece
    public String toString() {
        return super.getName()+ super.getColour()+ "F";
    }
}
