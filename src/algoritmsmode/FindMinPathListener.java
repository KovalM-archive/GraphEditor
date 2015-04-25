package algoritmsmode;

import graphview.VertexView;
import graphview.WorkingArea;

import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class FindMinPathListener extends AlgorithmModeListener {
    public FindMinPathListener(JTabbedPane jtpVkladkaCopy, JToolBar jtbMainCopy, JToolBar jtbAlgorithmCopy) {
        super(jtpVkladkaCopy, jtbMainCopy, jtbAlgorithmCopy);
    }

    protected void changeMode(){
        int numberPanel = jtpVkladka.getComponentCount();
        for (int i = 0; i < numberPanel; i++) {
            WorkingArea currentPanel = (WorkingArea)jtpVkladka.getComponentAt(i);

            int numberLabel = currentPanel.getComponentCount();
            for (int j = 0; j < numberLabel; j++) {
                try {
                    VertexView currentVertex = (VertexView) currentPanel.getComponent(j);

                    MouseListener currentLabelListeners[] = currentVertex.getMouseListeners();

                    for (MouseListener currentListener : currentLabelListeners) {
                        currentVertex.removeMouseListener(currentListener);
                    }

                    MouseMotionListener currentPanelMotionListeners[] = currentVertex.getMouseMotionListeners();

                    for (MouseMotionListener currentListener : currentPanelMotionListeners){
                        currentVertex.removeMouseMotionListener(currentListener);
                    }

                    currentVertex.addMouseListener(new ClickVertexSFListener(currentVertex,currentPanel));
                } catch (Exception error){
                    System.out.println("No vertex");
                }
            }

            MouseListener currentPanelListeners[] = currentPanel.getMouseListeners();

            for (MouseListener currentListener : currentPanelListeners){
                currentPanel.removeMouseListener(currentListener);
            }

            MouseMotionListener currentPanelMotionListeners[] = currentPanel.getMouseMotionListeners();

            for (MouseMotionListener currentListener : currentPanelMotionListeners){
                currentPanel.removeMouseMotionListener(currentListener);
            }
            currentPanel.setCursor(Cursor.getDefaultCursor());
        }
    }
}
