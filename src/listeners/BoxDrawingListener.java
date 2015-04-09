package listeners;

import listeners.modeListeners.ClickVertexListener;
import listeners.modeListeners.MoveVertexListener;
import model.Vertex;
import model.WorkingArea;
import myConstants.ImageConst;
import myConstants.VertexConst;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Михаил on 02.03.2015.
 */
public class BoxDrawingListener implements MouseListener {

    private WorkingArea boxDrawing;
    private JToolBar jtbMain;

    public BoxDrawingListener(WorkingArea boxDrawingCopy, JToolBar jtbMainCopy) {

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

                vertex.setBounds(me.getX(), me.getY(), VertexConst.VERTEX_SIZE_X, VertexConst.VERTEX_SIZE_Y);
                vertex.getIdentifier().setBounds(me.getX() + VertexConst.VERTEX_SIZE_X,
                            me.getY() + VertexConst.VERTEX_SIZE_Y - 4,
                            VertexConst.FONT_SIZE * nameVertex.length(), VertexConst.FONT_SIZE);

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
