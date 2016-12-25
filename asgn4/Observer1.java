package asgn4;

import java.util.Observable;
import java.util.Observer;

public class Observer1 extends DisplayElement implements Observer{
	/*One that favors the Republican using appropriate strategies 
	 * of your choice from above
	 */

	public Observer1(Observable o, ElectionData eData)
	{
		o.addObserver(this);
		pVotes = new PopVoteStrategy1(eData);
		eVotes = new EVoteStrategy2(eData);
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
		System.out.println("\nThe results displayed on this page may, or may not, be accurate."
				+ " View at your own risk.\n");
	}

}
