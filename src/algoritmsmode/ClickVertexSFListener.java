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

    public ClickVertexSFListener(VertexView vertexCopy, WorkingArea boxDrawingCopy) {
        vertex = vertexCopy;
        boxDrawing = boxDrawingCopy;
    }

    public void mouseClicked(MouseEvent e) {
        if (boxDrawing.getGraphView().getStart() == null) {
            boxDrawing.getGraphView().setStart(vertex);
        } else {
            boxDrawing.getGraphView().showMinPath(boxDrawing.getGraphView().getStart(), vertex);
            boxDrawing.getGraphView().setStart(null);
        }
    }

    public void mouseEntered(MouseEvent e) {
        vertex.setIcon(VertexConst.GREEN_VERTEX_IMAGE);
        vertex.updateUI();
    }

    public void mouseExited(MouseEvent e) {
        if (boxDrawing.getGraphView().getStart() != null){
            if (!boxDrawing.getGraphView().getStart().equals(vertex)){
                vertex.setIcon(VertexConst.GREY_VERTEX_IMAGE);
                vertex.updateUI();
            }
        }else{
            vertex.setIcon(VertexConst.GREY_VERTEX_IMAGE);
            vertex.updateUI();
        }
    }
}
