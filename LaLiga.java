package LaLigaTable;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.text.html.parser.DTD;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class LaLiga {

	private final ChooseAnOption chooseAnOption = new ChooseAnOption(this);
    //private GlobalFunctions service = new GlobalFunctions();
    private JButton addManuallyButton;
    private JButton addFromSiteButton;

    private void setButtons() {
        addManuallyButton = new JButton("<html>Table</html>");
        addManuallyButton.addActionListener(chooseAnOption);
        addManuallyButton.setBounds(20, 100, 150, 100);


        addFromSiteButton = new JButton("<html>Scorers</html>");
        addFromSiteButton.addActionListener(chooseAnOption);
        addFromSiteButton.setBounds(220, 100, 150, 100);

    }
	
    private void setPane(Container pane) {
        setButtons();
        pane.add(addManuallyButton);
        pane.add(addFromSiteButton);
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
        jf.setSize(400, 400);
        jf.setLocation(dim.width / 2 - jf.getSize().width / 2, dim.height / 2 - jf.getSize().height / 2);
        jf.setResizable(false);
    }
	
	
	private LaLiga() {
        createAndShowGUI();
    }
	
	public static void main(String[] args) throws IOException {
		
		//https://www.transfermarkt.pl/primera-division/torschuetzenliste/wettbewerb/ES1/saison_id/2018 //strzelcy
		//Document doc = Jsoup.connect("https://www.transfermarkt.pl/laliga/tabelle/wettbewerb/ES1").get();
		File input = new File("LaLiga.html");
		
		Document doc = Jsoup.parse(input, "UTF-8");
		Element tabela = doc.select("div [class=\"responsive-table\"]").get(0);
		//System.out.println(tabela.select("tbody").select("tr").get(0).select("td").get(9).text());

		
	        List<String> instructions = Jsoup.parse(input, "UTF-8")
	                .select("div [class=\"responsive-table\"]").get(0)
	                .select("tbody")
	                .select("tr").get(1)
	                .select("td").eachText();

	        StringBuilder sb = new StringBuilder();
	        sb.append(instructions.stream().collect(Collectors.joining(","))).append("\n");

	        //System.out.print(sb.toString());

	   	 
	   	SwingUtilities.invokeLater((new Runnable() {
            public void run() {
                new LaLiga();
            }
        }));

	}

}


