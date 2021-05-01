import java.io.*;
import java.util.*;


class SportsVenue extends Venue
{

    private double competitorArea;
    private double specatotrArea;
    private int numSecurity;

    public SportsVenue(String name, double competitorArea, double specatotrArea, int numSecurity,double basePrice,int lev)
    {
        super(name,(competitorArea+specatotrArea),basePrice,lev);
        this.competitorArea=competitorArea;
        this.specatotrArea=specatotrArea;
        this.numSecurity=numSecurity;
    }


    public double getcompetitorArea(){return competitorArea;}
    public double getspectatorArea(){return specatotrArea;}
    public double getNumSecurity(){return numSecurity;}
    
    public double getEstimate(String type)
    {
        
            if (type.equals("TRAINING")) 
            {
                return basePrice+trainPrep;    
            }
            else if (type.equals("PARTY")) 
            {
                return basePrice+partyPrep;    
            }
            else{return basePrice;}
    }

}