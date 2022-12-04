package ss.hotel;

import java.util.Scanner;

public class HotelTUI {


    static final String IN = "in";
    static final String OUT = "out";
    static final String ROOM = "room";
    static final String ACTIVATE = "activate";
    static final String HELP = "help";
    static final String PRINT = "print";
    static final String EXIT = "exit";


    private Hotel hotel;
    static Scanner input = new Scanner(System.in);
    public static void message() {
        System.out.println();
        System.out.println(
                "in name ................. check in guest with name\n" +
                "out name ................ check out guest with name\n" +
                "room name ............... request room of guest with name\n" +
                "activate name ........... activate safe of guest with name\n" +
                "help .................... help (this menu)\n" +
                "print ................... print state\n" +
                "exit .................... exit\n");
        System.out.println();
    }

    public static void run() {
        Hotel hotel = new Hotel("UTwente");
        boolean exit = false;
        while (!exit) {
            String inputs = input.nextLine();
            String[] split = inputs.split("\\s+");

            try {
                switch (split[0].toLowerCase()) {
                    case "in":
                        Room x = hotel.checkIn(split[1]);
                        if (x != null) {
                            System.out.println("Success " + x);
                        } else {
                            System.out.println("Go find another hotel ");
                        }
                        break;
                    case "out":
                        if (hotel.getRoom(split[1]) != null) {
                            hotel.checkOut(split[1]);
                            System.out.println("Successfully checked-out");
                        } else {
                            System.out.println("Guest not found");
                        }
                        break;
                    case "room":
                        System.out.println(hotel.getRoom(split[1]));
                        break;
                    case "activate":
                        hotel.getRoom(split[1]).getSafe().activate();
                        if (hotel.getRoom(split[1]).getSafe().isActive()) {
                            System.out.println("Activated safe: " + hotel.getRoom(split[1]).getSafe());
                        } else {
                            System.out.println("The safe has not been activated");
                        }
                        break;
                    case "help":
                        message();
                        break;
                    case "print":
                        System.out.println(hotel);
                        break;
                    case "exit":
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid input");
                        message();
                        break;
                }
            } catch (Exception e) {
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
