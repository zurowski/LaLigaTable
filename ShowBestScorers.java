package LaLigaTable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
	
public class ShowBestScorers  extends JPanel {


	    public ShowBestScorers() {
	    	super(new GridLayout(1,0));    	
	    	
			Document doc = null;
			
			try {
				File input = new File("LaLigaTabela.html");
				doc = Jsoup.connect("https://www.transfermarkt.pl/primera-division/torschuetzenliste/wettbewerb/ES1/saison_id/2018").get();
			} catch (Exception e) {
				System.err.println("Exception was caught!");
				e.printStackTrace();
			}

			Elements tabela = doc.select("div [class=\"responsive-table\"]").get(0).select("table").select("tbody");
 
	        String[] columnNames = {"Miejsce",
	        						"Zdjecie",
	                                "Imie",
	                                "Pozycja",
	                                "Klub",
	                                "Wiek",
	                                "Wystêpy",
	                                "Strzelone Gole"};

	        Object[][] data = new Object[25][8];

	        int rzadtabeli = 0;
	        Element rzad = null;
	        		
	        for (int row = 0; row <25*3;row+=3) {
	        	
	        	rzad = tabela.select("tr").get(row);
	        	data[rzadtabeli][0] = rzad.select("td").get(0).text(); //miejsce
	        	try {
					data[rzadtabeli][1] = new ImageIcon(new URL(rzad.select("td").get(1).select("tr").get(0).select("td").get(0).select("img").attr("abs:src")));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	data[rzadtabeli][2] = rzad.select("td").get(1).select("tr").get(0).text(); //imie
	        	data[rzadtabeli][3] = rzad.select("td").get(1).select("tr").get(1).text(); //pozycja
	        	try {
	        		data[rzadtabeli][4] = new ImageIcon(new URL(rzad.select("td").get(7).select("img").attr("abs:src")));
	        		
	        	} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	data[rzadtabeli][5] = rzad.select("td").get(6).text();	//wiek
	        	data[rzadtabeli][6] = rzad.select("td").get(8).text();	//rozegrane mecze
	        	data[rzadtabeli][7] = rzad.select("td").get(9).text();	//strzelone gole

	        	rzadtabeli++;
	        }

	        TableModel dataModel = new AbstractTableModel() {
	        	
	            public int getColumnCount() { return columnNames.length; }
	            public int getRowCount() { return data.length;}
	            public String getColumnName(int columnIndex) {
	                return columnNames[columnIndex];
	            }
	            public Object getValueAt(int row, int col) { return (data[row][col]); }
	            

	            public Class<?> getColumnClass(int column) {
	                if ((column >= 0) && (column < getColumnCount())) {
	                  return getValueAt(0, column).getClass();
	                } else {
	                  return Object.class;
	                }
	            }

	        };
	        
	        JTable table = new JTable(dataModel);
	        //JScrollPane scrollpane = new JScrollPane(table);
	        table.setRowHeight(40);
	        //final JTable table = new JTable(data, columnNames);
	        //table.setPreferredScrollableViewportSize(new Dimension(500, 70));
	        //table.setFillsViewportHeight(true);
	        
	        TableRowSorter sorter = new TableRowSorter(dataModel);
	        sorter.setSortable(1, false);
	        sorter.setSortable(4, false);

	        table.setRowSorter(sorter);

	        
	        add(new JScrollPane(table));
	    }

	    void createAndShowGUI() {
	        JFrame frame = new JFrame("Best Scorers");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        ShowBestScorers newContentPane = new ShowBestScorers();
	        newContentPane.setOpaque(true); 
	        frame.setContentPane(newContentPane);

	        frame.pack();
	        frame.setVisible(true);
	        
	        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	        frame.setSize(dimension.width/2, 200);
	        frame.setLocation(dimension.width - frame.getSize().width , 0 );
	    }
	}

