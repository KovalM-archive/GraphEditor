package listeners;

import mediators.ToolBarMediator;
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

            if (ToolBarMediator.getNumberSelectedButton() == 0) {

                try {
                    String nameVertex = "";

                    JLabel jlVertex = new JLabel(ImageConst.GREY_VERTEX_IMAGE);
                    JLabel jlIdtf = new JLabel(nameVertex);

                    ClickedMoveVertexListener clmListener = new ClickedMoveVertexListener(jlVertex, jlIdtf, boxDrawing);

                    jlVertex.addMouseMotionListener(clmListener);
                    jlVertex.addMouseListener(clmListener);
                    jlIdtf.addMouseMotionListener(clmListener);
                    jlIdtf.addMouseListener(clmListener);

                    boxDrawing.add(jlVertex);
                    boxDrawing.add(jlIdtf);

                    jlVertex.setBounds(me.getX(), me.getY(), NumericConst.VERTEX_SIZE_X, NumericConst.VERTEX_SIZE_Y);
                    jlIdtf.setBounds(me.getX() + NumericConst.VERTEX_SIZE_X,
                            me.getY() + NumericConst.VERTEX_SIZE_Y - 4,
                            NumericConst.FONT_SIZE * nameVertex.length(), NumericConst.FONT_SIZE);

                    boxDrawing.repaint();
                } catch (Exception error) {

                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        /*if (me.getClickCount()==1){
            ImageIcon imVertex = new ImageIcon("image\\toolbar\\181.png");
            JLabel jlBuf = new JLabel(imVertex);
            boxDrawing.add(jlBuf);

            jlBuf.setLocation(me.getX(),me.getY());

            System.out.print(2);
        }*/
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       /* if (me.getClickCount()==1){
            ImageIcon imVertex = new ImageIcon("image\\toolbar\\181.png");
            JLabel jlBuf = new JLabel(imVertex);
            boxDrawing.add(jlBuf);

            jlBuf.setLocation(me.getX(),me.getY());

            System.out.print(3);
        }*/
    }

    @Override
    public void mouseEntered(MouseEvent me) {
      /*  if (me.getClickCount()==1){
            ImageIcon imVertex = new ImageIcon("image\\toolbar\\181.png");
            JLabel jlBuf = new JLabel(imVertex);
            boxDrawing.add(jlBuf);

            jlBuf.setLocation(me.getX(),me.getY());

            System.out.print(4);
        }*/
    }

    @Override
    public void mouseExited(MouseEvent me) {
       /* if (me.getClickCount()==1){
            ImageIcon imVertex = new ImageIcon("image\\toolbar\\181.png");
            JLabel jlBuf = new JLabel(imVertex);
            boxDrawing.add(jlBuf);

            jlBuf.setLocation(me.getX(),me.getY());

            System.out.print(5);
        }*/
    }
}
