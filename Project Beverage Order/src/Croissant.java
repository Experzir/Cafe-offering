import javax.swing.JOptionPane;

public class Croissant extends Beverage {
	private String Croissant;
	String[] TypeCroissant = {"Condensed milk","Chocolate","Green tea"};

	public Croissant(String size,int amount,Frame f) {
		super(size,amount);
		Croissant = (String) JOptionPane.showInputDialog(f,"Select a Type of Croissant.","Croissant",
				JOptionPane.QUESTION_MESSAGE,null,TypeCroissant,TypeCroissant[0]);
		double price;
		if(size.equals("Small")) price=25;
		else if(size.equals("Medium")) price=30;
		else price=35;
		if(Croissant.equals("Condensed milk")) price*=1;
		else if(Croissant.equals("Chocolate")) price*=1.25;
		else if(Croissant.equals("Green tea")) price*=1.25;
		setPrice(price);
	}
	@Override
	public String toString() {
		return super.toString()+Croissant+" Croissant";
	}
}