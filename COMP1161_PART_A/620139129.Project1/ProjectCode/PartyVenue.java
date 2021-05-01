import java.io.*;
import java.util.*;



class PartyVenue extends Venue{
    private double stageArea,barArea, foodArea;
    private double numSecurity;


    public PartyVenue(String name, double stageArea,double barArea,double foodArea, double numSecurity,double basePrice, int lev)
    {
        super(name,(stageArea+barArea+foodArea),basePrice,lev);
        this.stageArea=stageArea;
        this.foodArea=foodArea;
        this.barArea=barArea;
        this.numSecurity=numSecurity; 
    }

    public double getBarArea()
    {
        return barArea;
    }

    public double getFoodArea()
    {
        return foodArea;
    }

    public double getStageArea()
    {
        return stageArea;
    }

    public int getNumSecurity()
    {
        return (int)numSecurity;
    }

    public double getEstimate( String type)
    {    
        if (type.equals("SPORT")){
            return  basePrice+ sportsPrep;
        }
        else if (type.equals("TRAINING")){
            return basePrice+ trainPrep;
        }
        else{
            return basePrice;
        }
    }
}