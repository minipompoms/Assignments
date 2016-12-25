package asgn4;


import java.util.Observable;
import java.util.Observer;

public class Observer2 extends DisplayElement implements Observer{
	/*One that favors the Democrats using appropriate 
	 * strategies of your choice from above
	 */

	public Observer2(Observable o, ElectionData eData)
	{
		o.addObserver(this);
		pVotes = new TrueVoteStrategy(eData);
		eVotes = new TrueVoteStrategy(eData);		
		display();
	}

	@Override
	public void update(Observable observable, Object stateObject) 
	{
		if(observable instanceof ElectionData)
		{
			ElectionData eData = (ElectionData) observable;
			eData.getRepublican();
			eData.getDemocrat();
			eData.getStates();
			eData.getTotalVotes();
			eData.getDemocraticVotes();
			eData.getRepublicanVotes();		
		}
	}

	
	public void display()
	{
		System.out.println("\nThe results displayed on this page may, or may not, be accurate. "
				+ "View at your own risk.\n");
	}

}
