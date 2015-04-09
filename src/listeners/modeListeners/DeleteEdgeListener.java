package listeners.modeListeners;

import model.Edge;
import model.WorkingArea;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static java.lang.StrictMath.abs;

/**
 * Created by Михаил on 06.04.2015.
 */
public class DeleteEdgeListener implements MouseListener,MouseMotionListener {
    private Edge currenEdge;
    private WorkingArea boxDrawing;

    public DeleteEdgeListener(Edge currentEdge, WorkingArea boxDrawing){
        this.currenEdge = currentEdge;
        this.boxDrawing = boxDrawing;
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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point mouse = currenEdge.getMousePosition();
        double rast;
        rast = Math.sqrt(mouse.getX()*mouse.getX()+mouse.getY()*mouse.getY()) +
                Math.sqrt(Math.pow(mouse.getX()-currenEdge.getWidth(),2) + Math.pow(mouse.getY()-currenEdge.getHeight(),2)) -
                Math.sqrt(Math.pow(currenEdge.getWidth(),2) + Math.pow(currenEdge.getHeight(),2));

        System.out.println(rast);
        if (abs(rast)<1){
            currenEdge.setGreenColor(true);
            boxDrawing.repaint();
        }
        else {
            currenEdge.setGreenColor(false);
            boxDrawing.repaint();
        }
    }
}
