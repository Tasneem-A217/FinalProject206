//ZACH
public class OneBed extends Room {
    private String bedType;

   
    OneBed () {
        super();
        setBedType("Twin");

        ImplementationClass.Rooms[Room.getNumOfRooms()] = this;
        Hotel.setRoom(ImplementationClass.Rooms);

        Room.incrementNumOfRooms();
    }

    
    OneBed (int roomNumber, String roomType, double pricePerNight, String bedType) {
        super(roomNumber, roomType, pricePerNight);
        setBedType(bedType);

        ImplementationClass.Rooms[Room.getNumOfRooms()] = this;
        Hotel.setRoom(ImplementationClass.Rooms);

        Room.incrementNumOfRooms();
    }

    public void setBedType (String bedType) {
        if (bedType.equals("") || bedType == null) {
            throw new IllegalArgumentException("Bed type must not be empty or null");
        } else {
            this.bedType = bedType;
        }
    }

    public String getBedType () {
        return this.bedType;
    }

    public String toString () {
        return super.toString() + ", Bed Type: " + this.getBedType();
    }
}
