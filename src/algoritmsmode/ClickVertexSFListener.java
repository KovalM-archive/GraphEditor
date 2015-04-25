package algoritmsmode;

import constants.VertexConst;
import graphview.EdgeView;
import graphview.VertexView;
import graphview.WorkingArea;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickVertexSFListener extends MouseAdapter {
    private VertexView vertex;
    private WorkingArea boxDrawing;
    private EdgeView newEdge;

    public ClickVertexSFListener(VertexView vertexCopy, WorkingArea boxDrawingCopy) {
        vertex = vertexCopy;
        boxDrawing = boxDrawingCopy;
    }

    public void mouseClicked(MouseEvent e) {
        if (boxDrawing.getCurrentEdge() == null) {
            newEdge = new EdgeView(new JLabel(""));
            newEdge.setStart(vertex);
            boxDrawing.setCurrentEdge(newEdge);
        } else {
            newEdge = boxDrawing.getCurrentEdge();
            newEdge.setFinish(vertex);
            newEdge.getStart().setIcon(VertexConst.GREY_VERTEX_IMAGE);
            boxDrawing.getGraphView().showMinPath(newEdge.getStart(),newEdge.getFinish());
            boxDrawing.setCurrentEdge(null);
        }
    }

    public void mouseEntered(MouseEvent e) {
        vertex.setIcon(VertexConst.GREEN_VERTEX_IMAGE);
        vertex.updateUI();
    }

    public void mouseExited(MouseEvent e) {
        if (boxDrawing.getCurrentEdge() != null){
            if (!boxDrawing.getCurrentEdge().getStart().equals(vertex)){
                vertex.setIcon(VertexConst.GREY_VERTEX_IMAGE);
                vertex.updateUI();
            }
        }else{
            vertex.setIcon(VertexConst.GREY_VERTEX_IMAGE);
            vertex.updateUI();
        }
    }
}
