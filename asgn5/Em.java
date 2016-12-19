package asgn5;

public class Em extends TagDecorator {
	Text text;

	public Em(Text text)
	{
		this.text = text;
	}
	
	@Override
	public String getHTMLtag() {
		
		return text.getHTMLtag() +"<em>";
	}
	
	@Override
	public String getHTMLformat(String line)
	{
		return "<em>" + text.getHTMLformat(line) + "</em>";
	}

	/*@Override
	public String getAttributeID() {
		// TODO Auto-generated method stub
		return null;
	}*/


}
