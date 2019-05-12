package LaLigaTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChooseAnOption implements ActionListener {
    private ShowTable showtable = new ShowTable();
    private ShowBestScorers showscorers = new ShowBestScorers();

    ChooseAnOption(LaLiga initView) {
       LaLiga initView1 = initView;
    }

    public void actionPerformed(ActionEvent e) {
        final String pressedButton = e.getActionCommand();
        if ("<html>Scorers</html>".equals(pressedButton)) {
            showscorers.createAndShowGUI();
        } else if ("<html>Table</html>".equals(pressedButton)) {
            showtable.createAndShowGUI();

        }
    }
}
