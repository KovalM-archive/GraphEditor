package listeners.modeListeners;

import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Михаил on 24.03.2015.
 */
public abstract class ModeListener implements ActionListener {

    protected  final int CREATE_MOVE_VERTEX_MODE = 0;
    protected  final int CREATE_EDGE_MODE = 1;
    protected  final int CHANGE_IDENTIFIER_MODE = 2;
    protected  final int DELETE_MODE = 3;
    protected static int CURRENT_MODE = -1;

    protected JTabbedPane jtpVkladka;
    protected JToolBar jtbMain;

    protected ModeListener(JTabbedPane jtpVkladkaCopy,JToolBar jtbMainCopy){
        jtpVkladka = jtpVkladkaCopy;
        jtbMain = jtbMainCopy;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        changeMode();
    }

    protected void changeMode(){

    }
}
