import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class hKGN extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private JPanel panel;
    static JLabel resultOf;
    private JTextField ampliconLength;
	private JButton okButton = new JButton ("Ok");
	private JTextField houseKeepingGenesNumber = Gel_Optimizer.houseKeepingGenesNumber;
	static JPanel ampliconSetPanelHKG = Gel_Optimizer.ampliconSetPanelHKG;
	static JLabel resultHKG;
	private int geneNumber = (int) Double.parseDouble(houseKeepingGenesNumber.getText());
	static ArrayList <Double> listOfAampliconsHKG = new ArrayList <Double>(3);
	private List<ArrayList<Double>> combi;

	public hKGN() {
		super("The hosekeeping amplicons lengths");
		this.setBounds(1000, 200, 250, 80+(geneNumber*30));
				
		int x = geneNumber+1;
		int b = 1;
		int c = 10;
		int d = 5;
		
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(x, b, c, d));
		
		panel = new JPanel();
				
		try {
			for (int i = 1; i<=geneNumber; i++){
				panel.add(new JLabel ("Housekeeping gene " + i + ":"));
				
				panel.add(ampliconLength = new JTextField ("", 5));
				
			}
		}
		catch (IllegalArgumentException e) {}
		
		okButton.addActionListener(new OkActionListener ());
		panel.add(okButton);
		
		container.add(panel);
		setContentPane(panel);
	}
	

class OkActionListener implements ActionListener {
	public void actionPerformed (ActionEvent whenOkIsPressed){
		if (whenOkIsPressed.getSource() == okButton){
					
			Component[] info = panel.getComponents();
			for (int i = 0; i < info.length; i++) {
				info[i].setEnabled(false);}
				for (Component c : info){
				if (c instanceof JTextField){
					ampliconLength = (JTextField) c;
					ampliconLength.setEditable(true);
					listOfAampliconsHKG.add(Double.parseDouble(ampliconLength.getText()));}
					}
				}

		Collections.sort(listOfAampliconsHKG);
				
		resultHKG = new JLabel();
		  Gel_Optimizer.ampliconSetPanelHKG.add(resultHKG);  
		  
			  resultHKG.setText("You've entered " + listOfAampliconsHKG.size() + 
					" amplicons as the genes of interest: \n" + listOfAampliconsHKG);
		  	
		}
	}
}



