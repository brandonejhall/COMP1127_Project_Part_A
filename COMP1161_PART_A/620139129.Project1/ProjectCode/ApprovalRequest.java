class ApprovalRequest{
    private Event event;
    private Venue venue;
    private int id;
    private  static int count;
    
    public ApprovalRequest(Event event, Venue venue) {
        this.event=event;
        this.venue=venue;
        this.id=count++;
        
    }
    
    public int getId() {return id;}
    public Event getEvent(){return event;}
    public Venue getVenue() {return venue;}
    
   
    
}