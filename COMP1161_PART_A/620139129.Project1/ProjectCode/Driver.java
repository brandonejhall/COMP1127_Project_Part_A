//package project;
import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Promoter> promoters = new ArrayList<Promoter>();
		Ministry mny = new Ministry("HEALTH",2 );
		Venue[] venues = populateVenues(mny);
		Promoter p1 = new Promoter("Pro1",10000,mny,venues);
		Promoter p2 = new Promoter("Pro2",50000,mny, venues);
		Promoter p3 = new Promoter("Pro3",60000,mny,venues);
		Promoter p4 = new Promoter("Pro4",20000,mny,venues);
		Promoter p5 = new Promoter("Pro5",72500,mny,venues);
		promoters.add(p1);
		promoters.add(p2);
		promoters.add(p3);
		promoters.add(p4);
		promoters.add(p5);

		int testDays=5;

		for (int i=0; i< testDays;i++)
		{
			for(Promoter prom:promoters)
			{
				int approvalId=-1;
				
				System.out.println("======================================");
				System.out.println(prom.getName()+ "[$"+prom.getBudget()+"] planning a party with 20 people on day "+ (i+1));
				if ((approvalId=prom.planEvent(20, "PARTY",new Date(i+1)))>=0)
					System.out.println("Approval Certificate #"+approvalId + " granted to "+prom.getName() + " for event");
				else
					System.out.println("Didn't work out");
				System.out.println("--------------------------------------");
				System.out.println("======================================");
				System.out.println(prom.getName()+ "[$"+prom.getBudget()+"] planning a party with 500 people");
				if ((approvalId=prom.planEvent(200, "PARTY",new Date(i+2)))>=0)
					System.out.println("Approval Certificate #"+approvalId + " granted to "+prom.getName() + " for event");
				else
					System.out.println("Didn't work out");
				System.out.println("--------------------------------------");
				System.out.println("======================================");
				System.out.println(prom.getName()+ "[$"+prom.getBudget()+"] planning a training event with 10 people on day "+ (i+5));
				if ((approvalId=prom.planEvent(10, "TRAINING",new Date(i+3)))>=0)
					System.out.println("Approval Certificate #"+approvalId + " granted to "+prom.getName() + " for event");
				else
					System.out.println("Didn't work out");
				System.out.println("--------------------------------------");
				System.out.println("======================================");
				System.out.println(prom.getName()+ "[$"+prom.getBudget()+"] planning a sports event with 20 competitors and 10 others on day "+ (i+5));
				if ((approvalId=prom.planEvent(30, "SPORT",new Date(i+4)))>=0)
					System.out.println("Approval Certificate #"+approvalId + " granted to "+prom.getName() + " for event");
				else
					System.out.println("Didn't work out");
								
				System.out.println("--------------------------------------");
			}

		}
		//mny.showEvents();
		for (Venue v:venues )
			v.promoteEvents();


	}

	public static  Venue[] populateVenues(Ministry mny)
	{
		Venue [] venues = new Venue[8];
		venues[0] = new Venue("VEN_SML",200, 100,  2);
		venues[1] = new Venue("VEN_BIG", 20000, 850, 2);
		venues[2] = new PartyVenue("PRTY_SML",150,100,100, 5, 1000, 2);
		venues[3] = new PartyVenue("PRTY_BIG",15000,1000,500, 12, 5000, 2);
		venues[4] = new SportsVenue("SPT_SML",150,100, 3, 1000,  1);
		venues[5] = new SportsVenue("SPT_BIG",30000,10000, 12, 5000, 2);
		venues[6] = new TrainingVenue("TRN_SML",200, 2000, 500,  2);
		venues[7] = new TrainingVenue("TRN_BIG",1000, 25000, 4000, 2);


		return venues;

	}


}