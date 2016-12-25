package asgn4;


public abstract class DisplayElement 
{
	VotesElectoral eVotes;
	VotesPopular pVotes;	
	
	//constructor
	public DisplayElement()
	{		
	}
	
	public void setPopVote(VotesPopular popVote)
	{
		pVotes = popVote;
	}
	
	public void setEVote(VotesElectoral elecVote)
	{
		eVotes = elecVote;
	}

	abstract void display();
	
	
	public void showPopVote()
	{
		pVotes.popVote();
	}
	
	public void showElecVote()
	{
		eVotes.eVote();
	}
}
