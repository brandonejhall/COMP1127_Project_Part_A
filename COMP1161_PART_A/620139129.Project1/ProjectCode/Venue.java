import java.io.*;
import java.util.*;


class Venue
{ 
    private String name;
    private double size;
    protected double basePrice;
    private ArrayList<Event> approvedEvents=new ArrayList<Event>();
    private int level; // 1,2,3 for low,medium, high respectively;
    private int id;
    private static int nextId=0;
    protected double partyPrep=2000,  trainPrep=500, sportsPrep = 1000;


    public Venue(){}

    public Venue(String name, double size, double basePrice,int lev)
    {
        this.name=name;
        this.size=size;
        this.basePrice=basePrice;
        this.level=lev;
        id=nextId;
        nextId++;
    }


    public boolean BooleanAvailable(Date date)
    {
        for (Event eve:approvedEvents)
        {
            if (eve.getDate().getDay()==date.getDay())
                {return false;}
        }
        return true;
    }

    public int getID(){return id;}
    public String getName(){return name;}
    public double getSize(){return size;}
    public String toString(){return this.name;}
    
    public double getEstimate(String type)
        {
            if (type.equals("SPORT"))
            {
                return basePrice+sportsPrep;
            }
            else if (type.equals("TRAINING")) 
            {
                return basePrice+trainPrep;    
            }
            else if (type.equals("PARTY")) 
            {
                return basePrice+partyPrep;    
            }
            else{return basePrice;}
        }


    public boolean canHold (int numPatrons)
        {
            if (level==1) {
                if ((size/3.0)>=numPatrons) {
                    return true;    
                }
                else
                    return false;
            }
            else if (level==2) {
                if ((size/6.0)>=numPatrons) {
                    return true;    
                }
                else
                    return false;
            }

            
            else if (level==3) {
                if ((size/50.0)>=numPatrons) {
                    return true;    
                }
                else
                    return false;
            }
            
            else
                return false;        

        }


    public void promoteEvents()
    {
        System.out.println("EVENTS AT "+getName());
        System.out.println("===================");
        for (Event event:approvedEvents)
            System.out.println(event.toString());
        System.out.println("--------------------");
    }


    public int reserve(Event event, double availBal, Ministry mny)
    {
     ApprovalRequest Request =  new ApprovalRequest(event,this);
     
     if (mny.checkApproval(Request)>=0) {
        if (availBal>=getEstimate(event.getType())){
            approvedEvents.add(event);
            event.setVenue(this);    
        }
     }
     return mny.checkApproval(Request);    
    }

}