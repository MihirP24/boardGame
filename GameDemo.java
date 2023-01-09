/**
 * CSCI 2110 Assignment 1
 * By Mihir Patel
 * B00915555
 *
 *  I have used basic java and OOPs concept in this class.
 *  This is the main class of all the class
 */

import java.awt.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GameDemo {
    public static void main(String[] args) {

        // initialize a scanner class
        Scanner kb = new Scanner(System.in);

        // creating objects of the Board and Piece class
        Board b1 = new Board();
        Piece p1 = new Piece();

        // creating command variable
        String command = " ";

        // while loop to take command from the user until the user enters exit
        while (!command.equals("exit")) {

            // taking command as an input from the user
            System.out.println("Enter a Command (type help for details):");
            command = kb.next();

            // if user enters create as a command then it will add a piece at an inputted position
            if (command.equals("create")) {

                // creating tokenizer for taking input
                StringTokenizer input = new StringTokenizer(kb.nextLine());

                // splitting the tokenizer input in different variables
                String xx = input.nextToken();
                String yy = input.nextToken();

                // converting string to int
                int x = Integer.parseInt(xx);
                int y = Integer.parseInt(yy);
                String clasType = "";

                // if condition to take two tokens as a clastype if there are two tokens left,else take one token as a clastype
                if (input.hasMoreTokens()) {
                    clasType = input.nextToken();
                    if (input.hasMoreTokens()) {
                        clasType = clasType + " " + input.nextToken();
                    }
                }

                // if-else condition to print an error msg if the Piece position is out of the game board,else take name and colour as input and create piece
                if (x > 7 || y > 7 ) {
                    System.out.println("Invald Position! Please enter a valid x and y position");
                } else if(!b1.isNull(x,y)){
                    System.out.println("Error! Position is already taken");
                }else{
                    System.out.println("Input a Name for the new piece");
                    String name = kb.next();
                    System.out.println("Input a Colour for the new piece");
                    String color = kb.next();

                    // if-else conditions to check the class type
                    if (clasType.equals("fast flexible")) {
                        p1 = new FastFlexible(name, color, new Point(x, y));
                        b1.addPiece(p1);
                    } else if (clasType.equals("fast")) {
                        p1 = new FastPiece(name, color, new Point(x, y));
                        b1.addPiece(p1);
                    }  else if (clasType.equals("flexible")) {
                        p1 = new SlowFlexible(name, color, new Point(x, y));
                        b1.addPiece(p1);
                    }
                    else if (clasType.equals("")) {
                        p1 = new SlowPiece(name, color, new Point(x, y));
                        b1.addPiece(p1);
                    }
                }

                // if user enters print as a command then it will call the displayBoard method which will print the board
            } else if (command.equals("print")) {
                b1.displayBoard();

                // if user enters help, it will print the help box
            } else if (command.equals("help")) {
                System.out.println("Possible commands are as follows:");
                System.out.println("create location [fast][flexible]: Creates a new piece.");
                System.out.println("move location direction [spaces]: Moves a piece.");
                System.out.println("print: Displays the board.");
                System.out.println("help: Displays help.");
                System.out.println("exit: Exits the program.\n");

                // if user enters move, it will call the board move methods if there is a piece at an inputted position
            } else if (command.equals("move")) {
                // creating tokenizer for taking input
                StringTokenizer input = new StringTokenizer(kb.nextLine());

                // splitting the tokenizer input in different variables
                int countTokens=input.countTokens();
                String xx = input.nextToken();
                String yy = input.nextToken();

                // converting String to int
                int x = Integer.parseInt(xx);
                int y = Integer.parseInt(yy);


                String direction = "";
                String numMoveS = "";
                int numMoveI=1;

                // if condition to take one more token (numMove) if there are more tokens
                if (input.hasMoreTokens()) {
                    direction = input.nextToken();
                    if(input.hasMoreTokens()){
                        numMoveS = input.nextToken();
                        numMoveI = Integer.parseInt(numMoveS);
                    }
                }

                // if condition to print error message if the entered position is null , else call the move method
                if (b1.isNull(x, y)) {
                    System.out.printf("Error: no piece at (%d,%d)\n", x, y);
                }else{
                    b1.move(new Point(x, y), direction, numMoveI, p1);
                }
            }
        }

        // if user enters exit it terminates the programmes and print Done
        System.out.println("Done.");

    }
}


