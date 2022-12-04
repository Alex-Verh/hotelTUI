package ss.hotel;

public class Room {
    private int number;
    private Guest guest;

    private Safe safe;
    /**
     * Creates a <code>Room</code> with the given number, without a guest.
     * @param no number of the new <code>Room</code>
     * @param safe new safe assigned to the new Room
     */

    public Room(int number, Safe safe) {
        this.safe = safe;
        this.number = number;
    }

    /**
     * assigns a new Safe to the new Room
     * @param number that assigns new number to the new Room
     */

    public Room(int number) {
        this(number, new Safe());
    }



    /**
     * Returns the number of this Room
     */
    public int getNumber() {
    	return number;
    }

    /**
     * Returns the current guest living in this Room
     * @return the guest of this Room, null if not rented
     */
    public Guest getGuest() {
    	return guest;
    }
    
    
    /**
     * Assigns a Guest to this Room.
     * @param guest the new guest renting this Room, if null is given, Room is empty afterwards
     */
    public void setGuest(Guest guest) {
    	this.guest = guest;
    }

    public String toString() {
        return ("Room " + number);
    }

    public Safe getSafe() {
        return safe;
    }
}
