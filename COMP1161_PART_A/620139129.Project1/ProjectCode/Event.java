class Event{
    private String name;
    private String type;
    private int numPeople;
    private Date date;
    private Venue v;
    
    public Event(String name,String type,int numPeople, Date date) {
        this.name=name;
        this.type=type;
        this.numPeople=numPeople;
        this.date=date;
    }
    
    public String getName() {return name;}
    public String getType() {return type;}
    public int getNumPeople() {return numPeople;}
    public Date getDate() {return date;}
    public Venue getVenue() {return v;}
    
    public void setVenue(Venue v) {this.v=v;}
    
    public String toString() {
        return "Date:"+this.getDate()+";Name:"+this.getName()+";Type:"+this.getType()+";Venue:"+this.getVenue(
            )+":numPeople:"+this.getNumPeople();
    }
    
    
}
