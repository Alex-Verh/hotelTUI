package ss.hotel.bill;

public class SysoutBillPrinter implements BillPrinter {



    public static void main(String[] args) {
        BillPrinter printer = new SysoutBillPrinter();
        printer.printLine("example1", 100);
        printer.printLine("example2", 200);
    }


    /**
     * print the line in the right format
     * @param text the name of the product
     * @param price the price
     */
    @Override
    public void printLine(String text, double price) {
        System.out.println(format(text, price));
    }


}
