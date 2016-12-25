package asgn4;

import java.util.ArrayList;
import java.util.Collections;

public class EVoteStrategy2 implements VotesElectoral{
	
	
	private ArrayList<String> states;
	private ArrayList<Integer> republican;
	private ArrayList<Integer> democrat;
	
	public EVoteStrategy2(ElectionData eData)
	{
		this.states = eData.getStates();
		this.republican = eData.getRepublican();
		this.democrat = eData.getDemocrat();
	}
	/*There is a second Republican favoring strategy 
	 * that considers the state where the Democrat has 
	 * the smallest lead to be "too close to call" and splits 
	 * the electoral votes giving half to the Democrat and half 
	 * to the Republican(and in the event of an odd number it 
	 * gives the extra vote to the Republican of course)
	 */
	public void eVote()
	{

		StringBuilder e = new StringBuilder();
		ArrayList<String>predictions = new ArrayList<>();
		ArrayList<Integer>min = new ArrayList<>();
		ArrayList<Integer>elecVotes = new ArrayList<>();
		String value;
		Integer number =0; 
		e.append("\n\nCURRENT ELECTORAL COLLEGE RESULTS:\n\n");
		for (int x = 0; x < states.size(); x++)
			
			e.append(states.get(x)+"\t");
		 	
		e.append("\n");
		//gets the electoral vote count from states array list
		for (int v = 0; v < states.size(); v++)
		{
			value = states.get(v).substring(4, 6);
			value = value.replace(" ", "");
			 number = Integer.parseInt(value);
			elecVotes.add(v, number);			
		}
		for (int i = 0; i < republican.size(); i++){
			e.append(republican.get(i) +"\t ");
		}
		e.append("<--Number of Republican votes counted \n");
		for (int j = 0; j < democrat.size(); j++)
		{
			e.append(democrat.get(j) +"\t ");
		}
		e.append("<--Number of Democrat votes counted\n");
		
		for (int z = 0; z < democrat.size(); z++)
		{
			
			if (democrat.get(z) > republican.get(z)){
			min.add(z, (democrat.get(z) - republican.get(z)));
		
			}
			else 
				min.add(Integer.MAX_VALUE);
			
		}
		int minIndex = min.indexOf(Collections.min(min));
		
		Integer eVotePrediction = elecVotes.get(minIndex) /2;
		for (int x = 0; x < republican.size(); x++)
		{

			if (x == minIndex || republican.get(x)>= democrat.get(x) )
			{
				predictions.add(x, " R");
			}
			else {
				predictions.add(x, " D");
			}
			e.append(" "+ predictions.get(x) +"\t");
			if (predictions.get(x).equals(" R")){
				eVotePrediction += elecVotes.get(x);
				
			}
		}
		
		String party = "REPUBLICAN";
		if (eVotePrediction < 0)
			party = "DEMOCRATS";
		e.append(" <-- OUR LATEST PREDICTION HAS THE "
			+ party + " in the lead by " +eVotePrediction +" votes...");	
		e.append("\n");
		System.out.println(e.toString());
		
	}

}
