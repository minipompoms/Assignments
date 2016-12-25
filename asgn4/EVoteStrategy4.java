package asgn4;

import java.util.ArrayList;

public class EVoteStrategy4 implements VotesElectoral{

	
	private ArrayList<String> states;
	private ArrayList<Integer> republican;
	private ArrayList<Integer> democrat;
	
	public EVoteStrategy4(ElectionData eData)
	{
		
		this.states = eData.getStates();
		this.republican = eData.getRepublican();
		this.democrat = eData.getDemocrat();
	}
	
	//There is a Democrat favoring strategy that
	//takes 2% of all Republican votes in every state & 
	//makes them Democrat votes instead
	public void eVote()
	{
		StringBuilder e = new StringBuilder();
		ArrayList<Integer>newRep = new ArrayList<Integer>();
		ArrayList<Integer>newDem = new ArrayList<Integer>();
		ArrayList<String>predictions = new ArrayList<>();

		e.append("\n\nELECTORAL COLLEGE RESULTS:\n");
		for (int x = 0; x < states.size(); x++)
			e.append(states.get(x)+"\t");
		e.append("\n");
		for (int i = 0; i < republican.size(); i++){
			Integer rVote= republican.get(i);
			rVote = rVote - (rVote *2) /100;
			newRep.add(i, rVote);
			e.append(newRep.get(i) +"\t ");
		}
		e.append("<--Number of Republican votes counted\n");
		for (int j = 0; j < democrat.size(); j++)
		{
			Integer dVote = democrat.get(j);
			dVote = dVote + (dVote *2) /100;
			newDem.add(j, dVote);
			e.append(newDem.get(j) +"\t ");
		}
		e.append("<--Number of Democrat votes counted\n");
		
		e.append(" " +predictions.get(0) +"\t");
		for (int x = 0; x < republican.size(); x++)
		{
			if (republican.get(x)>= democrat.get(x))
			{
				predictions.add(x, " R");
			}
			else {
				predictions.add(x, " D");
			}
			e.append(" "+ predictions.get(x) +"\t");

		}
		e.append(" <-- OUR LATEST PREDICTION...");	

		e.append("\n");
		System.out.println(e.toString());
	}
	
}


