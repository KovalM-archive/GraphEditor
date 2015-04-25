package mode;

import graphview.EdgeView;
import graphview.VertexView;
import graphview.WorkingArea;
import constants.VertexConst;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateEdgeListener extends MouseAdapter {
    private VertexView vertex;
    private WorkingArea boxDrawing;
    private EdgeView newEdge;

    public CreateEdgeListener(VertexView vertexCopy, WorkingArea boxDrawingCopy) {
        vertex = vertexCopy;
        boxDrawing = boxDrawingCopy;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (boxDrawing.getCurrenEdge() == null) {
            newEdge = new EdgeView(new JLabel(""));
            newEdge.setStart(vertex);
            boxDrawing.setCurrenEdge(newEdge);
        } else {
            newEdge = boxDrawing.getCurrenEdge();
            newEdge.setFinish(vertex);

            int x1 = newEdge.getStart().getX() + VertexConst.VERTEX_SIZE_X / 2;
            int y1 = newEdge.getStart().getY() + VertexConst.VERTEX_SIZE_Y / 2;
            int x2 = newEdge.getFinish().getX() + VertexConst.VERTEX_SIZE_X / 2;
            int y2 = newEdge.getFinish().getY() + VertexConst.VERTEX_SIZE_Y / 2;
            int x = Math.min(x1, x2) + Math.abs(x1 - x2) / 2;
            int y = Math.min(y1, y2) + Math.abs(y1 - y2) / 2;

            boxDrawing.drawEdge(boxDrawing.getCurrenEdge());
            newEdge.getIdentifier().setBounds(x, y, VertexConst.FONT_SIZE * 4, VertexConst.FONT_SIZE);
            newEdge.getStart().addEdge(boxDrawing.getCurrenEdge());
            newEdge.getFinish().addEdge(boxDrawing.getCurrenEdge());
            boxDrawing.getAllEdges().addEdges(boxDrawing.getCurrenEdge());
            boxDrawing.add(newEdge.getIdentifier());
            boxDrawing.setCurrenEdge(null);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        vertex.setIcon(VertexConst.GREEN_VERTEX_IMAGE);
        vertex.updateUI();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        vertex.setIcon(VertexConst.GREY_VERTEX_IMAGE);
        vertex.updateUI();
    }

}
