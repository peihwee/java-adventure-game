/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author Siah Peih Wee
 */
public class Room 
{
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;
    
    public static final int NO_DOORS = -1;
    
    private String sDescription;
    private int[] aDoors = {NO_DOORS, NO_DOORS, NO_DOORS, NO_DOORS};
    
    public Room(String sDescription, int iNorthRoom, int iEastRoom, int iSouthRoom, int iWestRoom)
    {
        this.sDescription = sDescription;
        
        aDoors[NORTH] = iNorthRoom;
        aDoors[EAST] = iEastRoom;
        aDoors[SOUTH] = iSouthRoom;
        aDoors[WEST] = iWestRoom;
    }
    
    public int getNextRoom(int iDirection)
    {
        return aDoors[iDirection];
    }

    public String getRoomDesc()
    {
        return sDescription;
    }

    public String getRoomActions()
    {
        String sActions = "You can do the following actions.\n";
        int iActionID = 1;
        for(int i=0; i<aDoors.length; i++)
        {
            if(aDoors[i] != NO_DOORS)
            {
                String sDirection = "";
                switch(i)
                {
                    case NORTH:
                        sDirection = "North\n";
                        break;

                    case SOUTH:
                        sDirection = "South\n";
                        break;

                    case EAST:
                        sDirection = "East\n";
                        break;

                    case WEST:
                        sDirection = "West\n";
                        break;
                }
                sActions += iActionID + ".  Walk " + sDirection; 
                iActionID++;
            }
        }
        sActions += "--------------------";
        return sActions;
    }
}
