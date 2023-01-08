/**
 * CSCI 2110 Assignment 1
 * By Mihir Patel
 * B00915555
 *
 *  I have used basic java and OOPs concept in this class.
 *  I have created getters,setters,move method to move the position and toString method in this class.
 *  SlowPiece class will extend the Piece class
 */

import javax.naming.Name;
import java.awt.*;


public class SlowPiece extends Piece {

    /**
     * Constructor 1 for the SlowPiece class
     * @param Name : Name of the player
     * @param colour : Colour chosen by a player
     * @param position : Position from where the player will start the boardgame
     */
    public SlowPiece(String Name, String colour, Point position) {
        super(Name, colour, position);
    }

    /**
     * Constructor 2 for class SlowPiece
     * @param position : Position from where the player will start the boardgame
     */
    public SlowPiece(Point position) {
        super(position);
    }


    /**
     * Constructor 3 for the SlowPiece class, empty constructor
     */
    public SlowPiece() {
    }


    /**
     * This method can move the piece right or left by 1 position
     * @param direction : Direction in which player wants to move their piece
     * @return a Point - New Point after changing the position
     */
    public Point move(String direction) {
        Point newPos = new Point(getPosition().x,getPosition().y);

        if (direction.equals("left")) {
            newPos.y = (getPosition().y - 1);
        } else if (direction.equals("right")) {
            newPos.y = (getPosition().y + 1);
        }

        if ((newPos.y >= 0 && newPos.y <= 7)){
            setPosition(newPos);
        }
        return newPos;
    }


    // This method overrides the Piece toString method, along with it, it will add S to the output which shows that the piece is SlowPiece
    public String toString() {
        return super.getName()+ super.getColour() + "S";
    }
}
