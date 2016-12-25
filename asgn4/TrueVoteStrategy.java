package asgn4;

import java.util.ArrayList;

public class TrueVoteStrategy implements VotesPopular, VotesElectoral{

	private Integer totalVotes;
	private Integer votedRepublican;
	private Integer votedDemocratic;
	private ArrayList<String> states;
	private ArrayList<Integer> republican;
	private ArrayList<Integer> democrat;
	
	public TrueVoteStrategy(ElectionData eData)
	{
		this.totalVotes = eData.getTotalVotes();
		this.votedRepublican = eData.getRepublicanVotes();
		this.votedDemocratic = eData.getDemocraticVotes();
		this.states = eData.getStates();
		this.republican = eData.getRepublican();
		this.democrat = eData.getDemocrat();
	}
	/*There is a completely honest strategy that reports the 
	 * results exactly as the observer conveyed 
	 * to them.
	 */
	@Override
	public void popVote()
	{	
		StringBuilder p = new StringBuilder();
		p.append("\nCURRENT POPULAR VOTE RESULTS:\n\n");
	
		StringBuilder prediction = new StringBuilder();
		float percentD =  (votedDemocratic * 100 / totalVotes);
		float percentR = (votedRepublican * 100 /totalVotes);	
		p.append("A total of ").append(totalVotes).append(" have been cast.\n");
		p.append(votedDemocratic).append(" voted for the Democratic candidate...\t"
				+ "giving them "+percentD+ "% of the vote.\n");
		p.append(votedRepublican).append(" voted for the Republican candidate...\t"
				+ "giving them "+percentR+ "% of the vote.\n");
		
		prediction.append("GIVEN THE LATEST POLLS, OUR PREDICTION IS... ");
		
		if (percentD - percentR ==1 || percentR - percentD ==1 )
		{
			prediction.append("\tToo close to call");
			
		}
		else{
		if (percentD > percentR){
			prediction.append("\tThe Democrats are in the lead with ").append(percentD).append(" % of the vote.");
		}
		if (percentR > percentD)
		{
			prediction.append("\tThe Republicans are in the lead with ").append(percentR).append(" % of the vote.");
		}
		}
		System.out.println(prediction.toString());
		System.out.println(p.toString());
		
	}

	/*There is a completely honest strategy that reports the exact standings 
	 * as conveyed by the observable.
	 */
	public void eVote()
	{
		StringBuilder e = new StringBuilder();
		ArrayList<String>predictions = new ArrayList<>();

		e.append("\n\nCURRENT ELECTORAL COLLEGE RESULTS:\n\n");
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
		
		for (int x = 0; x < republican.size(); x++)
		{
			
			if (republican.get(x).equals(democrat.get(x)))
			{
				predictions.add(x, "**");
			}			
			if (republican.get(x)>democrat.get(x))
					
				predictions.add(x, " R");
			
			if(democrat.get(x)> republican.get(x))
			
				predictions.add(x, " D");
	
			e.append(" "+ predictions.get(x) +"\t");

		}
		e.append(" <-- OUR LATEST PREDICTION...");	
		e.append("\n");
		e.append("\n**A state marked with an asterisk is currently too close to call.. ");
		System.out.println(e.toString());
	}

	public void display()	{}

	
	

}
