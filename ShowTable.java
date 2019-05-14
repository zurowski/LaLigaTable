package LaLigaTable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

public class ShowTable  extends JPanel {

	    public ShowTable() {
	        super(new GridLayout(1,0));

			Document doc = null;
			try { 
				File input = new File("LaLigaTabela.html");
				doc = Jsoup.parse(input, "UTF-8");
			} catch (Exception e) {
				System.err.println("Exception was caught!");
				e.printStackTrace();
			}
			
			Element tabela = doc.select("div [class=\"responsive-table\"]").get(0);
	        
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

	        Element rzad = null;
	        for (int row = 0; row <20;row ++) {
	        	
	        	rzad = tabela.select("tbody").select("tr").get(row);
	        		        	
	        	for (int column = 0; column < 10; column ++) {
	        		if (column > 1)
	        		{
	        			data[row][column-1] = rzad.select("td").get(column).text();
	        		}else {
	        			data[row][column] = rzad.select("td").get(column).text();
	        		}
	        	}
	        }
	        
	        TableModel dataModel = new AbstractTableModel() {
	        	
	            public int getColumnCount() { return columnNames.length; }
	            public int getRowCount() { return data.length;}
	            public String getColumnName(int columnIndex) {
	                return columnNames[columnIndex];
	            }
	            public Object getValueAt(int row, int col) { return (data[row][col]); }
	            
	            /*public Class<?> getColumnClass(int columnIndex) {
	                //if (listEmployees.isEmpty()) {return Object.class;}
	                return getValueAt(1, columnIndex).getClass();
	            }*/
	            public Class<?> getColumnClass(int column) {
	                Class<?> returnValue;
	                if ((column >= 0) && (column < getColumnCount())) {
	                  returnValue = getValueAt(0, column).getClass();
	                } else {
	                  returnValue = Object.class;
	                }
	                return returnValue;
	              }

	        };
	        
	        JTable table = new JTable(dataModel);
	        //JScrollPane scrollpane = new JScrollPane(table);
	        
	        //final JTable table = new JTable(data, columnNames);
	        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
	        table.setFillsViewportHeight(true);
	        
	        TableRowSorter sorter = new TableRowSorter(dataModel);
	        sorter.setSortable(6, false);

	        table.setRowSorter(sorter);
	        
	        //table.setRowSorter(new TableRowSorter(dataModel));
	        //table.setAutoCreateRowSorter(true);
	        

	        JScrollPane scrollPane = new JScrollPane(table);

	        add(scrollPane);
	    }

	    void createAndShowGUI() {
	        JFrame frame = new JFrame("Table");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        ShowTable newContentPane = new ShowTable();
	        newContentPane.setOpaque(true);
	        frame.setContentPane(newContentPane);

	        frame.pack();
	        frame.setVisible(true);
	        
	        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	        frame.setSize(dimension.width/2, 200);
	        frame.setLocation(0 , 0 );
	    }
}
	

