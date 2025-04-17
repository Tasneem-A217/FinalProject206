public class Hotel {
    private String hotelName;
    private String phoneNumber;
    private String emailAddress;
    private String checkInTime;
    private String checkOutTime;
    //private Reservation reservation;

    public Hotel(String hotelName,String phoneNumber, String emailAddress, String checkInTime, String checkOutTime ){
         this.hotelName = hotelName;
         this.phoneNumber = phoneNumber;
         this.emailAddress = emailAddress;
         this.checkInTime = checkInTime;
         this.checkOutTime = checkOutTime;

    }
    public String getHotelName(){return this.hotelName;}
    public String getPhoneNumber(){return this.phoneNumber;}
    public String getEmailAddress(){return this.emailAddress;}
    public String getCheckInTime(){return this.checkInTime;}
    public String getCheckOutTime(){return this.checkOutTime;}

    public void  setHotelName(String hotelName){
        if(hotelName.equals(""))
        this.hotelName = hotelName;
    }
    public void setPhoneNumber(String phoneNumber){
        if(phoneNumber.equals(""))
        this.phoneNumber = phoneNumber;
    }
    public void setEmailAddress(String emailAddress){
        if(emailAddress.equals(""))
        this.emailAddress = emailAddress;
    }
    public void setCheckInTime(String checkInTime){
        if(checkInTime.equals(""))
        this.checkInTime = checkInTime;
    }
    public void setCheckOutTime(String checkOutTime){
        if(checkOutTime.equals(""))
        this.checkOutTime = checkOutTime;
    }

    public String toString(){
        return "Hotel Name: " + this.getHotelName() + "\n"
        + "Hotel Phone number: " + this.getPhoneNumber() + "\n"
        + "Address: " + this.getEmailAddress() + "\n"
        + "Check In: "+ this.getCheckInTime() + "\n"
        + "Check Out: " + this.getCheckOutTime() + "\n";
    }
}




