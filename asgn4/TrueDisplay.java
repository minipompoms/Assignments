package asgn4;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
//Strategy NO 5
public class TrueDisplay implements Observer, DisplayElement{
	
	private Integer totalVotes;
	private Integer votedRepublican;
	private Integer votedDemocratic;
	private ArrayList<String> states;
	private ArrayList<Integer> republican;
	private ArrayList<Integer> democrat;

	private String legalMsg;

	public TrueDisplay(Observable o)
	{	
		o.addObserver(this);
	}
	
	@Override
	public void update(Observable observable, Object stateObject) 
	{
		if(observable instanceof ElectionData)
		{
			ElectionData eData = (ElectionData) observable;
			this.republican = eData.getRepublican();
			this.democrat = eData.getDemocrat();
			this.states = eData.getStates();
			this.totalVotes = eData.getTotalVotes();
			this.votedDemocratic = eData.getDemocraticVotes();
			this.votedRepublican = eData.getRepublicanVotes();
			this.legalMsg = eData.getLegalMsg();
			displayPopVote();
			displayElecVote();
			
		}
	}

	
	public void displayPopVote()
	{
		float percentD =  (votedDemocratic * 100 / totalVotes);
		float percentR = (votedRepublican * 100 /totalVotes);		
		
		StringBuilder p = new StringBuilder();
		p.append("CURRENT POPULAR VOTE RESULTS:\n");
		p.append("A total of ").append(totalVotes).append(" have been cast.\n");
		p.append(votedDemocratic).append(" voted for the Democratic candidate.\n");
		p.append(votedRepublican).append(" voted for the Republican candidate.\n");

		if (percentD - percentR <1 || percentR - percentD <1 )
		{
			p.append("\nToo close to call");
			
		}
		else{
		if (percentD > percentR){
			p.append("\nThe Democrats are in the lead with ").append(percentD).append(" % of the vote.");
		}
		if (percentR > percentD)
		{
			p.append("\nThe Republicans are in the lead with ").append(percentR).append(" % of the vote.");
		}
		}
		System.out.println(p.toString());
		
	}
	
	public void displayElecVote()
	{
		StringBuilder e = new StringBuilder();
		e.append("\n\nCURRENT ELECTORAL COLLEGE RESULTS:\n");
		for (int x = 0; x < states.size(); x++)
			e.append(states.get(x)+"\t");
		e.append("\n");
		for (int i = 0; i < republican.size(); i++){
			e.append(republican.get(i) +"\t ");
		}
		e.append("<--Number of Republican votes counted \n");
		for (int j = 0; j < democrat.size(); j++)
		{
			e.append(democrat.get(j) +"\t ");
		}
		e.append("<--Number of Democrat votes counted\n");

		e.append("\n").append(legalMsg + "\n");
		System.out.println(e.toString());

	}	

}
