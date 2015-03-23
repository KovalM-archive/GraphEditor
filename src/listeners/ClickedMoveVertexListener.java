package listeners;

import mediators.CurrentVertexMediator;
import mediators.ToolBarMediator;
import myConstants.ImageConst;
import myConstants.NumericConst;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Михаил on 03.03.2015.
 */
public class ClickedMoveVertexListener implements MouseMotionListener, MouseListener {

    private JLabel jlVertex;
    private JLabel jlIdtf;
    private JPanel boxDrawing;
    private Point mouseOnBoxDrawing;

    public ClickedMoveVertexListener(JLabel jlVertexCopy, JLabel jlIdtfCopy,JPanel boxDrawingCopy) {
        jlVertex = jlVertexCopy;
        jlIdtf = jlIdtfCopy;
        boxDrawing = boxDrawingCopy;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (ToolBarMediator.getNumberSelectedButton() == 0) {
            mouseOnBoxDrawing = boxDrawing.getMousePosition();
            mouseOnBoxDrawing.setLocation(mouseOnBoxDrawing.getX() - 9, mouseOnBoxDrawing.getY() - 9);
            jlVertex.setLocation(mouseOnBoxDrawing);
            mouseOnBoxDrawing.setLocation(mouseOnBoxDrawing.getX() + 18, mouseOnBoxDrawing.getY() + 12);
            jlIdtf.setLocation(mouseOnBoxDrawing);

            jlIdtf.updateUI();
            jlVertex.updateUI();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (CurrentVertexMediator.getCurrenVertex() != null){
            CurrentVertexMediator.getCurrenVertex().setIcon(ImageConst.GREY_VERTEX_IMAGE);
        }

        jlVertex.setIcon(ImageConst.GREEN_VERTEX_IMAGE);

        CurrentVertexMediator.setCurrenVertex(jlVertex);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (ToolBarMediator.getNumberSelectedButton() == 1)
        {


        } else if (ToolBarMediator.getNumberSelectedButton() == 2){
            String newNameVertex = "";

            try {
            while (newNameVertex.equals("")) {
                newNameVertex = JOptionPane.showInputDialog("Enter name of vertex:");
            }
            } catch (Exception error){
                newNameVertex = "";
            }

            jlIdtf.setBounds(
                    jlIdtf.getX(),
                    jlIdtf.getY(),
                    NumericConst.FONT_SIZE * newNameVertex.length(),
                    NumericConst.FONT_SIZE);

            jlIdtf.setText(newNameVertex);
        } else if (ToolBarMediator.getNumberSelectedButton() == 3){
            jlVertex.setVisible(false);
            jlIdtf.setVisible(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }
}
