package classver;

public class Person extends Hotel{
    String fName;
    String lName;
    int creditCardNumber;
    int numberOfGuest;

    //Declaring Constructor
    @Override
    public String toString() {
        String personDetails = "Name : "+ fName +" "+ lName +" | Credit Card Number: "+ creditCardNumber + " | Number of Guest in the room: "+numberOfGuest;
        return  personDetails;
    }

    public Person(String firstName, String lastName, int creditCardNum, int numberOfGuest) {
        this.fName = firstName;
        this.lName = lastName;
        this.creditCardNumber = creditCardNum;
        this.numberOfGuest = numberOfGuest;
    }

    public void setFirstName(String firstName) {
        this.fName = firstName;
    }
    public String getFirstName() {
        return fName;
    }


    public void setLastName(String lastName) {
        this.lName = lastName;
    }
    public String getLastName() {
        return lName;
    }


    public void setCreditCardNum(int creditCardNum) { this.creditCardNumber = creditCardNum;}
    public int getCreditCardNum() { return creditCardNumber;}

    public void setnumberOfGuest(int numberOfGuest) {this.numberOfGuest = numberOfGuest;}
    public  int getnumberOfGuest(){return numberOfGuest;}
}