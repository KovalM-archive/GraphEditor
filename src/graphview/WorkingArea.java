package graphview;

import constants.EdgeConst;
import constants.VertexConst;
import graph.Graph;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class WorkingArea extends JPanel {
    private EdgeView currenEdge;
    private EdgesList allEdges;
    private BufferedImage buffer;
    private BufferedImage temp;
    private Color colorOfLine;
    private EdgeView greenEdge;

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

    public EdgeView getCurrenEdge() {
        return currenEdge;
    }

    public void setCurrenEdge(EdgeView currenEdge) {
        this.currenEdge = currenEdge;
    }

    public void drawEdge(EdgeView currentEdge){
        Graphics pain = buffer.getGraphics();
        Graphics2D painter = (Graphics2D)pain;

        int x1,x2,y1,y2;

        painter.setStroke(new BasicStroke(4));
        painter.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        painter.setBackground(new Color(255,255,255,0));
        painter.setColor(colorOfLine);

        x1 = currentEdge.getStart().getX() + VertexConst.VERTEX_SIZE_X / 2;
        y1 = currentEdge.getStart().getY() + VertexConst.VERTEX_SIZE_Y / 2;
        x2 = currentEdge.getFinish().getX() + VertexConst.VERTEX_SIZE_X / 2;
        y2 = currentEdge.getFinish().getY() + VertexConst.VERTEX_SIZE_Y / 2;
        painter.drawLine(x1,y1,x2,y2);
        drawTip(painter,x1,y1,x2,y2);

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
        drawTip(painter,x1,y1,x2,y2);

        repaint();
    }

    public void drawVertexsEdges(VertexView vertex){
        Graphics pain = buffer.getGraphics();
        Graphics2D painter = (Graphics2D)pain;

        painter.setStroke(new BasicStroke(4));
        painter.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        painter.setBackground(new Color(255,255,255,0));
        painter.setColor(Color.black);
        painter.clearRect(0, 0, 1500, 1500);

        int n = vertex.getNumberEdges();
        EdgeView currentEdge;
        int x1 = vertex.getX() + VertexConst.VERTEX_SIZE_X / 2;
        int y1 = vertex.getY() + VertexConst.VERTEX_SIZE_Y / 2;
        int x2,y2;

        for (int i = 0; i<n; i++){
            currentEdge = vertex.getEdgesAtIndex(i);
            if (currentEdge.getStart().equals(vertex)){
                x2 = currentEdge.getFinish().getX() + VertexConst.VERTEX_SIZE_X / 2;
                y2 = currentEdge.getFinish().getY() + VertexConst.VERTEX_SIZE_Y / 2;
                painter.drawLine(x1, y1, x2, y2);
                drawTip(painter,x1,y1,x2,y2);
            } else {
                x2 = currentEdge.getStart().getX() + VertexConst.VERTEX_SIZE_X / 2;
                y2 = currentEdge.getStart().getY() + VertexConst.VERTEX_SIZE_Y / 2;
                painter.drawLine(x1, y1, x2, y2);
                drawTip(painter,x2,y2,x1,y1);
            }

            int x = Math.min(x1,x2) + Math.abs(x1-x2) / 2;
            int y = Math.min(y1,y2) + Math.abs(y1-y2) / 2;

            currentEdge.getIdentifier().setBounds(x, y, VertexConst.FONT_SIZE * 4, VertexConst.FONT_SIZE);
        }

        n = allEdges.getNumberAllEdges();

        for (int i = 0; i<n; i++){
            currentEdge = allEdges.getEdgesAtIndex(i);
            if (!currentEdge.getStart().equals(vertex) && !currentEdge.getFinish().equals(vertex)){
                x1 = currentEdge.getStart().getX() + VertexConst.VERTEX_SIZE_X / 2;
                y1 = currentEdge.getStart().getY() + VertexConst.VERTEX_SIZE_Y / 2;
                x2 = currentEdge.getFinish().getX() + VertexConst.VERTEX_SIZE_X / 2;
                y2 = currentEdge.getFinish().getY() + VertexConst.VERTEX_SIZE_Y / 2;

                int x = Math.min(x1,x2) + Math.abs(x1-x2) / 2;
                int y = Math.min(y1,y2) + Math.abs(y1-y2) / 2;

                currentEdge.getIdentifier().setBounds(x, y, VertexConst.FONT_SIZE * 4, VertexConst.FONT_SIZE);
                painter.drawLine(x1,y1,x2,y2);
                drawTip(painter,x1,y1,x2,y2);
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

        EdgeView currentEdge;
        int x1,y1,x2,y2;
        int n = allEdges.getNumberAllEdges();

        for (int i = 0; i<n; i++){
            currentEdge = allEdges.getEdgesAtIndex(i);
            x1 = currentEdge.getStart().getX() + VertexConst.VERTEX_SIZE_X / 2;
            y1 = currentEdge.getStart().getY() + VertexConst.VERTEX_SIZE_Y / 2;
            x2 = currentEdge.getFinish().getX() + VertexConst.VERTEX_SIZE_X / 2;
            y2 = currentEdge.getFinish().getY() + VertexConst.VERTEX_SIZE_Y / 2;

            int x = Math.min(x1,x2) + Math.abs(x1-x2) / 2;
            int y = Math.min(y1,y2) + Math.abs(y1-y2) / 2;

            currentEdge.getIdentifier().setBounds(x, y, VertexConst.FONT_SIZE * 4, VertexConst.FONT_SIZE);
            painter.drawLine(x1,y1,x2,y2);
            drawTip(painter,x1,y1,x2,y2);
        }
        repaint();
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(buffer, null,null);
        if (currenEdge!=null) g2.drawImage(temp, null,null);
    }

    protected void drawTip(Graphics2D painter,int x1, int y1, int x2,int y2){
        if (x1!=x2 && y1!=y2) {
            double d, alpha, n, a, b, c, xLeft, yLeft, xRight, yRight;

            d = EdgeConst.EDGE_TIP;
            n = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            alpha = (x1 * x1 - x2 * x2 + y1 * y1 - y2 * y2 - n * n + 2 * Math.sqrt(3) * d * n) / (2 * (x1 - x2));
            a = Math.pow((y2 - y1), 2) / Math.pow(x1 - x2, 2) + 1;
            b = (2 * (y2 - y1) * (alpha - x2)) / (x1 - x2) - 2 * y2;
            c = Math.pow(alpha - x2, 2) - 4 * d * d + y2 * y2;

            yLeft = (Math.sqrt(b * b - 4 * a * c) - b) / (2 * a);
            xLeft = yLeft * (y2 - y1) / (x1 - x2) + alpha;
            yRight = ((-1) * Math.sqrt(b * b - 4 * a * c) - b) / (2 * a);
            xRight = yRight * (y2 - y1) / (x1 - x2) + alpha;

            painter.drawLine(x2, y2, (int) xLeft, (int) yLeft);
            painter.drawLine(x2, y2, (int) xRight, (int) yRight);

        }
    }

    public EdgesList getAllEdges() {
        return allEdges;
    }

    public void setAllEdges(EdgesList allEdges) {
        this.allEdges = allEdges;
    }

    public EdgeView getGreenEdge() {
        return greenEdge;
    }

    public void setGreenEdge(EdgeView greenEdge) {
        this.greenEdge = greenEdge;
    }
}
