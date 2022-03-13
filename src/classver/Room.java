package classver;

public class Room {
    Person customerNumber;
    int roomNumber;
//Setting Customer
    public void setCustomer(Person CustomerN) {
        this.customerNumber = CustomerN;
    }
//Getting Customer
    public Person getCustomer() {
        return this.customerNumber;
    }

    public void setRoom(int RoomN) {
        this.roomNumber = RoomN;
    }

    public int getRoom() {
        return this.roomNumber;

    }
}
