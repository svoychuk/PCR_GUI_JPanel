import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;


public class quantityOfPCRSets {
	static ArrayList <Double> listOfAampliconsHKG = hKGN.listOfAampliconsHKG;
	static ArrayList <Double> listOfAampliconsGOI = GeensOfInterst.listOfAampliconsGOI;
	static ArrayList <Double> combined = new ArrayList <Double>(10);
	ArrayList <Double> fresh1 = new ArrayList <Double>(10);
	ArrayList <Double> fresh2 = new ArrayList <Double>(10);
	
	public void setVisible(boolean b) {
			
		int rangeOfDifference = 49;
					
		for (int i = 0; i < listOfAampliconsGOI.size(); i++) {
			double a = listOfAampliconsGOI.get(i);
			for (int j = i+1; j < listOfAampliconsGOI.size(); j++) {
					double c = listOfAampliconsGOI.get(j);
				try {
					if(a >= c-rangeOfDifference) { 
						fresh1.add(a);
						fresh2.add(c);
						}
					else {
						fresh1.add(a);
						fresh1.add(c);
						}
					}
				catch (NullPointerException e) {
						String message = ("Ups!!! Something goes wrong!!! Try once more!");
						JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
						}
				}
			}
		
		for (Double temp1: fresh1) {
			for (Double temp2 : fresh2) {
				String message = ("The PCR set will include the next amplicons: " + temp1 + " and " + temp2);
				JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
				}
			}
		}		
	}


