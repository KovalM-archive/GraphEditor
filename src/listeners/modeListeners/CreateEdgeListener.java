package listeners.modeListeners;

import model.Edge;
import model.Vertex;
import model.WorkingArea;

import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * Created by Михаил on 27.03.2015.
 */
public class CreateEdgeListener implements MouseListener {
    private Vertex vertex;
    private WorkingArea boxDrawing;

    public CreateEdgeListener(Vertex vertexCopy,WorkingArea boxDrawingCopy){
        vertex = vertexCopy;
        boxDrawing = boxDrawingCopy;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (boxDrawing.getCurrenEdge() == null){
            Edge newEdge = new Edge(new JLabel(""));
            newEdge.setStart(vertex);
            newEdge.setDoubleBuffered(true);
            boxDrawing.setCurrenEdge(newEdge);
            boxDrawing.getCurrenEdge().setCreate(false);
            boxDrawing.add(boxDrawing.getCurrenEdge());
        } else{
            boxDrawing.getCurrenEdge().setFinish(vertex);

           // boxDrawing.getCurrenEdge().setBounds(18+boxDrawing.getCurrenEdge().getStart().getX(),
             //       18 + boxDrawing.getCurrenEdge().getStart().getY(),
               //     boxDrawing.getCurrenEdge().getFinish().getX() - boxDrawing.getCurrenEdge().getStart().getX()-18,
                 //   boxDrawing.getCurrenEdge().getFinish().getY() - boxDrawing.getCurrenEdge().getStart().getY()-18);

            boxDrawing.getCurrenEdge().setCreate(true);
            //boxDrawing.getCurrenEdge().repaint();
            boxDrawing.setCurrenEdge(null);
        }
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
