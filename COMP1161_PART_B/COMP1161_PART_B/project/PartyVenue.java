package project;

import java.util.Scanner;

public class PartyVenue extends Venue{
	double stageArea;
	double barArea, foodArea;
	int numSecurity;
	
	/**
	 * Party Venue constructor
	 * 
	 * accepts and sets arguements to the variables declared
	 * 
	 * @param name name of party venue
	 * @param stageArea size of stage area
	 * @param barArea size of bar area
	 * @param foodArea size of food area
	 * @param numSecurity number of security at the venue
	 * @param basePrice the base cost of using the venue
	 * @param lev the level of seperation at the venue 
	 */
	public PartyVenue(String name, double stageArea,	double barArea, 
			           double foodArea,int numSecurity, double basePrice,
			            int lev)
	{
		super( name, stageArea+barArea+foodArea, basePrice, lev);
		this.numSecurity=numSecurity;
		this.stageArea = 	stageArea;
		this.barArea = barArea;
		this.foodArea = foodArea;
		
		
		
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
	
	public double getCurrStage()
	{
		return stageArea;
	}
	
	public double getBarArea()
	{
		return barArea;
	}
	
	public double getFoodArea()
	{
		return foodArea;
	}
	
	
	public int getNumSecurity()
	{
		return numSecurity;
	}
	
	public void setStageArea(double stageArea)
	{
		
		this.stageArea =stageArea;
	}
	
	public void setFoodArea(double foodArea)
	{
		
		this.foodArea =foodArea;
	}
	
	public void setBarArea(double barArea)
	{
		
		this.barArea =barArea;
	}	
	
	public void setNumSecurity(int numSecurity)
	{
		
		this.numSecurity =numSecurity;
	}

	
	   public String toString()
	   {
	   	return "ID:"+this.getId()+";"+this.getName() +";#Events:"+this.getApprovedEvents().size()+";Stage Area:"+stageArea+";Bar Area:"+barArea+";Food Area:"+foodArea+";#Sec"+numSecurity;
	   	
	   }
	   public String toFile()
	   {
		   	return ""+this.getId()+";"+this.getName() +";"+this.getApprovedEvents().size()+";"+stageArea+";"+barArea+";"+foodArea+";"+numSecurity;
		   	
		   }	
		   
		   /**
			* UpdateLocalData Mehtod allows the user to change the data of different
			* parts of the venue such as the venue's name,price,stage size, bar area size,food area size,
			* number of security personnel and level of seperation.
	 		* <p>
	 		* The method prompts the user to enter the change in data for each part of a venue 
	 		* or to leave it blank to maintain the variable's current value. 
			*
			*@param scan accepts user input
		    */
	public void updateLocalData(Scanner scan)
	{	
		scan.nextLine();
		
		String currname = getName();
		double currPrice = getPrice();
		double currStage = getCurrStage();
		double currBar= getBarArea();
		double currFood=getFoodArea();
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

		System.out.println("Hit enter to keep the Stage Area size at ["+currStage+"] or enter a new size:");
		String stageEntry = scan.nextLine();
		double vStage;
		vStage = stageEntry== ""? currStage: Double.parseDouble(stageEntry);

		System.out.println("Hit enter to keep the bar area size at ["+currBar +"] or enter a new size:");
		String barEntry = scan.nextLine();
		double vBar;
		vBar = barEntry== ""? currBar: Double.parseDouble(barEntry);

		System.out.println("Hit enter to keep the food area size at ["+currFood +"] or enter a new size:");
		String foodEntry = scan.nextLine();
		double vFood;
		vFood = foodEntry== ""? currFood: Double.parseDouble(foodEntry);


		System.out.println("Hit enter to keep the number of security  at ["+currSecurity +"] or enter new budget:");
		String securityEntry = scan.nextLine();
		int vSecurity;
		vSecurity = securityEntry==""? currSecurity : Integer.parseInt(securityEntry);



		System.out.println("Hit enter to keep the level at ["+currlevel +"] or enter new budget:");
		String levelEntry = scan.nextLine();
		int vLevel;
		vLevel = levelEntry==""? currlevel : Integer.parseInt(levelEntry);

		setName(name);
		setPrice(vprice);
		setStageArea(vStage);
		setBarArea(vBar);
		setFoodArea(vFood);
		setNumSecurity(vSecurity);
		setLevel(vLevel);

	}


}
