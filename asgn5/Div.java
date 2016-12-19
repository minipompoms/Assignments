package asgn5;

public class Div extends Text {


	public Div()
	{
		text = "div";
		
	}
	

	
	public String getHTMLtag() {
		return "<div>";
	}
	
 public String getHTMLformat(String line) {
		
		return "<"+text+">"+ line + "</"+text+">";
	}
/*@Override
public String getAttributeID() {
	// TODO Auto-generated method stub
	return null;
}*/
}
