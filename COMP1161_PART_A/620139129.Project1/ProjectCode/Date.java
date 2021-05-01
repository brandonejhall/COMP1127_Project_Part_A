class Date
{
    private int day;
    
    
    public  Date(int day) 
    {
        this.day=day;    
    }
    
    public void setDate(int day) {
        this.day=day;
    }
    
    public int getDay() {
        return day;
    }
    
    public Date next(int day){
        day+=1;
        Date d=new Date(day);
        return d;
        
    }
    
    public String toString() {
        return String.valueOf(day);
    }
    
}