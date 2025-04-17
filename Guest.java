public class Guest {
    //instance variables 
    private String guestID;
    private String guestName;
    private String guestPhone;
    private String guestAddress;
    private String guestEmail; 
     //static variable 
    private static int Occupancy; 
   

    Guest(){
        this.guestID = "";
        this.guestName = "";
        this.guestPhone = "";
        this.guestAddress = "";
        this.guestEmail = "";
        Occupancy++;
    }

    Guest(String guestID, String guestName, String guestPhone, String guestAddress, String guestEmail){
        this.guestID = "";
        this.guestName = "";
        this.guestPhone = "";
        this.guestAddress = "";
        this.guestEmail = "";
        Occupancy++;
    }

    //Accessors (getter methods)
    public String getguestID (){
        return this.guestID;
    }
    public String getguestName (){
        return this.guestName;
    }
    public String getguestPhone (){
        return this.guestPhone;
    }
    public String getguestAddress (){
        return this.guestAddress;
    }
    public String getguestEmail (){
        return this.guestEmail;
    }
    public static int getOccupancy(){
        return Occupancy;
    }

    //mutators (setter methods)
    //length validation?
    public void setguestID (String guestID){
        if(guestID.equals("") && guestID.length() != 5)
        throw new IllegalArgumentException(" Error! The reservation ID cannot be blank and must have a length of 5");
    else 
        this.guestID = guestID;
    }
    //make sure its only alphabet?
    public void setguestName (String guestName){
        this.guestID = guestName;
    }
    //validation using is digit 
    public void setguestPhone (String guestPhone){
        this.guestID = guestPhone;
    }
    public void setguestAddress (String guestAddress){
    if(!guestAddress.equals(""))
        this.guestAddress = guestAddress;
    else
        throw new IllegalArgumentException("Error! Please fill out the field");
    }
    public void setguestEmail (String guestEmail){
    if(!guestEmail.equals(""))
        this.guestEmail = guestEmail;
    else
        throw new IllegalArgumentException("Error! Please fill out the field");
    }

    //toString method 
    public String toString (){
        return this.getguestID() + " | "  + 
        this.getguestName() + " | "  + 
        this.getguestPhone() + " | "  + 
        this.getguestAddress() + " | "  + 
        this.getguestEmail(); 
    }
    
}