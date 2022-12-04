package ss.hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.hotel.PricedSafe;
import ss.hotel.bill.Bill;

public class PricedSafeTest {

    private PricedSafe safe;
    private static final double PRICE = 6.36;
    private static final String PRICE_PATTERN = ".*6[.,]36.*";

    public String CORRECT_PASSWORD;
    public String WRONG_PASSWORD;


    @BeforeEach
    public void setUp() throws Exception {
        safe = new PricedSafe(PRICE);
        CORRECT_PASSWORD = safe.getPassword().getInitPass();
        WRONG_PASSWORD = CORRECT_PASSWORD + "WRONG";
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    public void testIsBillItem() throws Exception {
    	assertTrue(safe instanceof Bill.Item,
    			"safe should be an instance of Bill.Item.");
        assertEquals(PRICE, safe.getPrice(), 0,
        		"GetPrice should return the price of the safe.");
    }

    @Test
    public void testGetPrice() {
        assertEquals(safe.getPrice(), PRICE);
    }

    @Test
    public void testToString() {
        assertEquals("PricedSafe{" + "price=" + PRICE + "}", safe.toString());
    }

    @Test
    public void testDeactivatedToActivate() {
        safe.activate(CORRECT_PASSWORD);
        assertTrue(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    public void testDeactivatedNotToActivate() {
        safe.activate(WRONG_PASSWORD);
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    public void testClosedToOpen() {
        safe.open(CORRECT_PASSWORD);
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    public void testClosedNotToOpen() {
        safe.open(WRONG_PASSWORD);
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    public void isOpenedThenActivated() {
        safe.activate(CORRECT_PASSWORD);
        safe.open(WRONG_PASSWORD);
        assertTrue(safe.isActive());
        assertFalse(safe.isOpen());
        safe.open(CORRECT_PASSWORD);
        assertTrue(safe.isOpen());
    }

    @Test
    public void isClosedAndActivated() {
        safe.activate(CORRECT_PASSWORD);
        safe.open(CORRECT_PASSWORD);
        safe.close();
        assertTrue(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    public void isClosedAndDeactivated() {
        safe.deactivate();
        safe.close();
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

}
