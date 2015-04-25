package mode;

import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        int count = jtbMain.getComponentCount();
        for (int i=0; i<count; i++){
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
