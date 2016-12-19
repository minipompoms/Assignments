package asgn5;

public class A extends TagDecorator{

	Text text;
	Text a;
	String x;
	
	public A(Text text)
	{
		this.text = text;
	}
	
	public A(String x, Text text)
	{
		this.text = text;
		this.x = x;
	}
	
	public A(Text a, Text text)
	{
		this.text = text;
		this.a = a;
	}
	
	@Override
	public String getHTMLformat(String line) 
	{
		String newTag = null;
		if (a != null){
			newTag = "<a href= "+ a.getHTMLtag().substring(1);
			return newTag+ text.getHTMLformat(line) + "</a>";
		}
		if (x != null)
		{
			newTag = "<a href= "+ x;
			return newTag+ text.getHTMLformat(line) + "</a>";

		}
		else
			return "<a>" + text.getHTMLformat(line) + "</a>";
		
	}
	
	
	@Override
	public String getHTMLtag() 
	{
		return text.getHTMLtag() +"<a>";
	}
	/*@Override
	public String getAttributeID() {
		// TODO Auto-generated method stub
		return "<a>";
	}*/

}
