package ss.hotel.bill;

public interface BillPrinter {
    /**
     * Returns a formatted line listing the item and price, ending on a newline
     * @param text beautiful text
     * @param price beautiful price
     * @return \return formatted list
     */
    default String format(String text, double price) {
        return String.format("%-20s %10.2f", text, price) + "\n";
    }


    /**
     * Uses format to send the combination of text and price to the printer
     * in a way that is specific to the implementation
     * @param text texttext
     * @param price priceprice
     */
    void printLine(String text, double price);
}
