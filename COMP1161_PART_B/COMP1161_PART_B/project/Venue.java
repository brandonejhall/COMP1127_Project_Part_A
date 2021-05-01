package project;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *Venue
 **/
public class Venue implements Comparable<Venue> {
	private String name;
	private double size;
	protected double basePrice;
	private ArrayList<Event> approvedEvents=new ArrayList<Event>();
	private int level; // 1,2,3 for low,medium, high repectively;
	private int id;
	private static int nextId=0;
	protected double partyPrep=2000,  trainPrep=500, sportsPrep = 1000;
	
	
	public Venue() 
	{}
	/**
	 *Venue constructor accepts and sets arguements to the variables declared.

	 *@param name The name of the venue
	 *@param size The size of the venue
	 *@param basePrice The base price for the venue
	 *@param lev The level the venue will be set at
	 **/
	public Venue( String name, double size, double basePrice, int lev)
	{
        this.name = name;
		this.size = size;
		this.basePrice=basePrice;
		this.level = lev;
	
		id =nextId;
		nextId++;
	}
	
	public static void resetId()
	{
		
		nextId=0;
	}
	
	//////
	
	public int compareTo(Venue other)
	{
		return this.getName().compareTo(other.getName());
	}
	
	public double getSize()
	{
		return size;
	
	}
	
	public String getName()
	{
		return name;
	}
	public double getPrice()
	{
		return basePrice;
	
	}
	
	public int getLevel()
	{
		return level;
	}
	
	/** 
	 * Update Local Data Mehtod allows the user to change the data of different
	 * parts of the venue such as the venue's name,price,size and level.
	 * <p>
	 * The method prompts the user to enter the change in data for each part of a venue 
	 * or to leave it blank to maintain the variable's current value.
	 * 
	 * @param scan collects the input from a user 
	 */
	public void updateLocalData(Scanner scan)
	{	
		scan.nextLine();
		
		String currname = getName();
		double currPrice = getPrice();
		double currSize = getSize();
		int currlevel = getLevel();

		System.out.println("Hit enter to keep venue name as ["+currname+"], or enter new venue name:");
		String name = scan.nextLine();
		if (name.equals(""))
			name = currname;

		System.out.println("Hit enter to keep the price at ["+currPrice +"] or enter new budget:");
		String priceEntry=scan.nextLine();
		double vprice;
		if (priceEntry.equals(""))
			vprice = currPrice;
		else
			vprice = Double.parseDouble(priceEntry);
		
		System.out.println("Hit enter to keep the price at ["+currSize +"] or enter new budget:");
		String sizeEntry = scan.nextLine();
		double vSize;
		vSize = sizeEntry== ""? currSize: Double.parseDouble(sizeEntry);

		System.out.println("Hit enter to keep the level at ["+currlevel +"] or enter new budget:");
		String levelEntry = scan.nextLine();
		int vLevel;
		vLevel = levelEntry==""? currlevel : Integer.parseInt(levelEntry);

		setName(name);
		setPrice(vprice);
		setSize(vSize);
		setLevel(vLevel);
	}
	
	public void setName(String name)
	{
		
		this.name =name;
	}
	
	public void setPrice(double basePrice)
	{
		
		this.basePrice =basePrice;
	}
	
	public void setSize(double size)
	{
		
		this.size =size;
	}	
	
	public void setLevel(int level)
	{
		
		this.level =level;
	}
	
	
	public double getEstimate(String type)
	{
		double price = basePrice;
		if (type.equals("PARTY"))
			price += partyPrep;
		if (type.equals("SPORT"))
			price += sportsPrep;
		if (type.equals("TRAINING"))
			price += trainPrep;
	
		
		//System.out.println(this.getName()+":estimate  to hold a "+type +" is "+ price);
		return price;

	}

public int getId()
{
	return id;
}


	public int reserve( Event event,double availBal, Ministry min)

	{   
		System.out.println("Submitted "+event +" for approval at " + this);
		ApprovalRequest ar = new ApprovalRequest(event, this);
	int approval = min.checkApproval(ar);
	if (approval>=0)
	{
		if (availBal >= getEstimate(event.getType()))
		{
            approvedEvents.add(event);
			event.setVenue(this);
			System.out.println("Successfully Approved and registered "+event.toString());
		}
			
	}
			
	return approval;
	}
	
	public boolean available(Date date)
	{
		boolean returnVal=true;
			
		ArrayList<Integer> reservedDays = new ArrayList<Integer>();
		for(Event e:approvedEvents)
			reservedDays.add(e.getDate().getDay());
		int dx =0;
		while ((dx<reservedDays.size())&&(returnVal))
		{
			if (date.getDay()==approvedEvents.get(dx).getDate().getDay())
				returnVal=false;
			dx++;
		}
		//System.out.println("checking  "+getName()+" availability for "+ date.getDay()+":"+ returnVal);
		
		
		return returnVal;
	}
	
	public  boolean canHold(int nump)
	{
		boolean returnVal = false;
		
	    int separation=0;
	  		switch(level)
	   		{
	   		case 1:{
	   			separation= Ministry.LOWRISK_SEPARATION;
	   			break;
	   		}
	   		case 2:{
	   			separation= Ministry.MEDIUMRISK_SEPARATION;
	   			break;
	   		}
	   		case 3:{
	   			separation= Ministry.HIGHRISK_SEPARATION;
	   			break;
	   		}
	   		}
	  	//System.out.println(this.getName()+":"+this.getSize()+"/"+separation);
        if (nump <(int)(getSize()/separation))
           returnVal = true;
        
        else
        	 returnVal= false;
		//System.out.println("checking  "+getName()+" space for "+ nump +" persons "+":"+ returnVal);

		return returnVal;
	}


	public void promoteEvents(PrintStream outStream)
	{
		outStream.println("EVENTS AT "+getName());
		outStream.println("===================");
	    for(Event e:approvedEvents)
		   outStream.println(e);
	    outStream.println("--------------------");
		   
	}
	
	public ArrayList<Event> getApprovedEvents()
	{
		
		return approvedEvents;
	}
	

	public String toString()
	{
		return "ID:"+this.getId()+";"+this.name +";#Events:"+this.approvedEvents.size()+";Area:"+this.getSize();
		
	}
	
	public String toFile()
	{
		return ""+this.getId()+";"+this.name +";"+this.approvedEvents.size()+";"+this.getSize();
		
	}

}
