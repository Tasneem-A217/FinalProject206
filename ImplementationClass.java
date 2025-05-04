

import javax.swing.JOptionPane;

public class ImplementationClass {

    // Main Arrays
    public static Room[] Rooms = new Room[100];
    public static Employee[] allEmployees = new Employee[100];
    public static Reservation[] allReservations = new Reservation[10];
    public static Guest[] allGuests = new Guest[10];

public static void main(String[] args) {
    // Create default rooms
    new OneBed(1, "One Bed", 100.0, "Twin");
    new TwoBed(2, "Two Bed", 250.0, new String[] {"Twin", "Queen"});
    new OneBed(6, "One Bed", 130.0, "Queen");
    
    Hotel aHotel = new Hotel(1001, "JAVA INN", "1(800)-111-1111", 
    "JavaHouse@java.net", "03:00PM", "11:00AM");

        //Boolean flag = true; // Set to false to break the loop.
    String welcomeText = 
          "Welcome to " + aHotel.getHotelName() + "! Enjoy our Services!!!\n\n"
        + "Hotel ID: "   + aHotel.getHotelID()     + "\n"
        + "Phone: "      + aHotel.getPhoneNumber() + "\n"
        + "Email: "      + aHotel.getEmailAddress()+ "\n"
        + "Check-In: "   + aHotel.getCheckInTime() + "\n"
        + "Check-Out: "  + aHotel.getCheckOutTime();
            
        JOptionPane.showMessageDialog( null, welcomeText);
        
        String menu = ("**MAIN MENU**\nWhat would you like to do?\n\n1. Room Menu\n2. Employee Menu\n3. Reservation Menu\n4. Guest Menu\n5. Exit");
            
        do {
            int option=0;
            try{
            option = Integer.parseInt(JOptionPane.showInputDialog(menu));
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Please enter right menu option");
            }

            switch (option) {
                case 1:
                    showRoomOptions();
                    break;
                case 2:
                    showEmployeeOptions();
                    break;
                case 3:
                showReservationMenu();
                case 4:
                showGuestMenu();
                break;
                case 5:
                System.exit(0);
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Option. Must be 1-5. Try Again.");
            }
        } while (true);
    }


    //Hotel info Adonays
    
    // Adonays Employee Section
    public static void showEmployeeOptions() {
        String menu = "**EMPLOYEE MENU**\nWhat would you like to do?\n\n1. Add employee\n2. Display Employees\n3. Search For Employee\n4. Remove Employee\n5. Back to main\n6. Exit Program";
        int input = -1;
        do {
            input = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (input) {
                case 1:
                    allEmployees[Employee.getNumOfEmployee()] = addEmployee();
                    break;
                case 2:
                    displayEmployee(allEmployees);
                    break;
                case 3:
                    String employeeID = JOptionPane.showInputDialog("Enter Employee ID to search? ");
                       JOptionPane.showMessageDialog(null, "**Found Employee**\n" 
                       + allEmployees[findEmployee(allEmployees, Integer.parseInt(employeeID))].toString());
                    break;
                case 4:
                FireEmployee(allEmployees);
                    break;
                case 5:
                    main(new String[0]);
                    break;
                case 6: 
                System.exit(0);
                    break;
                default:
                JOptionPane.showMessageDialog(null, "Invalid Option. Must be 1-6. Try Again.");
                    break;
            }
        } while (input > 0 && input < 6);
        displayEmployee(allEmployees);
    };


    public static Employee addEmployee( ) {
        Employee aEmployee = new Employee(0, null, null, 
        null, null, 0, null);

        try{
        int employeeID = Integer.parseInt(JOptionPane.showInputDialog("What is that Employee ID?"));
        aEmployee.setEmployeeID(employeeID);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error! Employee ID must be a number");
        }catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try{
        String name = JOptionPane.showInputDialog("What is the Employee Name?");
        aEmployee.setName(name);
        }catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try{
        String email = JOptionPane.showInputDialog("What is Employee Email?");
        aEmployee.setEmail(email);
        }catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try{
        String hireDate = JOptionPane.showInputDialog("What is Employee Hired date?");
        aEmployee.setHireDate(hireDate);
        }catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        String title = "";
        double salary = 0;
        String jobDuty = "";
        try{
        title = JOptionPane.showInputDialog("What is jobs title?");
        }catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try{
         salary = Double.parseDouble(JOptionPane.showInputDialog("What is the Job Salary?"));
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error! Job Salary must be a number");
        }catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try{
        jobDuty = JOptionPane.showInputDialog("What is jobs duty?");
        }catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        Job aJob = new Job(title, salary, jobDuty);
        aEmployee.setJob(aJob);
        
        
        return aEmployee;

    }

