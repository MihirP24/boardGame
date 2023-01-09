/**
 * CSCI 2110 Assignment 1
 * By Mihir Patel
 * B00915555
 *
 *  I have used basic java and OOPs concept in this class.
 *  I have created getters,setters,move method to move the position and toString method in this class.
 *  FastFlexible class will extend the FastPiece class
 */



import java.awt.*;

public class FastFlexible extends FastPiece {

    /**
     * Constructor 1 for the FastFlexible class
     * @param Name : Name of the player
     * @param colour : Colour chosen by a player
     * @param position : Position from where the player will start the boardgame
     */
    public FastFlexible(String Name, String colour, Point position) {
        super(Name, colour, position);
    }


    /**
     * Constructor 2 for class FastFlexible
     * @param position : Position from where the player will start the boardgame
     */
    public FastFlexible(Point position) {
        super(position);
    }

    /**
     * Constructor 3 for the FastFlexible class, empty constructor
     */
    public FastFlexible() {

    }

    /**
     * This method can move the piece right,left,up or down by any number of position until the Piece is in the range of Board
     * @param direction : Direction in which player wants to move their piece
     * @return a Point - New Point after changing the position
     */
    public Point move(String direction, int n) {
        Point newPos = new Point(getPosition().x, getPosition().y);
        if (direction.equals("left")) {
            newPos.y = (getPosition().y - n);
        } else if (direction.equals("right")) {
            newPos.y = (getPosition().y + n);
        } else if (direction.equals("up")) {
            newPos.x = (getPosition().x - n);
        } else if (direction.equals("down")) {
            newPos.x = (getPosition().x + n);
        }

        if ((newPos.y >= 0 && newPos.y <= 7) && (newPos.x >= 0 && newPos.x <= 7)) {
            setPosition(newPos);
        }
        return newPos;
    }


    // This method overrides the Piece toString method, along with it, it will add FF to the output which shows that the piece is FastFlexible
    public String toString() {
        return super.getName()+ super.getColour()+ "FF";
    }


}
