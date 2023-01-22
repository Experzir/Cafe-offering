import javax.swing.JOptionPane;

public class Cake extends Beverage {
	private String Cake;
	String[] TypeCake = {"Chocolate","Strawberry","Green tea","Thai tea"};

	public Cake(String size,int amount,Frame f) {
		super(size,amount);
		Cake = (String) JOptionPane.showInputDialog(f,"Select a Type of Cake.","Cake",
				JOptionPane.QUESTION_MESSAGE,null,TypeCake,TypeCake[0]);
		double price;
		if(size.equals("Small")) price=30;
		else if(size.equals("Medium")) price=35;
		else price=40;
		if(Cake.equals("Chocolate")) price*=1;
		else if(Cake.equals("Strawberry")) price*=1;
		else if(Cake.equals("Green tea")) price*=1.25;
		else if(Cake.equals("Thai tea")) price*=1.25;
		setPrice(price);
	}
	@Override
	public String toString() {
		return super.toString()+Cake+" Cake";
	}
}