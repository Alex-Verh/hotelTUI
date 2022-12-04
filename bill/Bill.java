package ss.hotel.bill;

public class Bill {

    /**
     * Interface Item (nested interface);
     */
    public interface Item {
        double getPrice();
    }


    private final BillPrinter billPrinter;
    private double total;

    /**
     * Constructs a Bill sending the output to a given Printer.
     * @param billPrinter the printer send to the bill
     */
    public Bill(BillPrinter billPrinter) {
        this.billPrinter = billPrinter;
    }


    /**
     * Adds a new item with description and price.
     * @param item - new item
     */
    public void addItem(Bill.Item item) {
        billPrinter.printLine(item.toString(), item.getPrice());
        total += item.getPrice();
    }

    /**
     * Returns the sum of all items in the bill.
     * @return total sum of the items
     */
    public double getSum() {
        return total;
    }

    /**
     * Closes the bill and prints the total, resetting it to 0.
     */
    public void close() {
        billPrinter.printLine("Total:", total);
        total = 0.0;
    }



}
