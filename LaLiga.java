package LaLigaTable;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;


import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class LaLiga {

	private final Choose JedenZDwoch = new Choose(this);
    private JButton Table;
    private JButton Scorers;

    private void setButtons() {
        Table = new JButton("Table");
        Table.addActionListener(JedenZDwoch);
        Table.setBounds(0, 0, 150, 100);


        Scorers = new JButton("Scorers");
        Scorers.addActionListener(JedenZDwoch);
        Scorers.setBounds(150, 0, 150, 100);

    }
	
    private void setPane(Container pane) {
        setButtons();
        pane.add(Table);
        pane.add(Scorers);
    }
	
	private void createAndShowGUI() {
        JFrame jf = new JFrame("Season 18/19");
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        setPane(jPanel);
        jf.getContentPane().add(jPanel);

        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setSize(300, 130);
        jf.setLocation(dim.width / 2 - jf.getSize().width / 2, dim.height / 2 - jf.getSize().height / 2);
        jf.setResizable(false);
    }
	
	
	private LaLiga() {
        createAndShowGUI();
    }
	
	public static void main(String[] args) throws IOException {
		
		//https://www.transfermarkt.pl/primera-division/torschuetzenliste/wettbewerb/ES1/saison_id/2018 //strzelcy
		//Document doc = Jsoup.connect("https://www.transfermarkt.pl/laliga/tabelle/wettbewerb/ES1").get();
		//File input = new File("LaLigaStrzelcy.html");
		
		//Document doc = Jsoup.parse(input, "UTF-8");
		//Element tabela = doc.select("div [class=\"responsive-table\"]").get(0);
		
		//System.out.println(tabela.select("table").select("tbody").select("tr").get(0).select("td").get(1).select("tr").get(1).text());

		
	      	 
	   	SwingUtilities.invokeLater((new Runnable() {
            public void run() {
                new LaLiga();
            }
        }));

	}

}


