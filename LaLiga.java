package LaLigaTable;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;


public class LaLiga {

	private final ChooseAction JedenZDwoch = new ChooseAction();
    private JButton Table;
    private JButton Scorers;

    private void setAll(Container panel) {
    	
    	Table = new JButton("Table");
        Table.addActionListener(JedenZDwoch);
        Table.setBounds(0, 0, 150, 100);
        panel.add(Table);

        Scorers = new JButton("Scorers");
        Scorers.addActionListener(JedenZDwoch);
        Scorers.setBounds(150, 0, 150, 100);
        panel.add(Scorers);
    }
	
	
	private void createAndShowGUI() {
        JFrame jf = new JFrame("Season 18/19");
        JPanel jp = new JPanel();
        
        jp.setLayout(null);

        setAll(jp);
        
        jf.getContentPane().add(jp);

        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setSize(300, 130);
        jf.setLocation(dimension.width / 2 - jf.getSize().width / 2, dimension.height / 2 - jf.getSize().height / 2);
        jf.setResizable(false);
    }
	
	
	private LaLiga() {
        createAndShowGUI();
    }
	
	public static void main(String[] args) throws IOException {
		
		//https://www.transfermarkt.pl/primera-division/torschuetzenliste/wettbewerb/ES1/saison_id/2018 //strzelcy
		//Document doc = Jsoup.connect("https://www.transfermarkt.pl/laliga/tabelle/wettbewerb/ES1").get(); //tabela
		//File input = new File("LaLigaStrzelcy.html");
		
		Document doc = null;
		try { 
			File input = new File("LaLigaTabela.html");
			doc = Jsoup.connect("https://www.transfermarkt.pl/primera-division/torschuetzenliste/wettbewerb/ES1/saison_id/2018").get();
			// = Jsoup.parse(input, "UTF-8");//, "https://www.transfermarkt.pl/laliga/tabelle/wettbewerb/ES1");
		} catch (Exception e) {
			System.err.println("Exception was caught!");
			e.printStackTrace();
		}
		Elements tabela = doc.select("div [class=\"responsive-table\"]").get(0).select("table").select("tbody");
		Element rzad = tabela.select("tr").get(0);

		//Elements sciezka = tabela.select("tbody").select("tr").get(1).select("td").get(1).select("img");
		//String sciezka = rzad.select("td").get(1).select("tr").get(0).select("td").get(0).select("img").attr("abs:src");
		//Element sciezka = rzad.select("td").get(6);
		String sciezka = rzad.select("td").get(7).select("img").attr("abs:src");
		System.out.println(sciezka);
		
	      
		
	   	SwingUtilities.invokeLater((new Runnable() {
            public void run() {
                new LaLiga();
            }
        }));

	}

}


