package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class EntryScreen {

	public EntryScreen() {}

	public ArrayList<Promoter> managePromoters(Scanner scan,ArrayList<Promoter> proms, Ministry min, ArrayList<Venue> vens) throws NumberFormatException
	{
		ReportScreen r = new ReportScreen();
		char mchoice = 'c';
		String menu="";
		while (mchoice!='X')
		{
			String menuOptions = "[A]dd/Create promoter\n[E]dit/Update promoter\n";
			menuOptions+="[L]ist/Read promoters\n[D]elete promoter\nE[x]it\n";
			System.out.println(menuOptions);
			menu = scan.next().toUpperCase();
			mchoice = menu.charAt(0);
			switch(mchoice)
			{
			case 'A':{
				Promoter p = createPromoter(scan, min, vens);
				if (p!=null)
					proms.add(p);
				break;
			}
			case 'L':{
				Collections.sort(proms); 
				r.listPromoters(proms, System.out);
				break;
			}
			case 'E':{
				System.out.println("Please enter the ID of the promoter to be updated:");
				int pid = Integer.parseInt(scan.next());
				int pdx = findPromoter(proms,pid);
				if (pdx>=0)
					proms.get(pdx).updateLocalData(scan);
				else
					System.out.println("Promoter with id "+pid+ " not found.");
				break;
			}
			case 'D':{
				System.out.println("Please enter the ID of the promoter to be deleted:");
				int pid = Integer.parseInt(scan.next());
				int pdx = findPromoter(proms,pid);

				if (pdx>=0)
					proms.remove(pdx);
				else
					System.out.println("Promoter with id "+pid+ " not found.");
				break;
			}


			}

		}
		return proms;
	}

	public Promoter createPromoter( Scanner scan, Ministry min, ArrayList<Venue> vens)
	{
		Promoter p = null;
		try
		{
		System.out.println("Please enter Promoter Name:");
		String name = scan.next();
		System.out.println("Please enter Promoter Budget:");
		double budget = Double.parseDouble(scan.next());
		p = new Promoter(name, budget, min, vens);
		}
		catch(NumberFormatException nfe)
		{}
		return p;
	}

	public int findPromoter(ArrayList<Promoter> proms, int pid)
	{
		int pdx =-1;
		int currdx=0;
		while ((currdx<proms.size())&&(pdx==-1))
		{
			if (proms.get(currdx).getId()==pid)
				pdx = currdx;
			currdx++;

		}

		return pdx;

	}

	public ArrayList<Venue> manageVenues(Scanner scan, ArrayList<Venue> vens)throws NumberFormatException
	{
		ReportScreen r = new ReportScreen();
		char mchoice = 'c';
		String menu="";
		while (mchoice!='X')
		{
			String menuOptions = "[A]dd/Create Venue\n[E]dit/Update Venue\n";
			menuOptions+="[L]ist/Read Venue\n[D]elete Venue\nE[x]it\n";
			System.out.println(menuOptions);
			menu = scan.next().toUpperCase();
			mchoice = menu.charAt(0);
			switch(mchoice)
			{
				case 'A':
				{
					Venue v=createVenue(scan);
					if (v!=null)
						vens.add(v);
					break;
					
				}

				case 'L':
				{
					Collections.sort(vens);
					r.listVenues(vens, System.out);
					break;
				}

				case 'E':
				{
					System.out.println("Please enter the ID of the venue to be updated:");
					int vid = Integer.parseInt(scan.next());
					int vdx = findVenue(vens,vid);
					if (vdx>=0)
					{	
						if (vdx>=0)
							vens.get(vdx).updateLocalData(scan);
					}	
					else
						System.out.println("Promoter with id "+vid+ " not found.");
					break;
					
					
				}

				case 'D':
				{
					System.out.println("Please enter the ID of the venue to be updated:");
					int vid = Integer.parseInt(scan.next());
					int vdx = findVenue(vens,vid);
					if (vdx>=0)
						vens.remove(vdx);
					else
						System.out.println("Venue with id "+vid+ " not found.");
					break;
				}

			}

		}
		return vens;
	}

	public Venue createVenue( Scanner scan)
	{
		Venue v = null;
		char mchoice ='c';
		String menu="";

		while(mchoice!='X')
		{
			
			String type="[R]egular\n[P]arty\n[S]ports\n[T]raining\ne[X]it";
			System.out.println(type);
			menu = scan.next().toUpperCase();
			mchoice = menu.charAt(0);
			switch(mchoice)
			{
				case 'R':
				{
					System.out.println("Enter Venue Name:\n");
					String name = scan.next();

					System.out.println("Enter Venue Size:\n");
					double size = Double.parseDouble(scan.next());

					System.out.println("Enter Venue price:\n");
					double price = Double.parseDouble(scan.next());

					System.out.println("Enter a venue level between either 1,2 or 3 :\n");
					int level = Integer.parseInt(scan.next());

					v = new Venue(name,size,price,level);
					break;
				}

				case 'P':
				{
					System.out.println("Enter Venue Name:");
					String name = scan.next();

					System.out.println("Enter Stage Area Size:");
					double stage = Double.parseDouble(scan.next());

					System.out.println("Enter Bar Area Size:");
					double bar = Double.parseDouble(scan.next());
					
					System.out.println("Enter Food Area Size:");
					double food = Double.parseDouble(scan.next());

					System.out.println("Enter Venue price:");
					double price = Double.parseDouble(scan.next());

					System.out.println("Enter number of Security personell:");
					int security = Integer.parseInt(scan.next());

					System.out.println("Enter a venue level between either 1,2 or 3 :");
					int level = Integer.parseInt(scan.next());

					v = new PartyVenue(name,stage,bar,food,security,price,level);
					break;
				}

				case 'S':
				{
					System.out.println("Enter Venue Name:");
					String name = scan.next();

					System.out.println("Enter Competitor Area Size:");
					double competitor = Double.parseDouble(scan.next());

					System.out.println("Enter Spectator Area Size:");
					double spectator = Double.parseDouble(scan.next());
					
					System.out.println("Enter Venue price:");
					double price = Double.parseDouble(scan.next());

					System.out.println("Enter number of security personell:");
					int security = Integer.parseInt(scan.next());

					System.out.println("Enter a venue level between either 1,2 or 3 :");
					int level = Integer.parseInt(scan.next());

					v = new SportsVenue(name,competitor,spectator,security,price,level);
					break;
				}

				case 'T':
				{
					System.out.println("Enter Venue Name:");
					String name = scan.next();

					System.out.println("Enter Instructor Area Size:");
					double instructor = Double.parseDouble(scan.next());

					System.out.println("Enter Other Area Size:");
					double other = Double.parseDouble(scan.next());
					
					System.out.println("Enter Venue price:");
					double price = Double.parseDouble(scan.next());

					System.out.println("Enter a venue level between either 1,2 or 3 :");
					int level = Integer.parseInt(scan.next());

					v = new TrainingVenue(name, instructor, other, price, level);
					break;

				}

				

			}

		}
		return v;
	}

	public int findVenue(ArrayList<Venue> vens, int vid)
	{
		int vdx=-1;
		int currdx=0;
		while ((currdx<vens.size())&&(vdx==-1))
		{
			if (vens.get(currdx).getId()==vid)
				vdx = currdx;
			currdx++;

		}

		

		return vdx;

	}



}

