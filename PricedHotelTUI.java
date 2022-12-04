package ss.hotel;

import ss.hotel.bill.SysoutBillPrinter;

import java.util.Scanner;



public class PricedHotelTUI {


    private static final String IN = "in";
    private static final String OUT = "out";
    private static final String ROOM = "room";
    private static final String ACTIVATE = "activate";
    private static final String HELP = "help";
    private static final String PRINT = "print";
    private static final String BILL = "bill";
    private static final String EXIT = "exit";


    private Hotel hotel;
    static Scanner input = new Scanner(System.in);
    public static void message() {
        System.out.println();
        System.out.println(
                "in name ................. check in guest with name\n" +
                        "out name ................ check out guest with name\n" +
                        "room name ............... request room of guest with name\n" +
                        "activate name ........... activate safe of guest with name\n" +
                        "bill name nights ........ activate safe, password required for PricedSafe\n" +
                        "help .................... help (this menu)\n" +
                        "print ................... print state\n" +
                        "exit .................... exit\n");
        System.out.println();
    }



    public static void run() {
        PricedHotel hotel = new PricedHotel("UTwente");
        boolean exit = false;

        while (!exit) {
            String inputs = input.nextLine();
            String[] split = inputs.split("\\s+");

            try {
                switch (split[0].toLowerCase()) {
                    case IN:
                        Room x = hotel.checkIn(split[1]);
                        if (x != null) {
                            System.out.println("Success " + x);
                        } else {
                            System.out.println("Go find another hotel");
                        }

                        break;
                    case OUT:
                        if (hotel.getRoom(split[1]) != null) {
                            hotel.checkOut(split[1]);
                            System.out.println("Successfully checked-out");
                        } else {
                            System.out.println("Guest not in hotel");
                        }
                        break;
                    case ROOM:
                        System.out.println(hotel.getRoom(split[1]));
                        break;
                    case ACTIVATE:
                        Room room = hotel.getRoom(split[1]);
                        Safe safe = room.getSafe();

                        if (safe instanceof PricedSafe) {
                            PricedSafe pricedSafe = (PricedSafe) safe;
                            pricedSafe.activate(split[2]);
                        } else {
                            safe.activate();
                        }

                        if (hotel.getRoom(split[1]).getSafe().isActive()) {
                            System.out.println("Activated safe: " + hotel.getRoom(split[1]).getSafe());
                        } else {
                            System.out.println("The safe is not activated.");
                        }
                        break;
                    case HELP:
                        message();
                        break;
                    case BILL:
                        SysoutBillPrinter printer = new SysoutBillPrinter();
                        System.out.println(hotel.getBill(split[1], Integer.parseInt(split[2]), printer));
                        break;
                    case PRINT:
                        System.out.println(hotel);
                        break;
                    case EXIT:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid input");
                        message();
                        break;
                }
            } catch(Exception e) {
                System.out.println("Invalid input");
                message();
            }
        }
    }


    public static void main(String[] args) {
        message();
        run();
    }
}
