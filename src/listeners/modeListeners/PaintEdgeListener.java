package listeners.modeListeners;

import model.Vertex;
import model.WorkingArea;
import myConstants.EdgeConst;
import myConstants.VertexConst;

import javax.swing.JPanel;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import static java.lang.Math.abs;

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
        if (boxDrawing.getCurrenEdge() != null) {
            int x1 = boxDrawing.getCurrenEdge().getStart().getX() + VertexConst.VERTEX_SIZE_X / 2;
            int y1 = boxDrawing.getCurrenEdge().getStart().getY() + VertexConst.VERTEX_SIZE_Y / 2;
            mousePos = boxDrawing.getMousePosition();
            int x2 = (int) mousePos.getX();
            int y2 = (int) mousePos.getY();

            if (x1 <= x2 && y1 <= y2) {
                boxDrawing.getCurrenEdge().setBounds(x1, y1,
                                                        abs(x1 - x2), abs(y1 - y2));
                boxDrawing.getCurrenEdge().setCurrenDirection(EdgeConst.DIRECTION_SOUTH_EAST);
            } else if (x1 >= x2 && y1 <= y2) {
                boxDrawing.getCurrenEdge().setBounds(x2, y1,
                                                        abs(x1 - x2), abs(y1 - y2));
                boxDrawing.getCurrenEdge().setCurrenDirection(EdgeConst.DIRECTION_SOUTH_WEST);
            } else if (x1 >= x2 && y1 >= y2) {
                boxDrawing.getCurrenEdge().setBounds(x2, y2, abs(x1 - x2), abs(y1 - y2));
                boxDrawing.getCurrenEdge().setCurrenDirection(EdgeConst.DIRECTION_NORTH_WEST);
            } else {
                boxDrawing.getCurrenEdge().setBounds(x1, y2,
                                                        abs(x1 - x2), abs(y1 - y2));
                boxDrawing.getCurrenEdge().setCurrenDirection(EdgeConst.DIRECTION_NORTH_EAST);
            }

            boxDrawing.repaint();
           // boxDrawing.getCurrenEdge().repaint();
        }
    }
}
