package ss.hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoomTest {
    private Guest guest;
    private Room room;
    
    @BeforeEach
    public void setUp() {
        guest = new Guest("Jip");
        room = new Room(101);
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room.getNumber());
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals(guest, room.getGuest());
    }

    @Test
    public void testSafe() {
        Safe safe = room.getSafe();
        assertEquals(safe, room.getSafe());
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }
    
}
