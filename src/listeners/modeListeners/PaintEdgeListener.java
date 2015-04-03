package listeners.modeListeners;

import model.WorkingArea;

import javax.swing.JPanel;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by Михаил on 31.03.2015.
 */
public class PaintEdgeListener implements MouseMotionListener {
    private WorkingArea boxDrawing;
    private Point mousePos;

    public PaintEdgeListener(WorkingArea boxDrawing){
        this.boxDrawing = boxDrawing;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (boxDrawing.getCurrenEdge() != null && !boxDrawing.getCurrenEdge().isCreate()){
            mousePos = boxDrawing.getMousePosition();
            boxDrawing.getCurrenEdge().setBounds(18+boxDrawing.getCurrenEdge().getStart().getX(),
                    18 + boxDrawing.getCurrenEdge().getStart().getY(),
                    (int)mousePos.getX() - boxDrawing.getCurrenEdge().getStart().getX()-18,
                    (int)mousePos.getY() - boxDrawing.getCurrenEdge().getStart().getY()-18);

            boxDrawing.repaint();
            boxDrawing.getCurrenEdge().repaint();

        }
    }
}
