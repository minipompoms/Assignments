package asgn4;

import java.util.ArrayList;

public class EVoteStrategy1 implements VotesElectoral{

	
	private ArrayList<String> states;
	private ArrayList<Integer> republican;
	private ArrayList<Integer> democrat;
	
	public EVoteStrategy1(ElectionData eData)
	{
	
		this.states = eData.getStates();
		this.republican = eData.getRepublican();
		this.democrat = eData.getDemocrat();
	}
	
	/*There is a Republican favoring strategy that assumes one of the 
	 * states (always the same one, this should be hard coded in) will 
	 * go Republican regardless of the polling data
	 */
	
	public void eVote()
	{
		StringBuilder e = new StringBuilder();
		
		ArrayList<String>predictions = new ArrayList<>();
		e.append("\n\nELECTORAL COLLEGE RESULTS:\n");
		for (int x = 0; x < states.size(); x++)
			e.append(states.get(x)+"\t");
		e.append("\n");
		
		for (int i = 0; i < republican.size(); i++){
			
			e.append(republican.get(i) +"\t ");	
		}
		
		e.append("<--Number of Republican votes counted\n");
		for (int j = 0; j < democrat.size(); j++)
		{
			e.append(democrat.get(j) +"\t ");

		}
		e.append("<--Number of Democrat votes counted\n");	
		
		predictions.add(0, " R");
		e.append(" " +predictions.get(0) +"\t");
		for (int x = 1; x < republican.size(); x++)
		{
			if (republican.get(x)<= democrat.get(x))
			{
				predictions.add(x, " D");
			}
			else {
				predictions.add(x, " R");
			}
			e.append(" "+ predictions.get(x) +"\t");

		}
		e.append(" <-- OUR LATEST PREDICTION...");	

		e.append("\n");
		System.out.println(e.toString());
	}

}
