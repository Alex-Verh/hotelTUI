package ss.hotel.bill;

import org.junit.jupiter.api.*;
import ss.hotel.bill.Bill;
import ss.hotel.bill.StringBillPrinter;

public class BillTest {

    private Bill bill;

    private StringBillPrinter printer;

    private class Item implements Bill.Item {
        private String text;
        private double price;

        public Item(String text, double price) {
            this.text = text;
            this.price = price;
        }

        @Override
        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return text;
        }
    }


    /**
     * Set up new printer and new bill before each test.
     */
    @BeforeEach
    public void setUp() {
        printer = new StringBillPrinter();
        bill = new Bill(printer);
    }

    /**
     * Tests if the total is 0 by default.
     */
    @Test
    public void testBeginState() {
        Assertions.assertTrue(printer.getResult().isEmpty());
        Assertions.assertEquals(0.0, bill.getSum());
    }

    /**
     * Tests if the total of two new item is correct.
     * Checks if each of the price is truly correct for every item.
     */
    @Test
    public void testNewItem() {
        bill.addItem(new Item("test", 1.0));
        bill.addItem(new Item("test", 3.0));

        Assertions.assertEquals(4.0, bill.getSum());
        Assertions.assertTrue(printer.getResult().contains("1.00"));
        Assertions.assertTrue(printer.getResult().contains("3.00"));
        Assertions.assertFalse(printer.getResult().contains("4.00"));
    }


    /**
     * Test if closing the bill resets the total sum and sets it to 0.
     * Checks if result is void.
     */
    @Test
    public void closeTest() {
        bill.addItem(new Item("test", 1.0));
        bill.addItem(new Item("test", 3.0));
        double total = bill.getSum();
        bill.close();

        Assertions.assertEquals(0.0, bill.getSum());
        Assertions.assertTrue(printer.getResult().contains(total + ""));
    }




}
