package mode;

import graphview.WorkingArea;
import constants.VertexConst;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class PaintEdgeListener extends MouseAdapter implements MouseMotionListener {
    private WorkingArea boxDrawing;

    public PaintEdgeListener(WorkingArea boxDrawing) {
        this.boxDrawing = boxDrawing;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point mousePosition = boxDrawing.getMousePosition();

        if (null != boxDrawing.getCurrentEdge() && null != mousePosition) {
            int x1 = boxDrawing.getCurrentEdge().getStart().getX() + VertexConst.VERTEX_SIZE_X / 2;
            int y1 = boxDrawing.getCurrentEdge().getStart().getY() + VertexConst.VERTEX_SIZE_Y / 2;
            int x2 = (int) mousePosition.getX();
            int y2 = (int) mousePosition.getY();

            int x = Math.min(x1, x2) + Math.abs(x1 - x2) / 2;
            int y = Math.min(y1, y2) + Math.abs(y1 - y2) / 2;

            boxDrawing.getCurrentEdge().getIdentifier().setBounds(x, y, VertexConst.FONT_SIZE * 4, VertexConst.FONT_SIZE);

            boxDrawing.drawEdgeTemp(x1, y1, x2, y2);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == e.BUTTON3 && null != boxDrawing.getCurrentEdge()){
            boxDrawing.setCurrentEdge(null);
            boxDrawing.repaint();
        }
    }
}
