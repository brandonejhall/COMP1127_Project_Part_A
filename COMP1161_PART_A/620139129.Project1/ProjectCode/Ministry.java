import java.util.ArrayList;

class Ministry
 {

    private String name;
    private final int LOWRISK_DAILYMAX =5000;
    private final int MEDIUMRISK_DAILYMAX =500;
    private final int HIGHRISK_DAILYMAX =0;

    public static final int LOWRISK_SEPARATION = 3;
    public static final int MEDIUMRISK_SEPARATION = 6;
    public static final int HIGHRISK_SEPARATION  =50;

    private enum Level{low, medium, high};

    private int alertLevel;

    private ArrayList<ApprovalRequest> approvedRequests = new ArrayList<ApprovalRequest>();
    
    private int max;
    private int day;
    private int appPatrons;
    private int seperation;
    
    public Ministry(String name, int level) {
        this.name=name;
        alertLevel=level;
    }
    
    public int checkApproval(ApprovalRequest ar)

    {
     
        switch (alertLevel) {
            case 1:
                max=LOWRISK_DAILYMAX;
                seperation=LOWRISK_SEPARATION;
                break;
            case 2:
                max=MEDIUMRISK_DAILYMAX;
                seperation=MEDIUMRISK_SEPARATION;
                break;
            case 3:
                max=HIGHRISK_DAILYMAX;        
                seperation=HIGHRISK_SEPARATION;
        }
        
        day=ar.getEvent().getDate().getDay();
        
        for (ApprovalRequest appa:approvedRequests) {
            if (appa.getEvent().getDate().getDay()==day) {
                appPatrons=appa.getEvent().getNumPeople();
                //appPatrons+=ar.getEvent().getNumPeople();
            }        
        }
        
        if (appPatrons+ar.getEvent().getNumPeople()>max)
            return 1;
        
        if ((ar.getVenue().getSize()/seperation)>=appPatrons) {
            return ar.getId();
        }
        else {return -1;}        
    }
    
 }