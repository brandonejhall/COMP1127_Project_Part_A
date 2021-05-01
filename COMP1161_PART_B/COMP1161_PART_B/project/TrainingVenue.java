package project;

import java.util.Scanner;

public class TrainingVenue extends Venue {
	private double instructorArea;
	private double otherArea;
   	

/**
 * 
 * Training Venue constructor
 * 
 * accepts and sets arguements to the variables declared
 * 
 * @param name The name of Training venue
 * @param instructorArea Size of the Instructor Area
 * @param otherArea Any other area in the venue size
 * @param basePrice Base price of booking the training venue
 * @param lev the level of seperation between people at the venue 
 */

public TrainingVenue(String name, double instructorArea, double otherArea,
		double basePrice,int lev)
{
super(name, instructorArea +otherArea, basePrice,  lev);
this.instructorArea = 	instructorArea;
this.otherArea = otherArea;

}
public double getEstimate(String type)
{
		double price = basePrice;
		if (type.equals("PARTY"))
			price += partyPrep;
        if (type.equals("SPORT"))
				price += sportsPrep;

		//System.out.println(this.getName()+":estimate  to hold a "+type +" is "+ price);
		return price;

	}



public double getInstructorArea()
{
	return instructorArea;
}

public double getOtherArea()
{
	return otherArea;
			
}



public void setInstructorArea(double instructorArea)
{
	
	this.instructorArea =instructorArea;
}

public void setOtherArea(double otherArea)
{
	
	this.otherArea =otherArea;
}

public String toString()
{
	return "ID:"+this.getId()+";"+this.getName() +";#Events:"+this.getApprovedEvents().size()+";Inst.Area"+instructorArea+";Oth.Area"+otherArea;
	
}
public String toFile()
{
	return ""+this.getId()+";"+this.getName() +";"+this.getApprovedEvents().size()+";"+instructorArea+";"+otherArea;	
}


/**
 * UpdateLocalData Mehtod allows the user to change the data of different
 * parts of the venue such as the venue's name,price,instructor area size,
 * any other area in the venue size and level of seperation . 
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
		double currInstructor = getInstructorArea();
		double currOther=getOtherArea();
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

		System.out.println("Hit enter to keep the Instructor Area size at ["+currInstructor +"] or enter a new size:");
		String instructorEntry = scan.nextLine();
		double vInstructor;
		vInstructor = instructorEntry== ""? currInstructor: Double.parseDouble(instructorEntry);

		System.out.println("Hit enter to keep the other area size at ["+currOther +"] or enter a new size:");
		String otherEntry = scan.nextLine();
		double vOther;
		vOther = otherEntry== ""? currOther: Double.parseDouble(otherEntry);

		System.out.println("Hit enter to keep the level at ["+currlevel +"] or enter new budget:");
		String levelEntry = scan.nextLine();
		int vLevel;
		vLevel = levelEntry==""? currlevel : Integer.parseInt(levelEntry);

		setName(name);
		setPrice(vprice);
		setInstructorArea(vInstructor);
		setOtherArea(vOther);
		setLevel(vLevel);

	}

}

