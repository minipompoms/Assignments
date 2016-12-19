package asgn5;

public class H extends Text{

	
	
	public H(int number)
	{
		
		text = "h" + number;
	}

	@Override
	public String getHTMLtag() 
	{	
		return "<h>";
	}
	
	public String getHTMLformat(String line) 
	{
		return "<"+text +">"+ line + "</"+text+">";
	}
	
	/*@Override
	public String getAttributeID() 
	{
		return "<h>";
	}*/
}
