import javax.swing.JOptionPane;
 
public class Coffee extends Beverage {
	private String Coffee;
	String[] TypeCoffee = {"Espresso","Americano","Cappuccino","Mocha","Latte"};

	public Coffee(String size,int amount,Frame f) {
		super(size,amount);
		Coffee = (String) JOptionPane.showInputDialog(f,"Select a Type of Coffee.","Coffee",
				JOptionPane.QUESTION_MESSAGE,null,TypeCoffee,TypeCoffee[0]);
		double price;
		if(size.equals("Small")) price=20;
		else if(size.equals("Medium")) price=25;
		else price=30;
		if(Coffee.equals("Espresso")) price*=1.25;
		else if(Coffee.equals("Americano")) price*=1.25;
		else if(Coffee.equals("Cappuccino")) price*=1.5;
		else if(Coffee.equals("Mocha")) price*=1.5;
		else if(Coffee.equals("Latte")) price*=1.5;
		setPrice(price);
	}
	@Override
	public String toString() {
		return super.toString()+Coffee+" Coffee";
	}
}