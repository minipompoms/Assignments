package asgn5;

public class Input extends Text{
	String attType;
	String attEvent;
	String attValue;

	public Input()
	{
		text = "input";
	}
	
	public Input(String attType, String attEvent, String attValue)
	{
		text = "input";
		this.attType = attType;
		this.attEvent = attEvent;
		this.attValue = attValue;
	}

	@Override
	public String getHTMLtag() 
	{		
		return "<input>";
	}
	
	public String getHTMLformat(String line) 
	{
		return "<"+text +" "  
				  +attType+ " "+
				  attValue+ " "+
				  attEvent+ " "+
				line + "></"+text+">";
	}
	
	public String setAttributeType(String type)
	{
		return  type;
	}
	
	public String setAttributeEvent(String event)
	{
		return event;
	}
	
	public String setAttributeValue(String value)
	{
		return  value;
	}

	/*@Override
	public String getAttributeID() {
		// TODO Auto-generated method stub
		return "<input>";
	}*/
	
	
	 
}
