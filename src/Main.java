import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
//		try {
//	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//	    } 
//	    catch (Exception e) {
//	    //Exception handle
//	    }
		
		PCR_GUI_JPanel app = new PCR_GUI_JPanel();
		app.setVisible(true);
		Gel_Optimizer app2 = new Gel_Optimizer ();
		app2.setVisible(true);

//		try { 
//		    UIManager.setLookAndFeel("javax.swing.plaf.wood.WoodLookAndFeel");
//		    SwingUtilities.updateComponentTreeUI(app); 
//		    SwingUtilities.updateComponentTreeUI(app2); 
//		}
//		catch (Exception e){
//		    System.out.println("Ошибка при загрузке Metal-Look-And-Feel");
//		}
		
	}

}
