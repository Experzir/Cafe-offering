import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Frame extends JFrame implements ActionListener{
	private JLabel JSize,JBev,JPiece,JReport;
	private JComboBox<String> size;
	private JRadioButton rdFruity,rdTea,rdCoffee,rdWater,rdCake,rdPie,rdCroissant;
	private ButtonGroup btnGroup;
	private JTextField txtPiece;
	private JButton btnAdd,btnOrder;
	int amount_of;
	ArrayList<Beverage> list_of_bvr = new ArrayList<Beverage>();
	
	public Frame() {
		setLayout(null);
		setSize(500,450);
		setLocationRelativeTo(null);
		setTitle("Cafe Ordering");
		init();
		btnAdd.addActionListener(this); 
		btnOrder.addActionListener(this);
		setVisible(true);
	}
	
	public void init() {
		JBev = new JLabel("Beverage :");
		JBev.setSize(500, 50);
		JBev.setLocation(100, 15);
		add(JBev);
		
		JBev = new JLabel("Bakery :");
		JBev.setSize(500, 50);
		JBev.setLocation(100, 85);
		add(JBev);
		
		JSize = new JLabel("Select size:");
		JSize.setSize(250, 50);
		JSize.setLocation(100, 160);
		add(JSize);
		
		String[] sizes = {"Small","Medium","Large"};
		size = new JComboBox<String>(sizes);//
		size.setSelectedIndex(0);
		size.setSize(100, 25);
		size.setLocation(100, 200);
		add(size);
		
		btnGroup = new ButtonGroup();
		
		rdFruity = new JRadioButton("Fruity");
		rdFruity.setSize(75, 50);
		rdFruity.setLocation(235, 50);
		add(rdFruity);
		
		rdTea = new JRadioButton("Tea");
		rdTea.setSize(75, 50);
		rdTea.setLocation(175, 50);
		add(rdTea);
		
		rdCoffee = new JRadioButton("Coffee");
		rdCoffee.setSize(75, 50);
		rdCoffee.setLocation(100, 50);
		add(rdCoffee);
		
		rdWater = new JRadioButton("Water");
		rdWater.setSize(75, 50);
		rdWater.setLocation(308, 50);
		add(rdWater);
		
		rdCake = new JRadioButton("Cake");
		rdCake.setSize(75, 50);
		rdCake.setLocation(235, 120);
		add(rdCake);
		
		rdPie = new JRadioButton("Pie");
		rdPie.setSize(75, 50);
		rdPie.setLocation(185, 120);
		add(rdPie);
		
		rdCroissant = new JRadioButton("Croissant");
		rdCroissant.setSize(80, 50);
		rdCroissant.setLocation(100, 120);
		add(rdCroissant);
		
		btnGroup.add(rdCake);
		btnGroup.add(rdPie);
		btnGroup.add(rdCroissant);
		btnGroup.add(rdCoffee);
		btnGroup.add(rdTea);
		btnGroup.add(rdFruity);
		btnGroup.add(rdWater);
		
		JPiece = new JLabel("How many pieces :");
		JPiece.setSize(500, 50);
		JPiece.setLocation(100, 220);
		add(JPiece);
		
		txtPiece = new JTextField();
		txtPiece.setSize(300, 25);
		txtPiece.setLocation(100, 260);
		add(txtPiece);
		
		btnAdd = new JButton("Add");
		btnAdd.setSize(120, 40);
		btnAdd.setLocation(100, 300);
		add(btnAdd);
		
		btnOrder = new JButton("Order");
		btnOrder.setSize(120, 40);
		btnOrder.setLocation(280, 300);
		btnOrder.setEnabled(false);
		add(btnOrder);
		
		JReport = new JLabel();
		JReport.setSize(500, 50);
		JReport.setLocation(100, 340);
		add(JReport);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String size_of = (String)size.getSelectedItem();
		if(e.getSource().equals(btnAdd)) {
			if( rdCake.isSelected() || rdPie.isSelected() || rdCroissant.isSelected() || rdFruity.isSelected() || rdTea.isSelected() 
					|| rdCoffee.isSelected() || rdWater.isSelected() && !(txtPiece.getText().isEmpty())) {
				try {
					amount_of  = Integer.parseInt(txtPiece.getText().trim());
					Beverage bvg;
					if(rdCoffee.isSelected())  { bvg = new Coffee(size_of,amount_of,this); }
					else if(rdTea.isSelected())    { bvg = new Tea(size_of,amount_of,this); }
					else if(rdFruity.isSelected()){ bvg = new Fruity(size_of,amount_of,this); }
					else if(rdCake.isSelected()){ bvg = new Cake(size_of,amount_of,this); }
					else if(rdPie.isSelected()){ bvg = new Pie(size_of,amount_of,this); }
					else if(rdCroissant.isSelected()){ bvg = new Croissant(size_of,amount_of,this); }
					else { bvg = new Water(size_of,amount_of,this); }
					txtPiece.setText(null);
					list_of_bvr.add(bvg);
					JReport.setText(bvg.toString()+" added");
					btnGroup.clearSelection();
					btnOrder.setEnabled(true);
				}
				catch(NumberFormatException e1) { 
					JOptionPane.showMessageDialog(this, "Please enter an integer ");
				}
			}	
			else { JOptionPane.showMessageDialog(this, "Choose a beverage or bakery "); 
			}
		}
		if(e.getSource().equals(btnOrder)) {
			String report = "";
			double pay=0.0;
			for(int i=0;i<list_of_bvr.size();i++) {
				Beverage bvgi = list_of_bvr.get(i);
				report += bvgi.toString();
				double totalprice_of_bvg = bvgi.getAmount() * bvgi.getPrice();
				pay += totalprice_of_bvg;
				report = report + " - "+totalprice_of_bvg+" Bath\n";
			}
			JOptionPane.showMessageDialog(this, report);
			JOptionPane.showMessageDialog(this,	 "You should pay "+pay+" Bath");
			JReport.setText(null);
			btnOrder.setEnabled(false);
			list_of_bvr.clear();
		}	
	}

	public static void main(String[] args) {
		new Frame();
	}
}