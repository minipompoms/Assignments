package asgn4;

import java.util.ArrayList;
import java.util.Collections;

public class PopVoteStrategy2 implements VotesPopular{


	private Integer totalVotes;
	private Integer votedRepublican;
	private Integer votedDemocratic;
	private ArrayList<Integer> republican;
	
	public PopVoteStrategy2(ElectionData eData)
	{
		this.totalVotes = eData.getTotalVotes();
		this.votedRepublican = eData.getRepublicanVotes();
		this.votedDemocratic = eData.getDemocraticVotes();
		this.republican = eData.getRepublican();
	}
	/*There is a Democrat favoring strategy that simply ignores 
	 * the state with the most Republican votes in determining 
	 * its total
	 */
	@Override
	public void popVote() 
	{
		Integer ignoredVotes = Collections.max(republican);
		StringBuilder p = new StringBuilder();
		p.append("\nCURRENT POPULAR VOTE RESULTS:\n\n");
		//no need to display total votes as if it does, it will display a blatant discrepancy
		votedRepublican -= ignoredVotes;
		p.append(votedDemocratic).append(" voted for the Democratic candidate.\n");
		p.append(votedRepublican).append(" voted for the Republican candidate.\n");
		StringBuilder prediction = new StringBuilder();
		float percentD =  (votedDemocratic * 100 / totalVotes);
		float percentR = (votedRepublican * 100 /totalVotes);	
		prediction.append("GIVEN THE LATEST POLLS, OUR PREDICTION IS... ");
		
		if ((percentR - percentD) >=1 )
		{
			prediction.append("\tTOO CLOSE TO CALL");			
		}
		else{
		if (percentD > percentR){
			prediction.append("\tThe Democrats will win with ").append(percentD).append(" % of the vote.");
		}
		if (percentR > percentD)
		{
			prediction.append("\tThe Republicans will win with ").append(percentR).append(" % of the vote.");
		}
		}
		System.out.println(prediction.toString());
		System.out.println(p.toString());
		
	}

	

}
