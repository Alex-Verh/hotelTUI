package ss.hotel;

import ss.hotel.bill.Bill;
import ss.hotel.bill.StringBillPrinter;
import ss.hotel.password.Password;
import ss.hotel.password.StrongChecker;

public class PricedSafe extends Safe implements Bill.Item {


    public static void main(String[] args) {
        PricedSafe violate = new PricedSafe(-5);
    }

    private final Password password;
    private final double price;
    //@ private invariant password != null;


    //@requires price != 0;
    public PricedSafe(double price) {
        super();
        assert price >= 0;
        this.password = new Password(new StrongChecker());
        this.price = price;
    }

    //@requires password != null;
    //@ensures isActive() == true || isActive() == false;
    public void activate(String password) {
        assert password != null;
        if (this.password.testWord(password)) {
            super.activate();
        }
    }

    //@ensures isActive() == false;
    @Override
    public void activate() {
        assert false;
        System.out.println("Warning: You can't activate the safe without a password.");
    }

    //@ensures isActive() == false;
    @Override
    public void deactivate() {
        super.deactivate();
    }

    //@requires password != null;
    //@ensures isOpen() == true || isOpen() == false;
    public void open(String password) {
        assert password != null;
        if (this.password.testWord(password)) {
            super.open();
        }
    }

    //@ensures isOpen() == false;
    @Override
    public void open() {
        assert false;
        System.out.println("Warning: You can't open the safe without a password.");
    }

    //@ensures isOpen() == false;
    @Override
    public void close() {
        super.close();
    }

    //@pure;
    public Password getPassword() {
        return password;
    }

    //@pure;
    @Override
    public String toString() {
        return "PricedSafe{" + "price=" + price + "}";
    }

    //@pure;
    public double getPrice() {
        return price;
    }
}
