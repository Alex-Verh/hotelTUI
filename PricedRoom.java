package ss.hotel;

import ss.hotel.bill.Bill;

public class PricedRoom extends Room implements Bill.Item {

    private double price;
    private double safePrice;

    @Override
    public double getPrice() {
        return price;
    }

    PricedRoom(int number, double price, Safe safe) {
        super(number, safe);
        this.price = price;
    }

    PricedRoom(int number, double price, double safeprice) {
        this(number, price, new PricedSafe(safeprice));
        this.safePrice = safeprice;
    }

    @Override
    public String toString() {
        return super.toString() + " " + price + " " + safePrice + " Euro";
    }
}
