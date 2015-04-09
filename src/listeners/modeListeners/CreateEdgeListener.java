package listeners.modeListeners;

import model.Edge;
import model.Vertex;
import model.WorkingArea;
import myConstants.EdgeConst;
import myConstants.ImageConst;
import myConstants.VertexConst;

import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.lang.Math.abs;

/**
 * Created by Михаил on 27.03.2015.
 */
public class CreateEdgeListener implements MouseListener {
    private Vertex vertex;
    private WorkingArea boxDrawing;

    public CreateEdgeListener(Vertex vertexCopy,WorkingArea boxDrawingCopy){
        vertex = vertexCopy;
        boxDrawing = boxDrawingCopy;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (boxDrawing.getCurrenEdge() == null){
            Edge newEdge = new Edge(new JLabel(""));
            newEdge.setStart(vertex);
            newEdge.setDoubleBuffered(true);
            boxDrawing.setCurrenEdge(newEdge);
            boxDrawing.getCurrenEdge().setCreate(false);
            boxDrawing.add(boxDrawing.getCurrenEdge());
        } else{
            boxDrawing.getCurrenEdge().setFinish(vertex);
            boxDrawing.getCurrenEdge().setCreate(true);

            int x1 = boxDrawing.getCurrenEdge().getStart().getX();
            int y1 = boxDrawing.getCurrenEdge().getStart().getY();
            int x2 = boxDrawing.getCurrenEdge().getFinish().getX();
            int y2 = boxDrawing.getCurrenEdge().getFinish().getY();

            if (x1 <= x2 && y1 <= y2) {
                boxDrawing.getCurrenEdge().setBounds(x1 + VertexConst.VERTEX_SIZE_X / 2, y1 + VertexConst.VERTEX_SIZE_Y / 2,
                                                        abs(x1 - x2), abs(y1 - y2));
                boxDrawing.getCurrenEdge().setCurrenDirection(EdgeConst.DIRECTION_SOUTH_EAST);
            } else if (x1 >= x2 && y1 <= y2) {
                boxDrawing.getCurrenEdge().setBounds(x2 + VertexConst.VERTEX_SIZE_X / 2, y1 + VertexConst.VERTEX_SIZE_Y / 2,
                                                        abs(x1 - x2), abs(y1 - y2));
                boxDrawing.getCurrenEdge().setCurrenDirection(EdgeConst.DIRECTION_SOUTH_WEST);
            } else if (x1 >= x2 && y1 >= y2) {
                boxDrawing.getCurrenEdge().setBounds(x2 + VertexConst.VERTEX_SIZE_X / 2, y2 + VertexConst.VERTEX_SIZE_Y / 2,
                                                        abs(x1 - x2), abs(y1 - y2));
                boxDrawing.getCurrenEdge().setCurrenDirection(EdgeConst.DIRECTION_NORTH_WEST);
            } else {
                boxDrawing.getCurrenEdge().setBounds(x1 + VertexConst.VERTEX_SIZE_X / 2, y2 + VertexConst.VERTEX_SIZE_Y / 2,
                                                        abs(x1 - x2), abs(y1 - y2));
                boxDrawing.getCurrenEdge().setCurrenDirection(EdgeConst.DIRECTION_NORTH_EAST);
            }

            boxDrawing.repaint();
            boxDrawing.getCurrenEdge().repaint();
            boxDrawing.setCurrenEdge(null);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        vertex.setIcon(ImageConst.GREEN_VERTEX_IMAGE);
        vertex.updateUI();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        vertex.setIcon(ImageConst.GREY_VERTEX_IMAGE);
        vertex.updateUI();
    }

}
