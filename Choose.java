package LaLigaTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Choose implements ActionListener {
    private ShowTable showtable = new ShowTable();
    private ShowBestScorers showscorers = new ShowBestScorers();

    Choose(LaLiga initView) {
       LaLiga initView1 = initView;
    }

    public void actionPerformed(ActionEvent e) {
        final String pressedButton = e.getActionCommand();
        if ("Scorers".equals(pressedButton)) {
            showscorers.createAndShowGUI();
        } else if ("Table".equals(pressedButton)) {
            showtable.createAndShowGUI();

        }
    }
}
