package asgn4;


import java.util.Observable;
import java.util.Observer;

public class Observer3 extends DisplayElement implements Observer{
	
	/*One that tries to make it look like the Democrats 
	 * will win the popular vote but the Republicans will win 
	 * the electoral college.
	 */
	
	public Observer3(Observable o, ElectionData eData)
	{
		o.addObserver(this);
		pVotes = new PopVoteStrategy2(eData);
		eVotes = new EVoteStrategy1(eData);
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
