package mode;

import graphview.VertexView;
import constants.VertexConst;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickVertexListener extends MouseAdapter {
    private VertexView vertex;

    public ClickVertexListener(VertexView vertexCopy){
        vertex = vertexCopy;
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
