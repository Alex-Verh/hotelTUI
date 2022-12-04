package ss.hotel;

public class Guest {


    private final String name;
    //@private invariant name == null;

    private Room roomnumber;
    //@private invariant roomnumber == null;



    /**
     * Creates a new Guest with no room assigned
     */

    //@requires name != null;
    //@ensures this.name == name;
    public Guest(String name) {
        this.name = name;
    }

    /**
     * Returns the name of this Guest
     */

    //@ensures \result == name;
    public String getName() {
        return this.name;
    }


    /**
     * Returns the number of the room assigned to the Guest
     * @return the number of this Room, null if not rented
     */

    //@ensures \result != null;
    public Room getRoom() {
        return roomnumber;
    }

    /**
     * Assigns a free Room to a new Guest
     */

    //@requires room != null;
    //@ensures \result == true || \result == false;
    public boolean checkin(Room room) {
        if (room.getGuest() == null) {
            roomnumber = room;
            //SPECIAL ERROR (org.opentest4j.AssertionFailedError: Actual == null )
            room.setGuest(this);
            //until here
            return true;
        } else {
            return false;
        }
    }
    /**
     * Liberates a Room assigned to the Guest
     */

    //@ensures roomnumber == null;
    public boolean checkout() {
        if (roomnumber != null) {
            roomnumber.setGuest(null);
            roomnumber = null;
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return ("Guest " + name);
    }

}
