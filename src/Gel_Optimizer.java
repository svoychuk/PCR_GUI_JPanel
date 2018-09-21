import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class Gel_Optimizer extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static JTextField houseKeepingGenesNumber = new JTextField (null, 5);
//	static JTextField insertedHouseKeepingGenesNumber = new JTextField (null, 5);
	static JTextField GenesNumber = new JTextField (null, 5);
	static JTextField quantityOfPCRSets = new JTextField (null, 5);
	static JPanel ampliconSetPanelHKG = new JPanel();
	static JPanel ampliconSetPanelGOI = new JPanel();
	static JPanel matrixPanel = new JPanel();
//	static JLabel result1 = hKGN.result1;
	static JButton button2;
	static ArrayList <Double> listOfAampliconsHKG = hKGN.listOfAampliconsHKG;
	static ArrayList <Double> listOfAampliconsGOI = GeensOfInterst.listOfAampliconsGOI;
	
	
	public Gel_Optimizer () {
		super("Multiplex Primers' Mix Compouser");
		this.setBounds(800, 200, 600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font = new Font("Verdana", Font.BOLD, 16);
		
		JPanel alignmentPanel = new JPanel(new FlowLayout());
        	alignmentPanel.setBorder(BorderFactory.createTitledBorder(
        		"Instructions"));
		      String text1 = "<html><h3>Indicate the lengths (in bp) of amplicons of the genes of interest <h3>"+
		        		"<font face='calibri' size = 3>"+
		    		"Amplicons lengths should be indicated in the specific cells <br>"+
		        	"You can additionally indicate the names of the PCR products <br>"+
		    		"The hosekeeping genes names and length of their amplicons indicate in a specified cells <br>"+
		        	"Indicate how many sets of primers you'd like to be created <br>"+
		    		"Indicate how many housekeeping genes would be included into each set of primer <br>"+
		        	"It is reccomended to use at least 2 housekeeping genes per set.</html>";
		      font = new Font(null, Font.PLAIN, 10);
		      JLabel htmlLable = new JLabel ();
		      htmlLable.setText(text1);
		      htmlLable.setFont(font);
		      htmlLable.setSize(700, 100);
		      alignmentPanel.add(htmlLable);
		      
		      final JScrollPane scrollPane = new JScrollPane(htmlLable);
		      alignmentPanel.add(scrollPane, BorderLayout.CENTER);
		      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		      
		 ampliconSetPanelHKG.setLayout(new FlowLayout());
		 ampliconSetPanelHKG.setBorder(BorderFactory.createTitledBorder(
		      		"Hosekeeping genes:"));
		      String text2 = "<html><h3>How many housekeeping genes you'd like to use?<h3></html>";
		    		  font = new Font(null, Font.PLAIN, 10);
		      JLabel htmlLable2 = new JLabel ();
		      htmlLable2.setText(text2);
		      htmlLable2.setFont(font);
		      ampliconSetPanelHKG.add(htmlLable2);
		      
		      ampliconSetPanelHKG.add(houseKeepingGenesNumber);
		      
		      JButton button = new JButton ("Press to indicate the lengths");
		      button.addActionListener(new ButtonEvent());
		      ampliconSetPanelHKG.add(button);
		      
		 ampliconSetPanelGOI.setLayout(new FlowLayout());
		 ampliconSetPanelGOI.setBorder(BorderFactory.createTitledBorder(
		      		"Genes of interest (excluding housekeeping ones):"));
		      String text3 = "<html><h3>How many genes you'd like to use in MultyPlexPCR?<h3></html>";
		    		  font = new Font(null, Font.PLAIN, 10);
		      JLabel htmlLable3 = new JLabel ();
		      htmlLable3.setText(text3);
		      htmlLable3.setFont(font);
		      ampliconSetPanelGOI.add(htmlLable3);
		      
		      ampliconSetPanelGOI.add(GenesNumber);
		      
		      JButton button1 = new JButton ("Press to indicate their lengths");
		      button1.addActionListener(new ButtonEvent2());
		      ampliconSetPanelGOI.add(button1);
			      
		  matrixPanel.setLayout(new FlowLayout());
		  matrixPanel.setBorder(BorderFactory.createTitledBorder(
			      		"Quantity of MultyPlex PCR-sets"));
			     
		  		String text4 = "<html><h3>How many PCR sets you'd like to be created of them?<h3></html>";
			    	font = new Font(null, Font.PLAIN, 10);
					    JLabel htmlLable4 = new JLabel ();
					    htmlLable4.setText(text4);
					    htmlLable4.setFont(font);
					    matrixPanel.add(htmlLable4);
					      
			      matrixPanel.add(quantityOfPCRSets);
			      
			      button2 = new JButton ("Ok");
			      button2.addActionListener(new ButtonEvent3());
			      matrixPanel.add(button2);
			      
			      
        Container container = this.getContentPane();
		container.setLayout(new GridLayout(4, 1, 1, 2));
		
		container.add(alignmentPanel);
		container.add(ampliconSetPanelHKG);
		container.add(ampliconSetPanelGOI);
		container.add(matrixPanel);
	}
	
	class ButtonEvent implements ActionListener {
		public void actionPerformed (ActionEvent e){
			try{
			int hkgnumber = (int) Double.parseDouble(houseKeepingGenesNumber.getText());
				if (hkgnumber>0){
					hKGN hkgn = new hKGN ();
					hkgn.setVisible(true);
					}
				}
				catch(NumberFormatException nfe){
					String message = "If you'd like to use housekeeping genes, please, indicate their quantity!!!";
					JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);}
			}
		}
	public JTextField houseKeepingGenesNumber(){
		   return Gel_Optimizer.houseKeepingGenesNumber;
		}

	class ButtonEvent2 implements ActionListener {
		public void actionPerformed (ActionEvent e){
			try {
			int gnumber = (int) Double.parseDouble(GenesNumber.getText());
				if (gnumber>0){
					GeensOfInterst gn = new GeensOfInterst ();
					gn.setVisible(true);
					}
				}
				catch(NumberFormatException nfe)
				{String message = "Indicate the quantity of the genes you'd like to study in multyplex PCR!!!\nAt least two should be indicated.";
					JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);}
					}
				}
	public JTextField GenesNumber(){
		   return Gel_Optimizer.GenesNumber;
		}
	
	class ButtonEvent3 implements ActionListener {
		public void actionPerformed (ActionEvent e){
			try{
			int qPCRSets = (int) Double.parseDouble(quantityOfPCRSets.getText());

				if (qPCRSets>0){
					quantityOfPCRSets gn = new quantityOfPCRSets ();
					gn.setVisible(true);
					}
			}
				catch(NumberFormatException nfe){
					String message = "You have not indicated the desirable quantity of the "
						+ "PCR sets! \nTherefore the sets will be created automaticaly.";
					JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
					
					quantityOfPCRSetsEqualsDefault gn = new quantityOfPCRSetsEqualsDefault ();
					gn.setVisible(true);
					}
					}
				}
	public JTextField quantityOfPCRSets(){
		   return Gel_Optimizer.quantityOfPCRSets;
		}
	}
