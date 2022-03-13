package classver;

import classver.Person;
import classver.Room;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Hotel {

    static Room[] room = new Room[9];//creating the room array object
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args){


        String Customer = null; //set customer as null
        String menu = null;
        int roomNumber = 1;

        initialise();

        while(roomNumber<9) {

            System.out.println("\n");
            System.out.println("=====================================");
            System.out.println("       Welcome to Nipthanna Hotel    ");
            System.out.println("=====================================");
            System.out.println();
            System.out.println("A: Add customer to a room");
            System.out.println("V: View all rooms");
            System.out.println("E: Display empty rooms");
            System.out.println("D: Delete customer from room");
            System.out.println("F: Find room from customer name");
            System.out.println("S: Store program data into file");
            System.out.println("L: Load program data from file");
            System.out.println("O: View guests Ordered alphabetically by name");
            System.out.println("X: Exit the program");
            System.out.println();
            System.out.print("Enter your Choice : ");

            Scanner input = new Scanner(System.in);

            menu = input.nextLine().toUpperCase();
            System.out.println();

            switch (menu) {
                case "V": {
                    view(roomNumber);
                    break;
                }
                case "A": {
                    addCustomer(room);
                    break;
                }
                case "E": {
                    emptyRooms(room,Customer,roomNumber);
                    break;
                }
                case "D": {
                    delete(room,roomNumber,input);
                    break;
                }
                case "F": {
                    find(room,input,Customer);
                    break;
                }
                case "S": {
                    saveFile(room);
                    break;
                }
                case "L": {
                    loadFile(room);
                    break;
                }
                case "O": {
//                    alpherbetI(room);

//                    for(int x=1; x<9;x++){
//                        Arrays.sort(room,NewComparator);
//                        if(!(room[x].getCustomer().equals(null)))
//                        {
//                            System.out.println(room[x].getCustomer());
//                        }
//                    }
                    break;
                }
                case "X": {
                    System.out.println("Thank you for using this Program...");
                    System.exit(0);
                    break;
                }
                default: {
                    break;
                }
            }
        }

    }

    private static void initialise(){
        for (int i = 1; i < room.length; i++) {
            room[i] = new Room();
            room[i].setRoom(i);
        }
    }
//Add New Customer to Hotel Room
    private static void addCustomer(Room roomFInd[]){
        System.out.println("Enter room number (1-8) or X to exit the program:");
        int roomNo = input.nextInt();
        if(roomNo <9 && roomNo >= 1){

            System.out.println("Enter your first Name for room Number "+roomNo+" :");
            String firstName = input.next().toUpperCase();

            System.out.println("Enter your last Name for room Number "+roomNo+" :");
            String lastName = input.next().toUpperCase();

            System.out.println("Enter your Credit Card Number: ");
            int creditCardNum = input.nextInt();

            System.out.println("Enter your number of Guests in the room: ");
            int numberOfGuest = input.nextInt();

            Person person = new Person(firstName,lastName,creditCardNum, numberOfGuest);

            if (roomFInd[roomNo].getCustomer() == null) {
                roomFInd[roomNo].setCustomer(person);

                System.out.println("Added Customer " + person.toString() + " to Room number " + roomNo);

            }else{
                System.out.println("Invalid... Please enter a valid name.");
            }
        }else{
            System.out.println("Invalid... Enter a valid Room Number between 0 to 9");
        }
    }
//View All Rooms in Hotel
    public static void view(int roomNo){
        for(int i=1; i< room.length;i++){
            if(room[i].getRoom()!=0){
                System.out.println("Room " + room[i].getRoom() + " occupied by " + room[i].getCustomer());
            }else{
                System.out.println("Room " + room[i].getRoom() + " is EMPTY");
            }
        }
    }

//Delete Customer from Hotel Room
    public static void delete(Room findRoom[], int roomNo,Scanner input){
        System.out.println("Enter the room number to delete customer :");
        roomNo = input.nextInt();
        for(int i=1; i<findRoom.length;i++){
            if(findRoom[i].getRoom() == roomNo){
                Person person = null;
                findRoom[roomNo].setCustomer(person);
                System.out.println("Room number "+roomNo+ " customer deleted.");
            }
        }
    }

//View Only Empty Rooms
    public static void emptyRooms(Room roomFind[], String Customer, int roomNo){
        for(int i=1;i<9;i++){
            if (roomFind[i].getRoom() == i){
                System.out.println("Room " + i + " is EMPTY");
            }

        }
    }

//Find Customer Room Using Name
    public static void find(Room roomFind[],Scanner input,String Customer){
        System.out.println("Enter the name of the Customer :");
        Customer = input.next();
        for(int i=1;i<roomFind.length;i++){
            if(roomFind[i].getCustomer()!=null){
                System.out.println("Customer "+Customer+" room is "+roomFind[i].getRoom());
            }

        }
    }

//Save Room Details to Text File
    public static void saveFile(Room roomFind[]){
        System.out.print("Store program array data Records into a plain text file");
        System.out.println();
        try {
            // getting the Hotel text file
            File hotelfile = new File("HotelSystemDetails.txt");
            PrintWriter printWriter = new PrintWriter(hotelfile);
            // printing the all array element text file
            for (int j = 1; j < roomFind.length; j++) {
                if (roomFind[j].getCustomer() != null) {
                    // printing the a array element text file
                    printWriter.println(roomFind[j].getCustomer());
                } else {
                    printWriter.println(roomFind[j].getCustomer());
                }
            }
            System.out.println("Added Successfully...");
            printWriter.close();
        }
        catch (IOException e) {
            System.out.println("Check your file.");
        }
    }

//Load Room Details
    public static void loadFile(Room roomFind[]){
        System.out.print("Load program data Records back from the file into the array.");
        System.out.println();

        File hotelfile = new File("HotelSystemDetails.txt");
        BufferedReader buffReader = null;
        FileReader fileReader = null;

        try{
            fileReader = new FileReader(hotelfile);
            buffReader = new BufferedReader(fileReader);

            String sCurrentLine;

            buffReader = new BufferedReader(new FileReader(hotelfile));

            while ((sCurrentLine = buffReader.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        }catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (buffReader != null)
                    buffReader.close();

                if (fileReader != null)
                    fileReader.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
        System.out.println();
        System.out.println("Successfully Loaded...");

    }

}