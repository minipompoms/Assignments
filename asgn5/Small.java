package asgn5;

public class Small extends TagDecorator{
	Text text;
	
	public Small(Text text)
	{
		this.text = text;
	}
	

	@Override
	public String getHTMLtag() 
	{
		
		return text.getHTMLtag() +"<small>";
	}

	@Override
	public String getHTMLformat(String line) 
	{
		return  "<small>"+ text.getHTMLformat(line)+"</small>";
	}


	/*@Override
	public String getAttributeID() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
