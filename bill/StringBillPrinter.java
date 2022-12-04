package ss.hotel.bill;

public class StringBillPrinter implements BillPrinter {
    private String result;


    /**
     * get everything in 1 parameter, so we can call it wit getResult()
     * @param text the name of the product
     * @param price the price
     */
    @Override
    public void printLine(String text, double price) {
        result = result + format(text, price);
    }


    /**
     * gets the result from the private result
     * @return result
     */
    public String getResult() {
        return result;
    }
}
