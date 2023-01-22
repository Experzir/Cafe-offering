import javax.swing.JOptionPane;

public class Pie extends Beverage {
	private String Pie;
	String[] TypePie = {"Apple","Pineapple","Blueberry","Chicken"};

	public Pie(String size,int amount,Frame f) {
		super(size,amount);
		Pie = (String) JOptionPane.showInputDialog(f,"Select a Type of Pie.","Pie",
				JOptionPane.QUESTION_MESSAGE,null,TypePie,TypePie[0]);
		double price;
		if(size.equals("Small")) price=15;
		else if(size.equals("Medium")) price=20;
		else price=25;
		if(Pie.equals("Apple")) price*=1;
		else if(Pie.equals("Pineapple")) price*=1;
		else if(Pie.equals("Blueberry")) price*=1.25;
		else if(Pie.equals("Chicken")) price*=1.25;
		setPrice(price);
	}
	@Override
	public String toString() {
		return super.toString()+Pie+" Pie";
	}
}