package asgn5;

public class Strong extends TagDecorator {
	Text text;

	public Strong(Text text)
	{
		this.text = text;
	}
	
	
	public String getHTMLformat(String line)
	{
		return "<strong>" + text.getHTMLformat(line) + "</strong>";
	}

	@Override
	public String getHTMLtag() 
	{
		return text.getHTMLtag() +"<strong>";
	}


	/*@Override
	public String getAttributeID() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
