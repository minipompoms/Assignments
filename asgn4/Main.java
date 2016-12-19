//Paige Kohn 
package asgn4;

import java.util.ArrayList;

public class Main {

	public static void main (String [] args)
	{

		ElectionData electionData = new ElectionData();
		TrueDisplay trueObserver = new TrueDisplay(electionData);
		//RepublicanDisplay republicanDisplay = new RepublicanDisplay(electionData);
		//DemocratElectoralDisplay democratDisplay = new DemocratElectoralDisplay(electionData);
		//DemocratDisplay dDisplay = new DemocratDisplay(electionData);
		ArrayList<String> states = new ArrayList<String>();
		ArrayList<Integer> republican = new ArrayList<>();
		String legalMsg = "The results displayed on this page may, or may not, be accurate. View at your own risk.";
		ArrayList<Integer> democrat = new ArrayList<>();
		democrat.add(0, 251006);
		democrat.add(1, 515044);
		democrat.add(2, 658082);
		democrat.add(3, 454556);
		democrat.add(4, 459400);
		
		republican.add(0, 345512);
		republican.add(1, 579087);
		republican.add(2, 494033);
		republican.add(3, 450033);
		republican.add(4, 518123);
		
		states.add("HI (4)");
		states.add("NY (29)");
		states.add("CA (55)");
		states.add("CO (9)");
		states.add("AZ (11)");
		
		Integer rVoteCount = 0;
		Integer dVoteCount = 0;		
		for (int i = 0; i <republican.size(); i++)
		{
			rVoteCount += republican.get(i);
			dVoteCount += democrat.get(i);
		}
		Integer totalVotes = rVoteCount + dVoteCount;
		electionData.setMeasurements(republican, states, democrat, totalVotes, rVoteCount, dVoteCount,  legalMsg);

		
	}	
		
	}

	