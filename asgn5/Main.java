package asgn5;

public class Main  {
	public static void main (String [] args)
	{
		String site = "Touro";
		String address = "www.touro.edu";
		
		
		
		String v = "header";
		
		Text x = new Div();
		x = new Strong(x);
		x = new A(address, x);
		
		x = new I(x);
		System.out.println(x.getHTMLformat(site));

		Text j = new P();
		j = new H(3);
		j = new A(j);
		System.out.println(j.getHTMLformat(v));
		

		Text t = new P();
		t = new U(t);
		t = new Strong(t);
		t = new Em(t);
		System.out.println(t.getHTMLformat(v));

		Input i = new Input();
		String type= i.setAttributeType("type=\"button\"");
		String value = i.setAttributeValue("value=\"action\"");
		String event = i.setAttributeEvent("onclick=\"javascript:alert('action')\"");
		Text p = new Input(type, event, value);
		p = new Small(p);
		p = new Em(p);
		System.out.println(p.getHTMLformat(""));
	}

	
	
}
