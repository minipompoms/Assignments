package asgn5;

public class U extends TagDecorator{
	Text text;
	
	public U(Text text)
	{
		this.text = text;
	}
	
	@Override
	public String getHTMLtag() 
	{
		return text.getHTMLtag() + "<u>";
	}
	
	@Override
	public String getHTMLformat(String line) 
	{
		return "<u>" + text.getHTMLformat(line) + "</u>";
	}

	/*@Override
	public String getAttributeID() {
		// TODO Auto-generated method stub
		return null;
	}*/
	

}
