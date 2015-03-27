package listeners.createEdgeListeners;

import model.Vertex;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Михаил on 27.03.2015.
 */
public class CreateEdgeListener implements MouseListener {
    Vertex vertex;

    public CreateEdgeListener(Vertex vertexCopy){
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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
