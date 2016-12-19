package asgn5;

public class I extends TagDecorator
{
	Text text;
	
	public I(Text text)
	{
		this.text = text;
	}

	@Override
	public String getHTMLformat(String line) {
		
		return "<i>" + text.getHTMLformat(line) + "</i>";
	}

	@Override
	public String getHTMLtag() 
	{
		return text.getHTMLtag() +"<i>";
	}

	
	

}
