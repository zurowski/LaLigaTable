package LaLigaTable;


import java.io.File;

import java.io.IOException;
import java.net.URL;

import javax.swing.text.html.parser.DTD;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Table {

	public static void main(String[] args) throws IOException {

			HAAAAAAAAAAAAAAAAalo;
		//Document doc = Jsoup.connect("https://www.transfermarkt.pl/laliga/tabelle/wettbewerb/ES1").get();
		File input = new File("LaLiga.html");
		Document doc = Jsoup.parse(input, "UTF-8");
		
	   	Element tabela = doc.select("div [class=\"responsive-table\"]").get(0);
	   	
	   	//tabela.select("tbody").select("tr").get(0).select("td").get(0).text()
	   	//wyciaga miejsce w tabeli czyli 1 wiersz 1 kolumne
	   	
	   	//tabela.select("tbody").select("tr").get(0).select("td").get(2).text()
	   	//wyciaga nazwe zespolu 
	   	
	   	//tabela.select("tbody").select("tr").get(0).select("td").get(9).text()
	   	//wyciaga liczbe punktów zespolu
	   	
	   	System.out.println(tabela.select("tbody").select("tr").get(0).select("td").get(9).text());
	   	//String cokolwiek = tables.first().select("tr").get(0).select("b").get(0).text();
	   	//Elements row1 = tables.first().select("tr").get(1).select("b");
	   	 
	   	//row1.select("tr").get(1).select("a").attr("abs:href");
	   	 



	}

}


