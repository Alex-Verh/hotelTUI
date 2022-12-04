package ss.hotel;

public class Hotel {
    private String name;
    protected Room[] rooms;
    private Guest guest;

    //@private invariant name == null;
    //@protected invariant rooms == null;
    //@private invariant guest == null;


    //@requires name != null;
    //@ensures this.name == name && (\forall int i; 0 <= i && i < 2; rooms[i] != null);
    public Hotel(String name) {
        this.name = name;
        rooms = new Room[2];
        rooms[0] = new Room(1);
        rooms[1] = new Room(2);
    }

    //@requires name == null;
    //@ensures \result == null || \result != null;
    public Room checkIn(String name) {
        Room freeRoom = getFreeRoom();
        if (getRoom(name) == null) {
            if (freeRoom != null) {
                guest = new Guest(name);
                guest.checkin(freeRoom);
                freeRoom.setGuest(guest);
                return freeRoom;
            }
        }
        return null;
    }

    //@requires name != null;
    public void checkOut(String name) {
        Room room = getRoom(name);
        if (room != null) {
            guest = room.getGuest();
            guest.checkout();
            room.getSafe().deactivate();
        }
    }

    //@pure;
    public Room getFreeRoom() {
        for (Room room : rooms) {
            if (room.getGuest() == null) {
                return room;
            }
        }
        return null;
    }


    //@requires name != null && (\forall int i; 0 <= i && i < 2; rooms[i] != null);
    //@pure ;
    public Room getRoom(String name) {
        for (Room room : rooms) {
            if (room.getGuest() != null && room.getGuest().getName().equals(name)) {
                return room;
            }
        }
        return null;
    }

    //@pure;
    public String getName() {
        return name;
    }


    //@pure;
    public String toString() {
        String result = "Hotel " + name + "\n";
        for (Room room : rooms) {
            result = result + room + "\n";
            result = result + room.getGuest() + "\n";
            result = result + "is safe activated:" + room.getSafe().isActive() + "\n\n";
        }
        return result;
    }

}
