package mode;

import graphview.EdgeView;
import graphview.WorkingArea;
import constants.VertexConst;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ChangeEdgeName implements MouseMotionListener,MouseListener {
    private WorkingArea boxDrawing;
    private EdgeView farEdge;

    public ChangeEdgeName(WorkingArea boxDrawing){
        this.boxDrawing = boxDrawing;
        farEdge = null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (boxDrawing.getGreenEdge() != null){
            String newNameVertex = "";
            boolean flag;
            try {
                while (true) {
                    newNameVertex = JOptionPane.showInputDialog("Enter name of edge:");
                    flag = false;
                    for (int i = 0; i<newNameVertex.length(); i++){
                        if (!('0' <= newNameVertex.charAt(i) && newNameVertex.charAt(i) <= '9')){
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        break;
                    }
                }
            } catch (Exception error){
                newNameVertex = "";
            }

            int weight = 0;
            for (int i=0; i<newNameVertex.length(); i++){
                weight = weight*10 + (int)newNameVertex.charAt(i)-48;
            }

            boxDrawing.getGreenEdge().getEdgeRoot().setWeight(weight);
            boxDrawing.getGreenEdge().getIdentifier().setFont(new Font("Verdana",Font.PLAIN,VertexConst.FONT_SIZE));
            boxDrawing.getGreenEdge().getIdentifier().setBounds(
                    boxDrawing.getGreenEdge().getIdentifier().getX(),
                    boxDrawing.getGreenEdge().getIdentifier().getY(),
                    VertexConst.FONT_SIZE * newNameVertex.length(),
                    VertexConst.FONT_SIZE);

            boxDrawing.getGreenEdge().getIdentifier().setText(newNameVertex);
            boxDrawing.getGreenEdge().getIdentifier().updateUI();
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
            x1 = currentEdge.getStart().getX() + 9;
            y1 = currentEdge.getStart().getY() + 9;
            x2 = currentEdge.getFinish().getX() + 9;
            y2 = currentEdge.getFinish().getY() + 9;

            rast = Math.pow((x1-xMouse)*(x1-xMouse) + (y1-yMouse)*(y1-yMouse),0.5) +
                    Math.pow((xMouse-x2)*(xMouse-x2) + (yMouse-y2)*(yMouse-y2),0.5) -
                    Math.pow((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2),0.5);
            if (rast < min) {
                min = rast;
                farEdge = currentEdge;
            }
        }

        if (min < 0.4) {
            boxDrawing.setColorBuffer(Color.green);
            boxDrawing.drawEdge(farEdge);
            boxDrawing.setGreenEdge(farEdge);
            boxDrawing.setColorBuffer(Color.black);
        } else {
            if (boxDrawing.getGreenEdge() != null){
                boxDrawing.setColorBuffer(Color.black);
                boxDrawing.drawEdge(boxDrawing.getGreenEdge());
            }
            boxDrawing.setGreenEdge(null);
        }
    }
}
