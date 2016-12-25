package asgn4;


public class PopVoteStrategy1 implements VotesPopular {
	private Integer totalVotes;
	private Integer votedRepublican;
	private Integer votedDemocratic;

	
	public PopVoteStrategy1(ElectionData eData)
	{
		this.totalVotes = eData.getTotalVotes();
		this.votedRepublican = eData.getRepublicanVotes();
		this.votedDemocratic = eData.getDemocraticVotes();		
	}
	
	@Override
	/*There is a Republican favoring strategy that reports 5% fewer 
	 * of the Democrat votes in all states
	 */
	public void popVote()
	{
		//reports 5% fewer democratic votes
		float percentD = (votedDemocratic * 100 / totalVotes) - 5;
		float percentR = (votedRepublican * 100 /totalVotes);
		
		StringBuilder p = new StringBuilder();
		p.append("GIVEN THE LATEST POLLS, OUR PREDICTION IS: ");
	
		if (percentR - percentD  ==1)
		{
			p.append("\nToo close to call");			
		}
		else{
		if (percentD > percentR){
			p.append("\nThe Democrats will win with ").append(percentD).append(" % of the vote.");
		}
		if (percentR > percentD)
		{
			p.append("\nThe Republicans will win with ").append(percentR).append(" % of the vote.");
		}
		}
		System.out.println(p.toString());

	}

}
