package listeners;

import listeners.createMoveVertexListeners.ClickVertexListener;
import listeners.createMoveVertexListeners.MoveVertexListener;
import model.Vertex;
import myConstants.ImageConst;
import myConstants.NumericConst;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Михаил on 02.03.2015.
 */
public class BoxDrawingListener implements MouseListener {

    JPanel boxDrawing;
    JToolBar jtbMain;

    public BoxDrawingListener(JPanel boxDrawingCopy, JToolBar jtbMainCopy) {

        boxDrawing = boxDrawingCopy;
        jtbMain = jtbMainCopy;
    }

    public void mouseClicked(MouseEvent me) {
        if (me.getClickCount() == 2 && me.getButton() == me.BUTTON1) {
            try {
                String nameVertex = "";

                Vertex vertex = new Vertex(ImageConst.GREY_VERTEX_IMAGE,new JLabel(nameVertex));
                vertex.addMouseMotionListener(new MoveVertexListener(vertex,boxDrawing));
                vertex.addMouseListener(new ClickVertexListener(vertex));

                boxDrawing.add(vertex);
                boxDrawing.add(vertex.getIdentifier());

                vertex.setBounds(me.getX(), me.getY(), NumericConst.VERTEX_SIZE_X, NumericConst.VERTEX_SIZE_Y);
                vertex.getIdentifier().setBounds(me.getX() + NumericConst.VERTEX_SIZE_X,
                            me.getY() + NumericConst.VERTEX_SIZE_Y - 4,
                            NumericConst.FONT_SIZE * nameVertex.length(), NumericConst.FONT_SIZE);

                boxDrawing.repaint();
            } catch (Exception error) {
                System.out.println("in BoxDrawingListener");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
}
