import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class quantityOfPCRSetsEqualsDefault extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	static ArrayList <Double> listOfAampliconsHKG = hKGN.listOfAampliconsHKG;
	static ArrayList <Double> listOfAampliconsGOI = GeensOfInterst.listOfAampliconsGOI;
	static ArrayList <Double> combined = new ArrayList <Double>(10);
	static JPanel matrixPanel = Gel_Optimizer.matrixPanel;
	static JLabel resultForOneSet;
	private JFrame pCRSetsFrame;
	private JPanel pSetsPanel;
	private JLabel pSetsLable;
	private JButton pSetsButton;
	static int maxKey;
	
	
	public void setVisible(boolean b) {
		combined.addAll(listOfAampliconsHKG);
		combined.addAll(listOfAampliconsGOI);
		
//		@SuppressWarnings("unchecked")
//		List<ArrayList<Double>> combi = Arrays.asList(combined);
//		
		HashMap<Double, Double> duplicates = new HashMap <Double, Double>();
		HashMap<Double, Double> duplicates2 = duplicates;
		Double x;
		
		double maxKeyDouble = 1.0;
		for (Double i: combined){
			x = duplicates.get(i);
			duplicates.put(i, x==null ? 1: x + 1);
			}
		
		for (Object key : duplicates.keySet().toArray()) {
			if (duplicates.get(key) == 1) {
				duplicates.remove(key);
				maxKeyDouble = Collections.max(duplicates.values());
				}
			}
		maxKey = (int) maxKeyDouble;
		
		for (Object key : duplicates.keySet().toArray()) {
			if (duplicates.get(key) >= 2) {
				String message = "<html><h3>Some amplicons hase the same or close size: <br>" 
								+ duplicates + " <br> At least " + maxKey + " primers' sets will be created. <br>"
										+ "The housekeeping genes <br> "
										+ "will be included into each set.<h3>"+
								"<font face='verdana' size = 3>";
				pCRSetsFrame = new JFrame("PCR Sets");
				pCRSetsFrame.setBounds(800, 300, 400, 300);
				pCRSetsFrame.setVisible(true);
				
				pSetsPanel = new JPanel ();
				pSetsPanel.setLayout(new FlowLayout());
				pSetsPanel.setBorder(BorderFactory.createTitledBorder("PCR Sets"));
				
				pSetsLable = new JLabel();
				pSetsLable.setText(message);
				
				pSetsButton = new JButton("Ok");
				pSetsButton.addActionListener(new ButtonEvent1());
								
				pSetsPanel.add(pSetsLable);
				pSetsPanel.add(pSetsButton, BorderLayout.SOUTH);
				
				pCRSetsFrame.add(pSetsPanel);	
				break;
			}
			
		for (Object key2 : duplicates2.keySet().toArray()) {	
			if (duplicates2.get(key2) < 2){
				try {
//				for (ArrayList<Double> temp: combi){
				String message = ("The PCR set can include all of the above amplicons: " + 
						combined);
				JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
				
					
//						}
				break;
				
				}
				
				catch (NoSuchElementException nsee) {}
			}}
		}
	} 	
	public void actionPerformed(ActionEvent arg0) {}
}

class ButtonEvent1 implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		List<Double> arrayList = GeensOfInterst.listOfAampliconsGOI;
		
		int buckets = quantityOfPCRSetsEqualsDefault.maxKey;
		int divide = arrayList.size()/ buckets;
		if (arrayList.size() % buckets != 0){
			divide++;
			}
		
//		for (int start = 0; start < arrayList.size(); start += divide){
//			int end = Math.min(start + divide, arrayList.size());
//			List<Double> sublist = arrayList.subList(start, end);
//			@SuppressWarnings("unchecked")
//			List<List<Double>> subL = Arrays.asList(sublist);

		
		for (int start = 0; start < arrayList.size(); start += 1){
			int end = Math.min(start + divide, arrayList.size());
			List<Double> sublist = arrayList.subList(start, end);
			@SuppressWarnings("unchecked")
			List<List<Double>> subL = Arrays.asList(sublist);

			for (List<Double> temp: subL){
				String message = "PCR Sets " + temp;
				
				JFrame resultFrame = new JFrame("Result");
				resultFrame.setBounds(800, 300, 400, 300);
				resultFrame.setVisible(true);
								
				JPanel resultPanel = new JPanel();
				
				JLabel resultLabel = new JLabel();
				resultLabel.setText(message);
				
				resultPanel.add(resultLabel);
				resultFrame.add(resultPanel);
			}
			
		}

	}
}
