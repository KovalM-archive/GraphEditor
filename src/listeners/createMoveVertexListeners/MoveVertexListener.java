package listeners.createMoveVertexListeners;

import model.Vertex;
import myConstants.ImageConst;

import javax.swing.JPanel;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by Михаил on 25.03.2015.
 */
public class MoveVertexListener implements MouseMotionListener {
    Vertex vertex;
    JPanel boxDrawing;
    Point mouseOnBoxDrawing;

    public MoveVertexListener(Vertex vertexCopy,JPanel boxDrawingCopy){
        vertex = vertexCopy;
        boxDrawing = boxDrawingCopy;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        vertex.setIcon(ImageConst.GREEN_VERTEX_IMAGE);
        mouseOnBoxDrawing = boxDrawing.getMousePosition();
        mouseOnBoxDrawing.setLocation(mouseOnBoxDrawing.getX() - 9, mouseOnBoxDrawing.getY() - 9);
        vertex.setLocation(mouseOnBoxDrawing);
        mouseOnBoxDrawing.setLocation(mouseOnBoxDrawing.getX() + 18, mouseOnBoxDrawing.getY() + 12);
        vertex.getIdentifier().setLocation(mouseOnBoxDrawing);

        vertex.updateUI();
        vertex.getIdentifier().updateUI();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
