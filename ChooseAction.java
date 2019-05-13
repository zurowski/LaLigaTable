package LaLigaTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChooseAction implements ActionListener {
    
	ShowTable showtable = new ShowTable();
    ShowBestScorers showscorers = new ShowBestScorers();

    public void actionPerformed(ActionEvent event) {
    	
        String przycisk = event.getActionCommand();
        
        if (przycisk == "Scorers") {
            showscorers.createAndShowGUI();
        } else if (przycisk == "Table") {
            showtable.createAndShowGUI();

        }
    }
}
