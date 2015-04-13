package listeners.modeListeners;

import model.Edge;
import model.Vertex;
import model.WorkingArea;
import myConstants.EdgeConst;
import myConstants.ImageConst;
import myConstants.VertexConst;

import javax.swing.JLabel;
import java.awt.*;
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

            boxDrawing.setCurrenEdge(newEdge);
            boxDrawing.getCurrenEdge().setCreate(false);
            boxDrawing.add(boxDrawing.getCurrenEdge().getIdentifier());
        } else{
            boxDrawing.getCurrenEdge().setFinish(vertex);
            boxDrawing.getCurrenEdge().setCreate(true);

            int x1 = boxDrawing.getCurrenEdge().getStart().getX() + VertexConst.VERTEX_SIZE_X / 2;
            int y1 = boxDrawing.getCurrenEdge().getStart().getY() + VertexConst.VERTEX_SIZE_Y / 2;
            int x2 = boxDrawing.getCurrenEdge().getFinish().getX() + VertexConst.VERTEX_SIZE_X / 2;
            int y2 = boxDrawing.getCurrenEdge().getFinish().getY() + VertexConst.VERTEX_SIZE_Y / 2;

            int x = Math.min(x1, x2) + Math.abs(x1 - x2) / 2;
            int y = Math.min(y1,y2) + Math.abs(y1-y2) / 2;

            boxDrawing.drawEdge(boxDrawing.getCurrenEdge());

            boxDrawing.getCurrenEdge().getIdentifier().setBounds(x, y, VertexConst.FONT_SIZE * 4, VertexConst.FONT_SIZE);

            boxDrawing.getCurrenEdge().getStart().addEdge(boxDrawing.getCurrenEdge());
            boxDrawing.getCurrenEdge().getFinish().addEdge(boxDrawing.getCurrenEdge());
            boxDrawing.getAllEdges().addEdges(boxDrawing.getCurrenEdge());

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
