import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

public class PCR_GUI_JPanel extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton button = new JButton ("Press to calculate");
	private JTextField desirableVolumeOfMix = new JTextField ("", 5);
	private JTextField samplesQuantity = new JTextField ("", 5);
	private JTextField primersQuantity = new JTextField ("", 5);
	private JTextField stockDilution = new JTextField ("", 5);
	private JLabel desirableVolumeOfMixL = new JLabel ("the preferable volume of Primers' Mixture, in mkl:");
	private JLabel samplesQuantityL = new JLabel ("the quantity of samples:");
	private JLabel primersQuantityL = new JLabel ("the quantity of primers (both Forwards and Reverses):");
	private JLabel stockDilutionL = new JLabel ("the Primers stocks dilution, times");
	private JRadioButton doc = new JRadioButton ("*.doc");
	private JRadioButton txt = new JRadioButton ("*.txt");
	private JRadioButton xls = new JRadioButton ("*.xls");
	private JRadioButton pdf = new JRadioButton ("*.pdf");
	private JCheckBox checkStocksSolution = new JCheckBox("Primers stocks are 100 mM solutions?", true);
		
	public PCR_GUI_JPanel (){
		super("Multiplex Primers' Mix Compouser");
		this.setBounds(100, 200, 700, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font = new Font("Calibri", Font.BOLD, 14);
				
		JPanel alignmentPanel = new JPanel(new FlowLayout());
        alignmentPanel.setBorder(BorderFactory.createTitledBorder("Choose a type to save result into the Primers_Mixture_Data.* file:"));
//        alignmentPanel.setPreferredSize(new Dimension (100, 300));
        
        desirableVolumeOfMixL.setFont(font);  
		samplesQuantityL.setFont(font);
		primersQuantityL.setFont(font);
		stockDilutionL.setFont(font);
		
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(6, 1, 10, 2));
		container.add(checkStocksSolution);
		ButtonGroup fileFormat = new ButtonGroup();
			fileFormat.add(doc);
			fileFormat.add(txt);
			fileFormat.add(xls);
			fileFormat.add(pdf);
			alignmentPanel.add(doc);
			alignmentPanel.add(txt);
			alignmentPanel.add(xls);
			alignmentPanel.add(pdf);
		container.add(alignmentPanel, BorderLayout.SOUTH);
		container.add(desirableVolumeOfMixL);
		container.add(desirableVolumeOfMix);
		container.add(samplesQuantityL);
		container.add(samplesQuantity);
		container.add(primersQuantityL);
		container.add(primersQuantity);
		container.add(stockDilutionL);
		container.add(stockDilution);
		
		button.addActionListener(new ButtonEventListener());
		container.add(button);
	}
	
	//  mixVolume = desirableVolumeOfMix * samplesQuantity
	//  primersQFromStock = samplesQuantity * stockDilution
	//  water = mixVolume - (primersQFromStock * primersQuantity)
	
	class ButtonEventListener implements ActionListener {
		public void actionPerformed (ActionEvent e){
			
			try {
			if (checkStocksSolution.isSelected()) {
				double mixVolume = Double.parseDouble(desirableVolumeOfMix.getText())*Double.parseDouble(samplesQuantity.getText());
				double primersQFromStock = Double.parseDouble(samplesQuantity.getText())*Double.parseDouble(stockDilution.getText());
				double water = mixVolume - (primersQFromStock * Double.parseDouble(primersQuantity.getText()));
			
				String message = "";
				message += "The primers' stocks are " + (checkStocksSolution.isSelected()? "100 mM solutions.\n": "specific\n");
				message += "The total volume of the Primers' Mixture is " + mixVolume + " mkl\n";
				message += "\n";
				message += "Add into a tube:\n";
				message += "Water: " + water + " mkl\n";
				message += "Primers from the stocks: " + primersQFromStock + " mkl\n";
				message += "\n";
				message += "Use " + Double.parseDouble(desirableVolumeOfMix.getText()) + " mkl of Primers Mix per each PCR reaction.";
			
				JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
				
				
			if (doc.isSelected()) {							
				File dataFile = new File("Primers_Mixture_Data.doc"); 
										
				try {
					if(!dataFile.exists())
						dataFile.createNewFile();
						
						PrintWriter pw = new PrintWriter (dataFile);
						pw.println("Here is the receipt: ");
						pw.println(message);
						pw.close();
				} catch (IOException a) {}				
			}
				if (txt.isSelected()) {							
					File dataFile = new File("Primers_Mixture_Data.txt"); 
											
					try {
						if(!dataFile.exists())
							dataFile.createNewFile();
							
							PrintWriter pw = new PrintWriter (dataFile);
							pw.println("Here is the receipt: ");
							pw.println(message);
							pw.close();
					} catch (IOException a) {}
			}
				if (xls.isSelected()) {							
					File dataFile = new File("Primers_Mixture_Data.xls"); 
											
					try {
						if(!dataFile.exists())
							dataFile.createNewFile();
							
							PrintWriter pw = new PrintWriter (dataFile);
							pw.println("Here is the receipt: ");
							pw.println(message);
							pw.close();
					} catch (IOException a) {}
			}
				if (pdf.isSelected()) {							
					File dataFile = new File("Primers_Mixture_Data.pdf"); 
											
					try {
						if(!dataFile.exists())
							dataFile.createNewFile();
							
							PrintWriter pw = new PrintWriter (dataFile);
							pw.println("Here is the receipt: ");
							pw.println(message);
							pw.close();
					} catch (IOException a) {}
			}
		}
									
			else {
				String message1 = "Primers stocks are not 100mM solutions.\nStocks should be corrected.";
			JOptionPane.showMessageDialog(null, message1, "Output", JOptionPane.PLAIN_MESSAGE);
			}
		} catch (NumberFormatException c){
			String message = "Not enough data to make calculations!\nAll cells should be filled.";
			JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
		}
			
	}
}}

	
	
