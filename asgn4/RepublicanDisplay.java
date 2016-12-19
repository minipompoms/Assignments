package asgn4;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class RepublicanDisplay implements Observer, DisplayElement{
	//Strategy NO 1
	private Integer totalVotes;
	private Integer votedRepublican;
	private Integer votedDemocratic;
	private ArrayList<String> states;
	private ArrayList<Integer> republican;
	private ArrayList<Integer> democrat;
	private String legalMsg;
	
	//constructor
	public RepublicanDisplay(Observable o)
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
		float percentD = (votedDemocratic * 100 / totalVotes) - 5;//reports 5% fewer democratic votes
		float percentR = (votedRepublican * 100 /totalVotes);
		
		StringBuilder p = new StringBuilder();
		p.append("\tCURRENT POPULAR VOTE RESULTS:");
	
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
		ArrayList<Integer>newRep = new ArrayList<>();
		e.append("\n\n\tCURRENT ELECTORAL COLLEGE RESULTS:\n");
		for (int x = 0; x < states.size(); x++)
			e.append(states.get(x)+"\t");
		e.append("\n");
		for (int i = 0; i < republican.size(); i++){
			
			newRep.add(republican.get(i));
			//multiplies the republican vote count on first state by 1.5 if the results 
			//do not fit their agenda
			Integer multiplyResult =(int) (republican.get(0) * 1.5);
			if (republican.get(0)<= democrat.get(0))
				
			newRep.set(0, multiplyResult);
			
			e.append(newRep.get(i) +"\t ");
		}
		e.append("<--Number of Republican votes counted\n");
		for (int j = 0; j < democrat.size(); j++)
		{
			e.append(democrat.get(j) +"\t ");
		}
		e.append("<--Number of Democrat votes counted\n");

		e.append("\n").append(legalMsg).append("\n");
		System.out.println(e.toString());
	}

}
