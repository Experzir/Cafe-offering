import javax.swing.JOptionPane;

public class Water extends Beverage {
	private boolean iced;
	public Water(String size,int amount,Frame f) {
		super(size,amount);
		if(JOptionPane.showConfirmDialog(f, "Would you like ice?","Ice",JOptionPane.YES_NO_OPTION)==0) iced=true;
		else iced=false;
		double price;
		if(size.equals("Small")) price=5.0;
		else if(size.equals("Medium")) price=10.0;
		else price=15;
		if(iced) price*=1; 
		setPrice(price);
	}
	@Override
	public String toString() {
		if(iced) return super.toString()+"Water with ice";
		else return super.toString()+"Water";
	}
}