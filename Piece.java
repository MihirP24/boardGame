/**
 * CSCI 2110 Assignment 1
 * By Mihir Patel
 * B00915555
 *
 *  I have used basic java and OOPs concept in this class.
 *  I have created getters,setters and toString method in this class.
 */


import java.awt.*;
import java.util.Arrays;


public class Piece {

    // Creating instance variables
    private String Name;
    private String Colour;
    private Point position;

    /**
     * Constructor 1 for class Piece.
     * @param Name : Name of the player
     * @param colour : Colour chosen by a player
     * @param position : Position from where the player will start the boardgame
     */
    public Piece(String Name, String colour, Point position) {
        this.Name = Name;
        this.Colour = colour;
        this.position = position;
    }

    /**
     * Constructor 2 for class Piece
     * @param position : Position from where the player will start the boardgame
     */
    public Piece(Point position) {
        this.position.x = position.x;
        this.position.y = position.y;
    }

    /**
     * Constructor 3 for the Piece class, empty constructor
     */
    public Piece() {

    }

    // getters and setters
    public void setName(String name) {Name = name;}
    public void setColour(String colour) {
        Colour = colour;
    }
    public String getName() {
        return Name;
    }
    public String getColour() {
        return Colour;
    }
    public void setPosition(Point position) {

        this.position.setLocation(position.x,position.y);
    }
    public Point getPosition() {
        return this.position.getLocation();
    }

    /**
     * Method to get the needed output
     * @return a String by converting all the variables to String
     */
    public String toString() {
        return getName()+getColour();
    }

}
