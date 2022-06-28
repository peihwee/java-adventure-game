/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import game.Room;
import java.util.Scanner;
/**
 *
 * @author Siah Peih Wee
 */
public class Game 
{
    public static int iCurrentRoom = 0;
    public static Room[] aRooms = new Room[4];

    public static String sCommand = "";

    public static void setupRooms() 
    {
        aRooms[0] = new Room("You are at the entrance of the cave.", 1, Room.NO_DOORS, Room.NO_DOORS, Room.NO_DOORS);
        aRooms[1] = new Room("The room is very windy.", 2, Room.NO_DOORS, 0, 3);
        aRooms[2] = new Room("You reached a dead end.", Room.NO_DOORS, Room.NO_DOORS, 1, Room.NO_DOORS);
        aRooms[3] = new Room("A very dark room", Room.NO_DOORS, 1, Room.NO_DOORS, Room.NO_DOORS);
    }
    public static void main(String[] aArguments)
    {
        setupRooms();

        Scanner objInput = new Scanner(System.in);

        System.out.println("Welcome to Java Adventure Game.");
        System.out.println("To end game, type 'end game' at any point of time.");
        System.out.println("To travel, type the direction, example> north");
        System.out.println("======================================");
        
        while(!sCommand.equalsIgnoreCase("end game"))
        {
            System.out.println(aRooms[iCurrentRoom].getRoomDesc());
            System.out.println(aRooms[iCurrentRoom].getRoomActions());
            System.out.println(">>> Type your action.");
            sCommand = objInput.nextLine();
            boolean bValidAction = false;

            while(!bValidAction)
            {
                if(sCommand.equalsIgnoreCase("walk north"))
                {
                    iCurrentRoom = aRooms[iCurrentRoom].getNextRoom(Room.NORTH);
                    bValidAction = true;
                }
                else if(sCommand.equalsIgnoreCase("walk east"))
                {
                    iCurrentRoom = aRooms[iCurrentRoom].getNextRoom(Room.EAST);
                    bValidAction = true;
                }
                else if(sCommand.equalsIgnoreCase("walk south"))
                {
                    iCurrentRoom = aRooms[iCurrentRoom].getNextRoom(Room.SOUTH);
                    bValidAction = true;
                }
                else if(sCommand.equalsIgnoreCase("walk west"))
                {
                    iCurrentRoom = aRooms[iCurrentRoom].getNextRoom(Room.WEST);
                    bValidAction = true;
                }
                else
                {
                    System.out.println("Invalid action. Please try again.");
                    System.out.println(">>> Type your action.");
                    sCommand = objInput.nextLine();
                }
            }
            
        }
        System.out.println("======================================");
        System.out.println("Thank you for playing. Ending game");
    }
}
