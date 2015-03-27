package listeners.changeIdentifierListeners;

import model.Vertex;
import myConstants.NumericConst;

import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Михаил on 25.03.2015.
 */
public class ChangeVertexName implements MouseListener {
    Vertex vertex;

    public ChangeVertexName(Vertex vertexCopy){
        vertex = vertexCopy;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String newNameVertex = "";
        try {
            while (newNameVertex.equals("")) {
                newNameVertex = JOptionPane.showInputDialog("Enter name of vertex:");
            }
        } catch (Exception error){
            newNameVertex = "";
        }

        vertex.getIdentifier().setBounds(
                vertex.getIdentifier().getX(),
                vertex.getIdentifier().getY(),
                NumericConst.FONT_SIZE * newNameVertex.length(),
                NumericConst.FONT_SIZE);

        vertex.getIdentifier().setText(newNameVertex);
        vertex.getIdentifier().updateUI();
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
