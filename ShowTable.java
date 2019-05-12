package LaLigaTable;

import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.awt.Dimension;
	import java.awt.GridLayout;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
	
public class ShowTable  extends JPanel {


	    public ShowTable() {
	        super(new GridLayout(1,0));
	        
	        File input = new File("LaLigaTabela.html");

			Document doc = null;
			try {
				doc = Jsoup.parse(input, "UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Element tabela = doc.select("div [class=\"responsive-table\"]").get(0);

			//System.out.println(tabela);
	        
	        String[] columnNames = {"Miejsce",
	                                "Druzyna",
	                                "Wystepy",
	                                "Wygrane",
	                                "Remisy",
	                                "Porazki",
	                                "Gole",
	                                "Bilans Bramkowy",
	                                "Punkty"};

	        Object[][] data = new Object[20][10];


	        for (int row = 0; row <20;row ++) {
	        	
	        	Element rzad = tabela.select("tbody").select("tr").get(row);
	        		        	
	        	for (int column = 0; column < 10; column ++) {
	        		if (column > 1)
	        		{
	        			data[row][column-1] = rzad.select("td").get(column).text();
	        		}else {
	        			data[row][column] = rzad.select("td").get(column).text();
	        		}
	        		
	        		
	        	}
	        	
	        	
	        }

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
	

