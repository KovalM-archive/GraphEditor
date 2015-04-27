package mode;

import constants.VertexConst;
import graph.EdgeModel;
import graphview.EdgeView;
import graphview.WorkingArea;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DeleteEdgeListener implements MouseListener,MouseMotionListener {
    private WorkingArea boxDrawing;
    private EdgeView farEdge;

    public DeleteEdgeListener(WorkingArea boxDrawing){
        this.boxDrawing = boxDrawing;
        farEdge = null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (boxDrawing.getGreenEdge() != null){
            EdgeModel oldEdgeModel = boxDrawing.getGreenEdge().getEdgeRoot();
            boxDrawing.getGreenEdge().getStart().getVertexRoot().removeEdge(oldEdgeModel);
            boxDrawing.getGreenEdge().getFinish().getVertexRoot().removeEdge(oldEdgeModel);

            boxDrawing.getGreenEdge().getIdentifier().setVisible(false);
            boxDrawing.getGreenEdge().getStart().removeEdge(boxDrawing.getGreenEdge());
            boxDrawing.getGreenEdge().getFinish().removeEdge(boxDrawing.getGreenEdge());
            boxDrawing.getAllEdges().removeEdge(boxDrawing.getGreenEdge());
            boxDrawing.drawAllEdge();
            boxDrawing.setGreenEdge(null);
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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        double xMouse,yMouse,rast,x1,x2,y1,y2;
        double min = 9999999999.0;
        EdgeView currentEdge;

        xMouse = boxDrawing.getMousePosition().getX();
        yMouse = boxDrawing.getMousePosition().getY();

        int n = boxDrawing.getAllEdges().getNumberAllEdges();

        for (int i=0; i<n; i++){
            currentEdge = boxDrawing.getAllEdges().getEdgesAtIndex(i);
            x1 = currentEdge.getStart().getX() + VertexConst.VERTEX_SIZE_X / 2;
            y1 = currentEdge.getStart().getY() + VertexConst.VERTEX_SIZE_Y / 2;
            x2 = currentEdge.getFinish().getX() + VertexConst.VERTEX_SIZE_X / 2;
            y2 = currentEdge.getFinish().getY() + VertexConst.VERTEX_SIZE_Y / 2;

            if (x1 == x2 && y1 == y2){
                x2 = currentEdge.getFinish().getX() + VertexConst.VERTEX_SIZE_X / 2 + 50;
                y2 = currentEdge.getFinish().getY() + VertexConst.VERTEX_SIZE_Y / 2 - 25;
                int x3 = currentEdge.getFinish().getX() + VertexConst.VERTEX_SIZE_X / 2 + 50;
                int y3 = currentEdge.getFinish().getY() + VertexConst.VERTEX_SIZE_Y / 2 + 25;
                rast = Math.pow((x1-xMouse)*(x1-xMouse) + (y1-yMouse)*(y1-yMouse),0.5) +
                        Math.pow((xMouse-x2)*(xMouse-x2) + (yMouse-y2)*(yMouse-y2),0.5) -
                        Math.pow((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2),0.5);
                if (rast < min) {
                    min = rast;
                    farEdge = currentEdge;
                }

                rast = Math.pow((x1-xMouse)*(x1-xMouse) + (y1-yMouse)*(y1-yMouse),0.5) +
                        Math.pow((xMouse-x3)*(xMouse-x3) + (yMouse-y3)*(yMouse-y3),0.5) -
                        Math.pow((x1-x3)*(x1-x3) + (y1-y3)*(y1-y3),0.5);
                if (rast < min) {
                    min = rast;
                    farEdge = currentEdge;
                }

                rast = Math.pow((x3-xMouse)*(x3-xMouse) + (y3-yMouse)*(y3-yMouse),0.5) +
                        Math.pow((xMouse-x2)*(xMouse-x2) + (yMouse-y2)*(yMouse-y2),0.5) -
                        Math.pow((x3-x2)*(x3-x2) + (y3-y2)*(y3-y2),0.5);
                if (rast < min) {
                    min = rast;
                    farEdge = currentEdge;
                }
            }else{
                rast = Math.pow((x1-xMouse)*(x1-xMouse) + (y1-yMouse)*(y1-yMouse),0.5) +
                        Math.pow((xMouse-x2)*(xMouse-x2) + (yMouse-y2)*(yMouse-y2),0.5) -
                        Math.pow((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2),0.5);
                if (rast < min) {
                    min = rast;
                    farEdge = currentEdge;
                }
            }
        }

        if (min < 0.4) {
            boxDrawing.setColorBuffer(Color.green);
            if (farEdge.getStart().equals(farEdge.getFinish())) {
                boxDrawing.drawLoop(farEdge);
            }else{
                boxDrawing.drawEdge(farEdge);
            }
            boxDrawing.setGreenEdge(farEdge);
            boxDrawing.setColorBuffer(Color.black);
        } else {
            if (boxDrawing.getGreenEdge() != null){
                boxDrawing.setColorBuffer(Color.black);
                if (boxDrawing.getGreenEdge().getStart().equals(boxDrawing.getGreenEdge().getFinish())){
                    boxDrawing.drawLoop(boxDrawing.getGreenEdge());
                } else{
                    boxDrawing.drawEdge(boxDrawing.getGreenEdge());
                }
            }
            boxDrawing.setGreenEdge(null);
        }
    }
}
