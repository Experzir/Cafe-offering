import javax.swing.JOptionPane;

public class Fruity extends Beverage {
	private String fruit;
	String[] fruits = {"Apple","Orange","Pineapple"};

	public Fruity(String size,int amount,Frame f) {
		super(size,amount);
		try {
			fruit = (String) JOptionPane.showInputDialog(f,"Select a fruit.","Select a fruit",
					JOptionPane.QUESTION_MESSAGE,null,fruits,fruits[0]);
			double price;
			if(size.equals("Small")) price=20;
			else if(size.equals("Medium")) price=25;
			else price=30;
			setPrice(price);
		}
		catch(NullPointerException e) {
		}
	}
	@Override
	public String toString() {
		return super.toString()+fruit+" Fruity";
	}
}