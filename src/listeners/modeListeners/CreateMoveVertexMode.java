package listeners.modeListeners;

import listeners.BoxDrawingListener;
import listeners.createMoveVertexListeners.ClickVertexListener;
import listeners.createMoveVertexListeners.MoveVertexListener;
import model.Vertex;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import java.awt.Cursor;
import java.awt.event.MouseListener;

/**
 * Created by Михаил on 24.03.2015.
 */
public class CreateMoveVertexMode extends ModeListener {

    public CreateMoveVertexMode(JTabbedPane jtpVkladkaCopy,JToolBar jtbMainCopy){
        super(jtpVkladkaCopy,jtbMainCopy);
        changeMode();
    }

    protected void changeMode() {
        JToggleButton currentButton;

        if (CURRENT_MODE != -1) {
            currentButton = (JToggleButton) jtbMain.getComponentAtIndex(CURRENT_MODE);
            currentButton.setSelected(false);
        }

        currentButton = (JToggleButton) jtbMain.getComponentAtIndex(CREATE_MOVE_VERTEX_MODE);
        currentButton.setSelected(true);

        int numberPanel = jtpVkladka.getComponentCount();
        for (int i = 0; i < numberPanel; i++) {
            JPanel currentPanel = (JPanel)jtpVkladka.getComponentAt(i);

            int numberLabel = currentPanel.getComponentCount();
            for (int j = 0; j < numberLabel; j++) {
                try {
                    Vertex currentVertex = (Vertex) currentPanel.getComponent(j);

                    MouseListener currentLabelListeners[] = currentVertex.getMouseListeners();

                    for (MouseListener currentListener : currentLabelListeners) {
                        currentVertex.removeMouseListener(currentListener);
                    }

                    currentVertex.addMouseMotionListener(new MoveVertexListener(currentVertex, currentPanel));
                    currentVertex.addMouseListener(new ClickVertexListener(currentVertex));

                } catch (Exception error){
                    System.out.println("No vertex");
                }
            }
            currentPanel.addMouseListener(new BoxDrawingListener(currentPanel,jtbMain));
            currentPanel.setCursor(Cursor.getDefaultCursor());
        }


        CURRENT_MODE = CREATE_MOVE_VERTEX_MODE;
    }
}
