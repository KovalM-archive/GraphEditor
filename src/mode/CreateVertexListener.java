package mode;

import graph.VertexModel;
import graphview.VertexView;
import graphview.WorkingArea;
import constants.VertexConst;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CreateVertexListener extends MouseAdapter {

    private WorkingArea boxDrawing;
    private JToolBar jtbMain;

    public CreateVertexListener(WorkingArea boxDrawingCopy, JToolBar jtbMainCopy) {

        boxDrawing = boxDrawingCopy;
        jtbMain = jtbMainCopy;
    }

    public void mouseClicked(MouseEvent me) {
        if (me.getClickCount() == 2 && me.getButton() == me.BUTTON1) {
            try {
                String nameVertex = "";

                VertexView vertex = new VertexView(VertexConst.GREY_VERTEX_IMAGE,new JLabel(nameVertex));
                vertex.addMouseMotionListener(new MoveVertexListener(vertex,boxDrawing));
                vertex.addMouseListener(new ClickVertexListener(vertex));

                VertexModel newVertexModel = new VertexModel();
                vertex.setVertexRoot(newVertexModel);
                boxDrawing.getGraphView().getGraphRoot().addVertex(newVertexModel);
                boxDrawing.getGraphView().addVertex(vertex);

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
}
