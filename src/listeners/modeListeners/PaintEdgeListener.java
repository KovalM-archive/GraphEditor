package listeners.modeListeners;

import model.Vertex;
import model.WorkingArea;
import myConstants.EdgeConst;
import myConstants.VertexConst;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import static java.lang.Math.abs;

/**
 * Created by Михаил on 31.03.2015.
 */
public class PaintEdgeListener implements MouseMotionListener {
    private WorkingArea boxDrawing;

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
            int x2 = (int) boxDrawing.getMousePosition().getX();
            int y2 = (int) boxDrawing.getMousePosition().getY();

            int x = Math.min(x1,x2) + Math.abs(x1-x2) / 2;
            int y = Math.min(y1,y2) + Math.abs(y1-y2) / 2;

            boxDrawing.getCurrenEdge().getIdentifier().setBounds(x, y, VertexConst.FONT_SIZE * 4, VertexConst.FONT_SIZE);

            boxDrawing.drawEdgeTemp(x1, y1, x2, y2);
        }
    }
}
