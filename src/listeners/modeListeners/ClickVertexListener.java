package listeners.modeListeners;

import model.Vertex;
import myConstants.ImageConst;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Михаил on 25.03.2015.
 */
public class ClickVertexListener implements MouseListener {
    private Vertex vertex;

    public ClickVertexListener(Vertex vertexCopy){
        vertex = vertexCopy;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
