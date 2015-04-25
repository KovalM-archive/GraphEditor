package mode;

import graphview.VertexView;;
import constants.VertexConst;

import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChangeVertexName implements MouseListener {
    private VertexView vertex;

    public ChangeVertexName(VertexView vertexCopy){
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
                VertexConst.FONT_SIZE * newNameVertex.length(),
                VertexConst.FONT_SIZE);

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
        vertex.setIcon(VertexConst.GREEN_VERTEX_IMAGE);
        vertex.updateUI();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        vertex.setIcon(VertexConst.GREY_VERTEX_IMAGE);
        vertex.updateUI();
    }
}
