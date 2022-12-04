package ss.hotel;

import ss.hotel.bill.Bill;
import ss.hotel.bill.BillPrinter;
import ss.hotel.bill.StringBillPrinter;

public class PricedHotel extends Hotel implements Bill.Item {
    @Override
    public double getPrice() {
        return ROOM_PRICE;
    }
    public static final double SAFE_PRICE = 10;
    public static final int ROOM_PRICE = 100;

    public PricedHotel(String name) {
        super(name);
        rooms[0] = new PricedRoom(1, ROOM_PRICE, SAFE_PRICE);
    }


    //@requires guestName1 != null && numberOfNights != 0 && printer != null;
    //@ensures \result == null || \result != null;
    public Bill getBill(String guestName1, int numberOfNights, BillPrinter printer) {

        Room room = getRoom(guestName1);


        if (room.getGuest() != null && room instanceof PricedRoom) {
            Bill bill = new Bill(printer);
            PricedRoom roomp = (PricedRoom) getRoom(guestName1);
            PricedSafe safe = (PricedSafe) roomp.getSafe();
            for (int i = 0; i < numberOfNights; i++) {
                bill.addItem(roomp);
            }

            if (safe.isActive()) {
                bill.addItem(safe);
            }
            printer.printLine("Result", bill.getSum());


            return bill;
        }
        return null;
    }

}
