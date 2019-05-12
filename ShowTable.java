package LaLigaTable;

import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import java.awt.Dimension;
	import java.awt.GridLayout;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	
public class ShowTable  extends JPanel {


	    public ShowTable() {
	        super(new GridLayout(1,0));

	        String[] columnNames = {"Place",
	                                "Team",
	                                "Points"};

	        Object[][] data = {
		    {"Kathy", "Smith", "Snowboarding"},
		    {"John", "Doe","Rowing"},
		    {"Sue", "Black","Knitting"},
		    {"Jane", "White","Speed reading"},
		    {"Joe", "Brown", "Pool"},
		    {"Joe", "Brown", "Pool"}
	        };

	        final JTable table = new JTable(data, columnNames);
	        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
	        table.setFillsViewportHeight(true);

	       

	        //Create the scroll pane and add the table to it.
	        JScrollPane scrollPane = new JScrollPane(table);

	        //Add the scroll pane to this panel.
	        add(scrollPane);
	    }

	   

	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event-dispatching thread.
	     */
	    void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("Table");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        //Create and set up the content pane.
	        ShowTable newContentPane = new ShowTable();
	        newContentPane.setOpaque(true); //content panes must be opaque
	        frame.setContentPane(newContentPane);

	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }


	    }
	

