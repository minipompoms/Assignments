package asgn4;

import java.util.ArrayList;

public class EVoteStrategy3 implements VotesElectoral{


	private ArrayList<String> states;
	private ArrayList<Integer> republican;
	private ArrayList<Integer> democrat;
	
	public EVoteStrategy3(ElectionData eData)
	{
		
		this.states = eData.getStates();
		this.republican = eData.getRepublican();
		this.democrat = eData.getDemocrat();
	}
	
	public void eVote()
	{
		//There is a Democrat favoring strategy that 
		//assumes that the state with the most electoral votes  
		//will go to the Democrat regardless of polling data
		
		/* Note: By definition the state with the most electoral
		 * votes is CA, with 55. On the other hand, it's possible
		 * you meant the one state of the 5 with the most. 
		 * So after contemplating for a while, I was still not sure, 
		 * and so I decided to hard code CA. I hope that this is okay.
		 */
		ArrayList<String>predictions = new ArrayList<>();
		
		StringBuilder e = new StringBuilder();
		e.append("\n\nELECTORAL COLLEGE RESULTS:\n\n");
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
			if (states.get(x).equalsIgnoreCase(" CA(55)")){
				predictions.add(x, " D");
			}
		
			if (republican.get(x)> democrat.get(x) &&
					!states.get(x).equalsIgnoreCase(" CA(55)"))
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
