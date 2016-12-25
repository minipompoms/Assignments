//Paige Kohn 
package asgn4;

import java.util.ArrayList;
import java.util.Observable;

public class Main {

	public static void main (String [] args)
	{

		Observable newObserver = new Observable();
		ElectionData eData = getElectionData();
		DisplayElement trueObserver = new Observer5(newObserver, eData);

		trueObserver.showPopVote();
		trueObserver.showElecVote();
		
		DisplayElement demObserver = new Observer3(newObserver, eData);

		
		demObserver.showElecVote();
		demObserver.setPopVote(new PopVoteStrategy1(eData));
		demObserver.showPopVote();
	
		
	}

	public static ElectionData getElectionData()
	{
		ElectionData eData = new ElectionData();
		ArrayList<String> states = new ArrayList<String>();
		ArrayList<Integer> republican = new ArrayList<>();
		ArrayList<Integer> democrat = new ArrayList<>();
		democrat.add(0, 251006);
		democrat.add(1, 515044);
		democrat.add(2, 658082);
		democrat.add(3, 454556);
		democrat.add(4, 518123);
		
		republican.add(0, 345512);
		republican.add(1, 579087);
		republican.add(2, 494033);
		republican.add(3, 450233);
		republican.add(4, 518123);
		
		states.add(" HI 4 ");
		states.add(" NY 29");
		states.add(" CA 55");
		states.add(" CO 9 ");
		states.add(" AZ 11");
		
		Integer rVoteCount = 0;
		Integer dVoteCount = 0;		
		for (int i = 0; i <republican.size(); i++)
		{
			rVoteCount += republican.get(i);
			dVoteCount += democrat.get(i);
		}
		Integer totalVotes = rVoteCount + dVoteCount;
		eData.setMeasurements(republican, states, democrat, totalVotes, rVoteCount, dVoteCount);
		
		return eData;

		
	}
		
	}

	