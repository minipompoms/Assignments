package asgn5;

public class P extends Text{

	public P()
	{
		text = "p";
	}

	@Override
	public String getHTMLtag() 
	{		
		return "<p>";
	}
	
	public String getHTMLformat(String line) 
	{
		return "<"+text+">" + line + "</"+text+">";
	}

	/*@Override
	public String getAttributeID() {
		// TODO Auto-generated method stub
		return null;
	}*/
}
