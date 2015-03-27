package listeners.modeListeners;

import listeners.changeIdentifierListeners.ChangeVertexName;
import model.Vertex;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Михаил on 24.03.2015.
 */
public class ChangeIdentifierMode extends ModeListener {

    public ChangeIdentifierMode(JTabbedPane jtpVkladkaCopy,JToolBar jtbMainCopy){
        super(jtpVkladkaCopy,jtbMainCopy);
    }

    @Override
    protected void changeMode() {
        JToggleButton currentButton;

        if (CURRENT_MODE != -1) {
            currentButton = (JToggleButton) jtbMain.getComponentAtIndex(CURRENT_MODE);
            currentButton.setSelected(false);
        }

        currentButton = (JToggleButton) jtbMain.getComponentAtIndex(CHANGE_IDENTIFIER_MODE);
        currentButton.setSelected(true);

        int numberPanel = jtpVkladka.getComponentCount();
        for (int i = 0; i < numberPanel; i++) {
            //JScrollPane scroll = (JScrollPane)jtpVkladka.getComponentAt(i);
            JPanel currentPanel = (JPanel)jtpVkladka.getComponentAt(i);

            int numberLabel = currentPanel.getComponentCount();

            for (int j = 0; j < numberLabel; j++) {
                try {
                    Vertex currentVertex = (Vertex) currentPanel.getComponent(j);

                    MouseListener currentLabelListeners[] = currentVertex.getMouseListeners();

                    for (MouseListener currentListener : currentLabelListeners) {
                        currentVertex.removeMouseListener(currentListener);
                    }

                    MouseMotionListener currentLabelMotionListeners[] = currentVertex.getMouseMotionListeners();

                    for (MouseMotionListener currentListener : currentLabelMotionListeners) {
                        currentVertex.removeMouseMotionListener(currentListener);
                    }
                    currentVertex.addMouseListener(new ChangeVertexName(currentVertex));

                } catch (Exception error){
                    System.out.println("No vertex");
                }
            }

            MouseListener currentPanelListeners[] = currentPanel.getMouseListeners();

            for (MouseListener currentListener : currentPanelListeners){
                currentPanel.removeMouseListener(currentListener);
            }

            currentPanel.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
        }

        CURRENT_MODE = CHANGE_IDENTIFIER_MODE;
    }
}
