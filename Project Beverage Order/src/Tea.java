import javax.swing.JOptionPane;

public class Tea extends Beverage {
	private String Tea;
	String[] TypeTea = {"Thai tea","Green tea","Black tea","Tea"};
	
	public Tea(String size,int amount,Frame f) {
		super(size,amount);
		Tea = (String) JOptionPane.showInputDialog(f,"Select a Type of Tea.","Tea",
				JOptionPane.QUESTION_MESSAGE,null,TypeTea,TypeTea[0]);;
		double price;
		if(size.equals("Small")) price= 15;
		else if(size.equals("Medium")) price=20.0;
		else price=25;
		if(Tea.equals("Thai tea")) price*=1.25;
		else if(Tea.equals("Green tea")) price*=1.25;
		else if(Tea.equals("Black tea")) price*=1.25;
		else if(Tea.equals("Tea")) price*=1.0;
		
		setPrice(price);
	}
	@Override
	public String toString() {
		return super.toString()+Tea+"Tea";
	}
}