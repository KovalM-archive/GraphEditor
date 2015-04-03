package listeners.modeListeners;

import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Михаил on 24.03.2015.
 */
public abstract class ModeListener implements ActionListener {

    protected JTabbedPane jtpVkladka;
    protected JToolBar jtbMain;

    protected ModeListener(JTabbedPane jtpVkladkaCopy,JToolBar jtbMainCopy){
        jtpVkladka = jtpVkladkaCopy;
        jtbMain = jtbMainCopy;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton currentButton;

        for (int i=0; i<4; i++){
            currentButton = (JToggleButton) jtbMain.getComponentAtIndex(i);
            if (e.getActionCommand().equals(currentButton.getActionCommand())){
                currentButton.setSelected(true);
            }else{
                currentButton.setSelected(false);
            }
        }

        changeMode();
    }

    protected void changeMode(){

    }
}
