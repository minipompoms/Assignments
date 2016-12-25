//PULL
package asgn4;

import java.util.ArrayList;
import java.util.Observable;

public class ElectionData extends Observable {
	private ArrayList<Integer> republican;
	private ArrayList<Integer> democrat;
	private ArrayList<String> states;
	private Integer totalVotes;
	private Integer votedRepublican;
	private Integer votedDemocratic;
	
	public ElectionData()	{}


	public void resultsChanged()
	{
		setChanged();
		notifyObservers();
	}
	
	public void setMeasurements(ArrayList<Integer> republican, ArrayList<String> states,
			 ArrayList<Integer>democrat,Integer totalVotes, 
			 Integer votedRepublican, Integer votedDemocratic)
	{
		this.republican = republican;
		this.states = states;
		this.democrat = democrat;
		this.totalVotes = totalVotes;
		this.votedRepublican = votedRepublican;
		this.votedDemocratic = votedDemocratic;
 		resultsChanged();
	}
	
	

	public ArrayList<String> getStates()
	{
		return states;
	}
	
	public ArrayList<Integer> getRepublican() {
		return republican;
	}
	
	public ArrayList<Integer> getDemocrat() {
		return democrat;
	}
	
	public Integer getRepublicanVotes()
	{
		return votedRepublican;
	}
	
	public Integer getDemocraticVotes()
	{
		return votedDemocratic;
	}
	
	public Integer getTotalVotes()
	{
		return totalVotes;
	}
	
	
}
