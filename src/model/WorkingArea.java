package model;

import myConstants.VertexConst;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * Created by Михаил on 09.04.2015.
 */
public class WorkingArea extends JPanel {
    private Edge currenEdge;
    private EdgesList allEdges;
    private BufferedImage buffer = null;
    private BufferedImage temp = null;
    private Color colorOfLine;
    private Edge greenEdge = null;

    public void setColorBuffer(Color clr){
        colorOfLine = clr;
    }

    public WorkingArea(){
        super();
        temp = new BufferedImage(1500,1500,BufferedImage.TYPE_INT_ARGB);
        buffer = new BufferedImage(1500,1500,BufferedImage.TYPE_INT_ARGB);
        allEdges = new EdgesList();
        colorOfLine = Color.black;
    }

    public Edge getCurrenEdge() {
        return currenEdge;
    }

    public void setCurrenEdge(Edge currenEdge) {
        this.currenEdge = currenEdge;
    }

    public void drawEdge(Edge currentEdge){
        Graphics pain = buffer.getGraphics();
        Graphics2D painter = (Graphics2D)pain;

        int x1,x2,y1,y2;

        painter.setStroke(new BasicStroke(4));
        painter.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        painter.setBackground(new Color(255,255,255,0));
        painter.setColor(colorOfLine);

        x1 = currentEdge.getStart().getX() + 9;
        y1 = currentEdge.getStart().getY() + 9;
        x2 = currentEdge.getFinish().getX() + 9;
        y2 = currentEdge.getFinish().getY() + 9;
        painter.drawLine(x1,y1,x2,y2);

        repaint();
    }

    public void drawEdgeTemp(int x1, int y1, int x2, int y2){
        Graphics pain = temp.getGraphics();
        Graphics2D painter = (Graphics2D)pain;

        painter.setStroke(new BasicStroke(4));
        painter.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        painter.setBackground(new Color(255,255,255,0));
        painter.setColor(Color.black);
        painter.clearRect(0, 0, 1500, 1500);
        painter.drawLine(x1,y1,x2,y2);

        repaint();
    }

    public void drawVertexsEdges(Vertex vertex){
        Graphics pain = buffer.getGraphics();
        Graphics2D painter = (Graphics2D)pain;

        painter.setStroke(new BasicStroke(4));
        painter.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        painter.setBackground(new Color(255,255,255,0));
        painter.setColor(Color.black);
        painter.clearRect(0, 0, 1500, 1500);

        int n = vertex.getNumberEdges();
        Edge currentEdge;
        int x1 = vertex.getX() + 9;
        int y1 = vertex.getY() + 9;
        int x2,y2;

        for (int i = 0; i<n; i++){
            currentEdge = vertex.getEdgesOfNumber(i);
            if (currentEdge.getStart().equals(vertex)){
                x2 = currentEdge.getFinish().getX() + 9;
                y2 = currentEdge.getFinish().getY() + 9;
            } else {
                x2 = currentEdge.getStart().getX() + 9;
                y2 = currentEdge.getStart().getY() + 9;
            }

            int x = Math.min(x1,x2) + Math.abs(x1-x2) / 2;
            int y = Math.min(y1,y2) + Math.abs(y1-y2) / 2;

            currentEdge.getIdentifier().setBounds(x, y, VertexConst.FONT_SIZE * 4, VertexConst.FONT_SIZE);

            painter.drawLine(x1, y1, x2, y2);
        }

        n = allEdges.getNumberAllEdges();

        for (int i = 0; i<n; i++){
            currentEdge = allEdges.getEdgesOfNumber(i);
            if (!currentEdge.getStart().equals(vertex) && !currentEdge.getFinish().equals(vertex)){
                x1 = currentEdge.getStart().getX() + 9;
                y1 = currentEdge.getStart().getY() + 9;
                x2 = currentEdge.getFinish().getX() + 9;
                y2 = currentEdge.getFinish().getY() + 9;

                int x = Math.min(x1,x2) + Math.abs(x1-x2) / 2;
                int y = Math.min(y1,y2) + Math.abs(y1-y2) / 2;

                currentEdge.getIdentifier().setBounds(x, y, VertexConst.FONT_SIZE * 4, VertexConst.FONT_SIZE);

                painter.drawLine(x1,y1,x2,y2);
            }
        }

        repaint();
    }

    public void drawAllEdge(){
        Graphics pain = buffer.getGraphics();
        Graphics2D painter = (Graphics2D)pain;

        painter.setStroke(new BasicStroke(4));
        painter.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        painter.setBackground(new Color(255,255,255,0));
        painter.setColor(Color.black);
        painter.clearRect(0, 0, 1500, 1500);

        Edge currentEdge;
        int x1,y1,x2,y2;
        int n = allEdges.getNumberAllEdges();

        for (int i = 0; i<n; i++){
            currentEdge = allEdges.getEdgesOfNumber(i);

            x1 = currentEdge.getStart().getX() + 9;
            y1 = currentEdge.getStart().getY() + 9;
            x2 = currentEdge.getFinish().getX() + 9;
            y2 = currentEdge.getFinish().getY() + 9;

            int x = Math.min(x1,x2) + Math.abs(x1-x2) / 2;
            int y = Math.min(y1,y2) + Math.abs(y1-y2) / 2;

            currentEdge.getIdentifier().setBounds(x, y, VertexConst.FONT_SIZE * 4, VertexConst.FONT_SIZE);

            painter.drawLine(x1,y1,x2,y2);

        }

        repaint();
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(buffer, null,null);
        if (currenEdge!=null) g2.drawImage(temp, null,null);
    }

    public EdgesList getAllEdges() {
        return allEdges;
    }

    public void setAllEdges(EdgesList allEdges) {
        this.allEdges = allEdges;
    }

    public Edge getGreenEdge() {
        return greenEdge;
    }

    public void setGreenEdge(Edge greenEdge) {
        this.greenEdge = greenEdge;
    }
}
