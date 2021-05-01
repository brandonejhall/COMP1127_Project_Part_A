import java.io.*;
import java.util.*;



class TrainingVenue extends Venue{
    private double instructorArea,otherArea;

    public TrainingVenue(String name, double instructorArea, double otherArea, double basePrice, int lev)
    {
        super(name,(instructorArea+otherArea),basePrice,lev);
        this.instructorArea=instructorArea;
        this.otherArea=otherArea;
    
    }
    public double getInstructorArea()
    {
        return instructorArea;
    }
    public double getOtherArea()
    {
        return otherArea;
    }
    public double getEstimate( String type)
    {    
        if (type.equals("SPORT")){
            return  basePrice+ sportsPrep;
        }
        else if (type.equals("PARTY")){
            return  basePrice+ partyPrep;
        }
        else{
            return basePrice;
        }
    } 

}