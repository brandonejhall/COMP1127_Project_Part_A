package project;

import java.util.Scanner;

public class SportsVenue extends  Venue {
   private double competitorArea;
   private double spectatorArea;
   private int numSecurity;
   
	/**
	 * Sports Venue constructor 
	 * 
	 * Accepts and sets arguements to the variables declared.
	 * 
	 * @param name The name of the Sport venue.
	 * @param competitorArea Size of the competitor area.
	 * @param spectatorArea Size of the spectator area.
	 * @param numSecurity Number of security personnell present at the venue
	 * @param basePrice The Base price to book the venue
	 * @param lev The level of seperation between people at the venue
	 */
   public SportsVenue(String name, double competitorArea, double spectatorArea,
		              int numSecurity, double basePrice, int lev)
	{
	super(name, competitorArea +spectatorArea, basePrice,  lev);
	this.competitorArea = 	competitorArea;
	this.spectatorArea = spectatorArea;
	this.numSecurity=numSecurity;

	}
   
   public double getSize()
   {
	   return competitorArea+ spectatorArea;
   }
   
   public int countSecurity()
   {
	   return numSecurity;
   }
   
   

	public double getCompArea()
	{
		return competitorArea;
	}
	
	public double getSpecArea()
	{
		return spectatorArea;
				
	}
	

	
	public int getNumSecurity()
	{
		return numSecurity;
	}
	
	
	public void setCompArea(double competitorArea)
	{
		
		this.competitorArea =competitorArea;
	}
	
	public void setSpecArea(double spectatorArea)
	{
		
		this.spectatorArea =spectatorArea;
	}
	

	
	public void setNumSecurity(int numSecurity)
	{
		
		this.numSecurity =numSecurity;
	}

	
	public double getEstimate(String type)
	{
		double price = basePrice;
		if (type.equals("PARTY"))
			price += partyPrep;
		if (type.equals("TRAINING"))
			price += trainPrep;
	
		
		//System.out.println(this.getName()+":estimate  to hold a "+type +" is "+ price);
		return price;

	}
	   public String toString()
	   {
	   	return "ID:"+this.getId()+";"+this.getName() +";#Events:"+this.getApprovedEvents().size()+";Compet Area:"+competitorArea+";Spec Area:"+spectatorArea+";#Sec:"+numSecurity;
	   	
	   }
	   public String toFile()
	   {
		   	return ""+this.getId()+";"+this.getName() +";"+this.getApprovedEvents().size()+";"+competitorArea+";"+spectatorArea+";"+numSecurity;
		   	
		   }

		
		/**
 		 * UpdateLocalData mehtod allows the user to change the data of different
 		 * parts of the venue such as the venue's name,price,competitor area size,
 		 * spectator area size, number of security personnel and level of seperation. 
 		 * <p>
 		 * The method prompts the user to enter the change in data for each part of a venue 
 		 * or to leave it blank to maintain the variable's current value. 
 		 *
 		 * @param scan accepts user input
 		 */
		
		public void updateLocalData(Scanner scan)
	{	
		scan.nextLine();
		
		String currname = getName();
		double currPrice = getPrice();
		double currCompetitor = getCompArea();
		double currSpectator=getSpecArea();
		int currSecurity=getNumSecurity();
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

		System.out.println("Hit enter to keep the Competitor Area size at ["+currCompetitor +"] or enter a new size:");
		String competitorEntry = scan.nextLine();
		double vComepetitor;
		vComepetitor = competitorEntry== ""? currCompetitor: Double.parseDouble(competitorEntry);

		System.out.println("Hit enter to keep the spectator area size at ["+currSpectator +"] or enter a new size:");
		String spectatorEntry = scan.nextLine();
		double vSpectator;
		vSpectator = spectatorEntry== ""? currSpectator: Double.parseDouble(spectatorEntry);


		System.out.println("Hit enter to keep the number of security  at ["+currSecurity +"] or enter new budget:");
		String securityEntry = scan.nextLine();
		int vSecurity;
		vSecurity = securityEntry==""? currlevel : Integer.parseInt(securityEntry);



		System.out.println("Hit enter to keep the level at ["+currlevel +"] or enter new level:");
		String levelEntry = scan.nextLine();
		int vLevel;
		vLevel = levelEntry==""? currlevel : Integer.parseInt(levelEntry);

		setName(name);
		setPrice(vprice);
		setCompArea(vComepetitor);
		setSpecArea(vSpectator);
		setNumSecurity(vSecurity);
		setLevel(vLevel);

	}





}
