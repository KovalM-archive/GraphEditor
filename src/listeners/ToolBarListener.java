package listeners;

import mediators.ToolBarMediator;

import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Михаил on 23.02.2015.
 */

public class ToolBarListener implements ActionListener {

    JToolBar jtbMain;
    JTabbedPane jtpVkladka;

    public ToolBarListener(JToolBar jtbMainCopy,JTabbedPane jtpVkladkaCopy) {
        jtpVkladka = jtpVkladkaCopy;
        jtbMain = jtbMainCopy;
    }

    public void actionPerformed(ActionEvent ae) {

        JToggleButton currentButton;

        for (int i = 0; i < 4; i++) {
            currentButton = (JToggleButton) jtbMain.getComponentAtIndex(i);
            if (currentButton.getActionCommand() == ae.getActionCommand()) {
                currentButton.setSelected(true);
            } else {
                currentButton.setSelected(false);
            }
        }

        int n = jtpVkladka.getComponentCount();

        for (int i = 0; i < n; i++) {
            jtpVkladka.getComponentAt(i).setCursor(determineCursor());
        }
    }

    private Cursor determineCursor(){
        if (ToolBarMediator.getNumberSelectedButton() == 0){
            return Cursor.getDefaultCursor();
        } else if (ToolBarMediator.getNumberSelectedButton() == 1) {
            return Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
        } else if (ToolBarMediator.getNumberSelectedButton() == 2) {
            return Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
        } else if (ToolBarMediator.getNumberSelectedButton() == 3){
            return Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
        }

        return null;
    }
}
