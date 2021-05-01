import java.util.ArrayList;

class Promoter{
    private String name;
    private double budget;
    private Ministry mny;
    Venue[] venues;
    private Venue bestvenue;
    
    
    public Promoter(String name,double budget,Ministry mny,Venue[] venues) {
        this.name=name;
        this.budget=budget;
        this.mny=mny;
        this.venues=venues;
        }
    public int getBudget() {return (int)budget;}
    public String getName() {return name;}
    
    public void payFor(Venue venue,Event event) {
        String type=event.getType();
        this.budget-=venue.getEstimate(type);
            
    }
    
    public int planEvent(int numPatrons,String eventType, Date date) 
    {
        ArrayList<Venue>  affordable= new ArrayList<Venue>();
        
        //Traverse through venue array 
        for (Venue v: venues) 
        {
        //Checks if Venue is affordable   
        if ((v.getEstimate(eventType)<=budget && v.canHold(numPatrons))&& v.BooleanAvailable(date)) 
            {
                affordable.add(v);
            }
        }
        
        // Checks if affordable array list is empty
        if (affordable.isEmpty())
        {
            return -1;
        }
        
        //Sets lowestcost to the first element in list
        Venue lowestcost = affordable.get(0);
        
        //Finds the cheapest venue
        for (Venue cheap:affordable) 
            if (cheap.getEstimate(eventType)<lowestcost.getEstimate(eventType))       
            {
            lowestcost=cheap;
            }
            

            
            Event event = new Event(this.name, eventType, numPatrons, date);
            
            int reservation = lowestcost.reserve(event, budget , mny);
            
            if (reservation>=0)
            { 
                event.setVenue(lowestcost);
                payFor(lowestcost,event);
                return reservation;}
           
            
            return -1;
        
    
   
    }

}