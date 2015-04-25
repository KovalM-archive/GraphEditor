package mode;

import graphview.VertexView;
import graphview.WorkingArea;

import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CreateEdgeModeListener extends ModeListener {

    public CreateEdgeModeListener(JTabbedPane jtpVkladkaCopy, JToolBar jtbMainCopy){
        super(jtpVkladkaCopy,jtbMainCopy);
    }

    @Override
    protected void changeMode() {

        int numberPanel = jtpVkladka.getComponentCount();
        for (int i = 0; i < numberPanel; i++) {
            //JScrollPane scroll = (JScrollPane)jtpVkladka.getComponentAt(i);
            WorkingArea currentPanel = (WorkingArea)jtpVkladka.getComponentAt(i);

            int numberLabel = currentPanel.getComponentCount();

            for (int j = 0; j < numberLabel; j++) {
                try {
                    VertexView currentVertex = (VertexView) currentPanel.getComponent(j);

                    MouseListener currentLabelListeners[] = currentVertex.getMouseListeners();

                    for (MouseListener currentListener : currentLabelListeners) {
                        currentVertex.removeMouseListener(currentListener);
                    }

                    MouseMotionListener currentLabelMotionListeners[] = currentVertex.getMouseMotionListeners();

                    for (MouseMotionListener currentListener : currentLabelMotionListeners) {
                        currentVertex.removeMouseMotionListener(currentListener);
                    }
                    currentVertex.addMouseListener(new CreateEdgeListener(currentVertex,currentPanel));
                } catch (Exception error){
                    System.out.println("No vertex");
                }
                currentPanel.addMouseMotionListener(new PaintEdgeListener(currentPanel));

            }

            MouseListener currentPanelListeners[] = currentPanel.getMouseListeners();

            for (MouseListener currentListener : currentPanelListeners){
                currentPanel.removeMouseListener(currentListener);
            }

            MouseMotionListener currentPanelMotionListeners[] = currentPanel.getMouseMotionListeners();

            for (MouseMotionListener currentListener : currentPanelMotionListeners){
                currentPanel.removeMouseMotionListener(currentListener);
            }

            currentPanel.addMouseMotionListener(new PaintEdgeListener(currentPanel));
            currentPanel.addMouseListener(new PaintEdgeListener(currentPanel));
            currentPanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
    }

}