    public static int findEmployee(Employee[] allEmployees, int employeeID) {
        int searchIndex = -1;
        for (int i = 0; i < Employee.getNumOfEmployee(); i++) {
            if (allEmployees[i].getEmployeeID() == employeeID) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }

    public static void displayEmployee(Employee[] allEmployees) {
        String output = "";
        for (int i = 0; i < Employee.getNumOfEmployee(); i++) {
            output += allEmployees[i].toString() + "\n";

        }
        JOptionPane.showMessageDialog(null, output);
    }

    public static void FireEmployee(Employee[] allEmployees) {
        displayEmployee(allEmployees);
        int employeeToRemove = Integer.parseInt(JOptionPane.showInputDialog("Enter the Employee ID to delate"));
        int index = findEmployee(allEmployees,employeeToRemove);
        for (int i = index; i < Employee.getNumOfEmployee(); i++) {
            allEmployees[i] = allEmployees[i + 1];
        }
        allEmployees[Employee.getNumOfEmployee()] = null;
        Employee.updateNumOfEmployee();
    }//end of Adonays Employee part


    //Tasneems work 

    public static void showReservationMenu (){
        String menu = "1. Add Reservation\n2. Remove Reservation\n3. Search Reservation\n4. Display Reservation\n5. Return to Main Menu\n6.Exit";
        int choice = 0;
        do{
            try{
                choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Please enter right menu option");
                }
            choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(choice){
                case 1:
                    allGuests[Guest.getOccupancy()] = createGuest();
                    allReservations[Reservation.getnumOfReservation()] = createReservation();
                    break;
                case 2:
                    removeReservation(allReservations);
                    break; 
                case 3:
                    String searchKey = JOptionPane.showInputDialog("Enter the Reservation ID you are searching for");
                    int found = searchReservation(allReservations, searchKey);
                    if(found >-1)
                        JOptionPane.showMessageDialog(null, "The reservation was found:" + allReservations[found].toString()); 
                    else 
                        JOptionPane.showMessageDialog(null, "Reservation not found");
                break;    
                case 4:
                   printReservation(allReservations);
                    break;
                case 5:
                    main(new String[0]);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Choice! Must be between 1-6");
            }//end of switch 
    
        }while(choice != 6);
    }// end of method 

public static Reservation createReservation(){
//Reservation reservation = new Reservation();
Reservation reservation = new Reservation();
int roomNum=Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the room number"));
Room room=searchRoom(roomNum);
reservation.setroom(room);


try{
    String reservationID = JOptionPane.showInputDialog("Please enter the reservation ID");
    reservation.setreservationID(reservationID);
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}

try{
    String arrivalDate = JOptionPane.showInputDialog("Please enter the date of arrival");
    reservation.setarrivalDate(arrivalDate);
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}

try{
    String departDate = JOptionPane.showInputDialog("Please enter the date of departure");
    reservation.setdepartureDate(departDate);
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}
try{
    int numOfNights = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount of nights you will stay"));
    reservation.setnumOfNights(numOfNights);
}catch(NumberFormatException ex){
    JOptionPane.showMessageDialog(null, "Error! Please enter a valid number of nights");
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}

return reservation; 
}// end of create a reservation 

//search reservation 
public static int searchReservation(Reservation[] allReservations, String reservationID){
int searchIndex = -1;
for(int i=0; i<Reservation.getnumOfReservation();i++){
    if((allReservations[i].getreservationID()).equalsIgnoreCase(reservationID)){
        searchIndex = i;
        break;
    }
}
return searchIndex;
}

//remove reservation 
public static void removeReservation(Reservation[] allReservations) {
printReservation(allReservations);
String removeReservation = JOptionPane.showInputDialog("Enter the reservation you would like to remove");
int index = searchReservation(allReservations, removeReservation);
if (index > -1) {
    for (int i = index; i < Reservation.getnumOfReservation(); i++) {
        allReservations[i] = allReservations[i + 1];
    }
    allReservations[Reservation.getnumOfReservation()] = null;
    Reservation.updatenumOfReservation();
    } else {
 JOptionPane.showMessageDialog(null, "Error! Reservation was not found");
}
}

//display reservation 
public static void printReservation(Reservation[] allReservations){
String output = "" ;
for(int i=0; i<Reservation.getnumOfReservation(); i++){
    output += allReservations[i].toString() + "\n";
}
JOptionPane.showMessageDialog(null, output);
}


// Method for Guests 
public static void showGuestMenu (){
String menu = "1. Add Guest\n2. Remove Guest\n3. Display Guest\n4. Return to Main Menu\n5. Exit";
int choice = 0;

do{
    try{
        choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Please enter right menu option");
        }
    choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
    switch(choice){
        case 1:
            allGuests[Guest.getOccupancy()] = createGuest();
            break;
        case 2:
            removeGuest(allGuests);
            break; 
        case 3:
            printGuest(allGuests);
        case 4:
            main(new String[0]);
            break;
        case 5:
            System.exit(0);
            break;
        default:
            JOptionPane.showMessageDialog(null, "Invalid Choice! Must be between 1-5");
    }//end of switch 

}while(choice>=1 && choice<=5);
}// end of method 

public static Guest createGuest(){
Guest guest = new Guest();

try{
    String GuestID = JOptionPane.showInputDialog("Please enter the Guest ID");
    guest.setguestID(GuestID);
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}

try{
    String gName = JOptionPane.showInputDialog("Please enter the Guest name");
    guest.setguestName(gName);
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}

try{
    String gPhone = JOptionPane.showInputDialog("Please enter the guest phone number");
    guest.setguestPhone(gPhone);
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}

try{
    String gAddress = JOptionPane.showInputDialog("Please enter the Guest address");
    guest.setguestAddress(gAddress);
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}

try{
    String gEmail = JOptionPane.showInputDialog("Please enter the Guest email");
    guest.setguestEmail(gEmail);
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}

return guest; 
}// end of create a guest 

//search guests 
public static int searchGuests(Guest[] allGuests, String guestID){
int searchIndex = -1;
for(int i=0; i<Guest.getOccupancy();i++){
    if((allGuests[i].getguestID()).equalsIgnoreCase(guestID)){
        searchIndex = i;
        break;
    }
}
return searchIndex;
}

//remove Guest 
public static void removeGuest(Guest[] allGuests) {
printGuest(allGuests);
String removeGuest = JOptionPane.showInputDialog("Enter the Guest you want to remove");
int index = searchGuests(allGuests, removeGuest);
if (index > -1) {
    for (int i = index; i < Guest.getOccupancy(); i++) {
        allGuests[i] = allGuests[i + 1];
    }
    allGuests[Guest.getOccupancy()] = null;
    Guest.updateOccupancy();
    } else {
 JOptionPane.showMessageDialog(null, "Error! Guest was not found");
}
}

//display guest 
public static void printGuest(Guest[] allGuests){
String output = "" ;
for(int i=0; i<Guest.getOccupancy(); i++){
    output += allGuests[i].toString() + "\n";
}
JOptionPane.showMessageDialog(null, output);
}
    
    // ############################################### ZACH'S SECTION ####################################################

    public static void showRoomOptions() {
        // Menu code
        String menu = "**ROOM MENU**\nWhat would you like to do?\n\n1. Create Room\n2. Display Room\n3. Remove Room\n4. Back to Main Program\n5. Exit Program";
        int input = -1;
        do {
            try {
                input = Integer.parseInt(JOptionPane.showInputDialog(menu));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR: Input must be a Number");
                input = 0;
            }

            switch (input) {
                case 1:
                    createRoom();
                    break;
                case 2:
                    displayRoom();
                    break;
                case 3:
                    removeRoom();
                    break;
                case 4:
                    main(null);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Option. Must be 1-5. Try Again.");
            }
        } while (input != 5);
    }

    public static void createRoom() {
        int rn = -1;
        int type = -1;
        int price = -1;

        // Take in user input and extensively validate it. Should be no more errors now!
        do {
            boolean err = false;
            try {
                rn = Integer.parseInt(JOptionPane.showInputDialog("Enter Room Number (0-100): "));
            } catch (NumberFormatException e) {
                err = true;
                JOptionPane.showMessageDialog(null, "ERROR: Room Number must be a Number.");
            }
            // Ensure all room numbers are unique
            for (int i = 0; i < Rooms.length; i++) {
                if (Rooms[i] != null) {
                    if (Rooms[i].getRoomNumber() == rn) {
                        err = true;
                    }
                }
            }
            if (!err) {
                if (rn < 0 || rn > 100) {
                    JOptionPane.showMessageDialog(null, "ERROR: Room number invalid. Must be 0 to 100 and unique");
                }
            }
        } while (rn < 0 || rn > 100);

        do {
            boolean err = false;
            try {
                type = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of Beds (1 or 2): "));
            } catch (NumberFormatException e) {
                err = true;
                JOptionPane.showMessageDialog(null, "Number of Beds must be a Number.");
            }
            if (!err) {
                if (type != 1 && type != 2) {
                    JOptionPane.showMessageDialog(null, "ERROR: Number of Beds must be 1 or 2.");
                }
            }
        } while (type != 1 && type != 2);

        do {
            boolean err = false;
            try {
                price = Integer.parseInt(JOptionPane.showInputDialog("Enter Price per Night (>0): "));
            } catch (NumberFormatException e) {
                err = true;
                JOptionPane.showMessageDialog(null, "ERROR: Price per Night must be a Number.");
            }
            if (!err) {
                if (price <= 0) {
                    JOptionPane.showMessageDialog(null, "ERROR: Price per night must be more than 0");
                }
            }
        } while (price <= 0);

        if (type == 1) {
            String bedType;
            do {
                bedType = JOptionPane.showInputDialog("Enter Bed Type: ");
                if (bedType.equals("") || bedType == null) {
                    JOptionPane.showMessageDialog(null, "ERROR: Invalid Bed Type. Must not be empty or null");
                }
            } while (bedType.equals("") || bedType == null);

            new OneBed(rn, "One Bed", price, bedType);          // Create new OneBed object with provided values
        } else if (type == 2) {
            String[] bedTypes = new String[2];
            do {
                bedTypes[0] = JOptionPane.showInputDialog("Enter Bed Type 1: ");
                if (bedTypes[0].equals("") || bedTypes[0] == null) {
                    JOptionPane.showMessageDialog(null, "ERROR: Invalid Bed Type. Must not be empty or null");
                }
            } while (bedTypes[0].equals("") || bedTypes[0] == null);

            do {
                bedTypes[1] = JOptionPane.showInputDialog("Enter Bed Type 2: ");
                if (bedTypes[1].equals("") || bedTypes[1] == null) {
                    JOptionPane.showMessageDialog(null, "ERROR: Invalid Bed Type. Must not be empty or null");
                }
            } while (bedTypes[1].equals("") || bedTypes[1] == null);

            new TwoBed(rn, "Two Bed", price, bedTypes);     // Create new TwoBed object with provided values
        } else {
            JOptionPane.showMessageDialog(null, "ERROR: Number of Beds must be 1 or 2");
            createRoom();
        }
    }

    public static Room chooseRoom() {
        String output = "Enter Room Number:\n";

        for (int i = 0; i < Room.getNumOfRooms(); i++) {    // Loop through each room
            try {                                           // Try to add it to the output string
                output += "\n" + Rooms[i].toString();
            } catch (NullPointerException e) {}             // Catch any null pointer exceptions and ignore them
        }
        int rn = -1;                                        // Set room number as -1
        do {                                                
            try {
                rn = Integer.parseInt(JOptionPane.showInputDialog(output));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR: Room Number must be an Integer");
            }
        } while (rn < 0);

        for (int i = 0; i < Rooms.length; i++) {            // Loop through the whole array
            if (Rooms[i] != null) {                         // If Rooms[i] is not null ...
                if (Rooms[i].getRoomNumber() == rn) {       // If Rooms[i]'s Room Number is the target Room Number ...
                    return Rooms[i];                        // Return Rooms[i]
                }
            }
        }
        return null;                                        // Otherwise, return null
    }

    public static void displayRoom() {      // If no room parameter ...
        Room room = chooseRoom();           // Call the chooseRoom method and store result in Room object;
        if (room != null) {                 // If the room is not null ...
            displayRoom(room);              // Call the displayRoom method with the room parameter
        } else {                            // Otherwise, print an error
            JOptionPane.showMessageDialog(null, "ERROR: Invalid Room");
        }
    }

    public static void displayRoom(Room roomObj) {
        String output = "SOMETHING WENT WRONG";
        output = roomObj.toString();                // Set output string equal to the object string
        JOptionPane.showMessageDialog(null, output);    // Show output in dialog box
    }

    public static void removeRoom() {       // If no room parameter ...
        Room room = chooseRoom();           // Call the chooseRoom method and store result in room object
        if (room != null) {                 // If the room is not null ...
            removeRoom(room);               // Call the removeRoom method with the provided room object
        } else {                            // Otherwise, print an error
            JOptionPane.showMessageDialog(null, "ERROR: Invalid Room");
        }
    }

    public static void removeRoom(Room room) {
        int num = -1;                       // Set the num to -1 initally
        num = room.getRoomNumber();         // Set the num to the room number of the provided room object
        int roomID = 0;                     // Set the room ID to 0

        for (int i = 0; i < Rooms.length; i++) {        // Loop through the entire Rooms array
            if (Rooms[i] != null) {                     // If Rooms[i] is not null ...
                if (Rooms[i].getRoomNumber() == num) {  // If Rooms[i]'s room number is the target room number ...
                    roomID = i;                         // roomID is i
                }
            }
        }

        for (int i = roomID; i < Room.getNumOfRooms(); i++) {   // Loop through all rooms starting from roomID
            Rooms[i] = Rooms[i + 1];                            // Move the room objects forward one positon
        }
        Rooms[Room.getNumOfRooms()] = null;                     // Set the final element to null
        Hotel.setRoom(Rooms);                                   // Copy the implementation class rooms array to hotel class rooms array
        Room.decrementNumOfRooms();                             // Call the decrementNumOfRooms method
    }
};
