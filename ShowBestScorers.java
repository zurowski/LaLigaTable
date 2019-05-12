package LaLigaTable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
	
public class ShowBestScorers  extends JPanel {


	    public ShowBestScorers() {
	    	super(new GridLayout(1,0));
	    	
	    	File input = new File("LaLigaStrzelcy.html");

			Document doc = null;
			try {
				doc = Jsoup.parse(input, "UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Elements tabela = doc.select("div [class=\"responsive-table\"]").get(0).select("table").select("tbody");
 
	        String[] columnNames = {"Miejsce",
	                                "Imie",
	                                "Pozycja",
	                                "Wiek",
	                                "Wyst�py",
	                                "Strzelone Gole"};

	        Object[][] data = new Object[25][6];

	        int rzadtabeli = 0;
	        int kolumnatabeli =0;
	        Element rzad = null;
	        		
	        for (int row = 0; row <25*3;row+=3) {
	        	
	        	rzad = tabela.select("tr").get(row);
	        	kolumnatabeli = 0;
	        	data[rzadtabeli][kolumnatabeli] = rzad.select("td").get(0).text(); //miejsce
	        	data[rzadtabeli][kolumnatabeli+1] = rzad.select("td").get(1).select("tr").get(0).text(); //imie
	        	data[rzadtabeli][kolumnatabeli+2] = rzad.select("td").get(1).select("tr").get(1).text(); //pozycja
	        	data[rzadtabeli][kolumnatabeli+3] = rzad.select("td").get(6).text();	//wiek
	        	data[rzadtabeli][kolumnatabeli+4] = rzad.select("td").get(8).text();	//rozegrane mecze
	        	data[rzadtabeli][kolumnatabeli+5] = rzad.select("td").get(9).text();	//strzelone gole

	        	rzadtabeli++;
	        }

	        final JTable table = new JTable(data, columnNames);

	        //Create the scroll pane and add the table to it.
	        JScrollPane scrollPane = new JScrollPane(table);

	        //Add the scroll pane to this panel.
	        add(scrollPane);
	    }

	    void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("Best Scorers");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        //Create and set up the content pane.
	        ShowBestScorers newContentPane = new ShowBestScorers();
	        newContentPane.setOpaque(true); //content panes must be opaque
	        frame.setContentPane(newContentPane);

	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	        
	        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	        frame.setSize(dimension.width/2, 200);
	        frame.setLocation(dimension.width - frame.getSize().width , 0 );
	    }
	}

