import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GeensOfInterst extends JFrame{
	private static final long serialVersionUID = 1L;

    private JPanel panelGOI;
    static JLabel resultOfGOI;
    private JTextField ampliconLengthGOI;
	private JButton okButtonGOI = new JButton ("Ok");
	private JTextField GenesNumber = Gel_Optimizer.GenesNumber;
	static JLabel resultGOI;
	private int geneNumber = (int) Double.parseDouble(GenesNumber.getText());
	static ArrayList <Double> listOfAampliconsGOI = new ArrayList <Double>(10);
	
	
	public GeensOfInterst() {
		super("The genes of interest amplicons lengths");
		this.setBounds(1000, 200, 270, 80+(geneNumber*13));
				
		int x = geneNumber+1;
		int b = 1;
		int c = 10;
		int d = 5;
		
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(x, b, c, d));
		
		panelGOI = new JPanel();
				
		try {
			for (int i = 1; i<=geneNumber; i++){
				panelGOI.add(new JLabel ("Gene " + i + ":"));
				
				panelGOI.add(ampliconLengthGOI = new JTextField ("", 5));
				
			}
		}
		catch (IllegalArgumentException e) {}
		
		okButtonGOI.addActionListener(new OkActionListener ());
		panelGOI.add(okButtonGOI);
		
		container.add(panelGOI);
		setContentPane(panelGOI);
	}
	
class OkActionListener implements ActionListener {
	public void actionPerformed (ActionEvent whenOkIsPressed){
		if (whenOkIsPressed.getSource() == okButtonGOI){
			try {	
				Component[] info = panelGOI.getComponents();
				for (int i = 0; i < info.length; i++) {
					info[i].setEnabled(false);}
					for (Component c : info){
						if (c instanceof JTextField){
							ampliconLengthGOI = (JTextField) c;
							ampliconLengthGOI.setEditable(true);
							listOfAampliconsGOI.add(Double.parseDouble(ampliconLengthGOI.getText()));
							
							}
						}
					}
				
				
			catch(NumberFormatException nfe){
				String message = ("You have not entered the amplicon size");
				JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
				}
			}
				
		Collections.sort(listOfAampliconsGOI);
		
		resultGOI = new JLabel();
			  Gel_Optimizer.ampliconSetPanelGOI.add(resultGOI);  
				resultGOI.setText("You've entered " + listOfAampliconsGOI.size() + 
						" amplicons as the genes of interest: \n" + listOfAampliconsGOI);
		}
	}
}


