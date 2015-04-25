package mode;

import graphview.EdgeView;
import graphview.VertexView;
import graphview.WorkingArea;
import constants.VertexConst;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DeleteVertexListener implements MouseListener {
    private VertexView vertex;
    private WorkingArea boxDrawning;

    public DeleteVertexListener(VertexView vertexCopy, WorkingArea boxDrawningCopy){
        vertex = vertexCopy;
        boxDrawning = boxDrawningCopy;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        EdgeView currentEdge;

        vertex.setVisible(false);

        int n = vertex.getNumberEdges();
        while (n>0){
            currentEdge = vertex.getEdgesAtIndex(n - 1);
            boxDrawning.getAllEdges().removeEdge(currentEdge);
            currentEdge.getIdentifier().setVisible(false);
            currentEdge.getStart().removeEdge(currentEdge);
            currentEdge.getFinish().removeEdge(currentEdge);
            n--;
        }
        boxDrawning.drawVertexsEdges(vertex);

        vertex.getIdentifier().setVisible(false);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

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
