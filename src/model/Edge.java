package model;

import java.awt.BasicStroke;
import myConstants.EdgeConst;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Created by Михаил on 27.03.2015.
 */

public class Edge extends JPanel {
    private JLabel identifier;
    private Vertex start = null;
    private Vertex finish = null;
    private boolean isCreate = false;
    private boolean greenColor = false;
    private int currenDirection = 1;

    JPanel buffer;

    public Edge(JLabel identifierCopy) {
        setIdentifier(identifierCopy);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(2));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (greenColor) {
            g2d.setColor(Color.GREEN);
        } else {
            g2d.setColor(Color.BLACK);
        }

        if (currenDirection == EdgeConst.DIRECTION_SOUTH_EAST){
            g2d.drawLine(0, 0, this.getWidth(), this.getHeight());

        } else if (currenDirection == EdgeConst.DIRECTION_SOUTH_WEST){
            g2d.drawLine(this.getWidth(), 0, 0, this.getHeight());
        } else if (currenDirection == EdgeConst.DIRECTION_NORTH_WEST){
            g2d.drawLine(this.getWidth(),this.getHeight(),0,0);
        } else {
            g2d.drawLine(0, this.getHeight(),this.getWidth(),0);
        }

        this.setBackground(new Color(255,255,255,0));
    }

    public void setIdentifier(JLabel identifierCopy){
        identifier = identifierCopy;
    }

    public JLabel getIdentifier(){
        return identifier;
    }

    public Vertex getStart() {
        return start;
    }

    public void setStart(Vertex start) {
        this.start = start;
    }

    public Vertex getFinish() {
        return finish;
    }

    public void setFinish(Vertex finish) {
        this.finish = finish;
    }

    public boolean isCreate() {
        return isCreate;
    }

    public void setCreate(boolean isCreate) {
        this.isCreate = isCreate;
    }

    public int getCurrenDirection() {
        return currenDirection;
    }

    public void setCurrenDirection(int currenDirection) {
        this.currenDirection = currenDirection;
    }

    public boolean getGreenColor() {
        return greenColor;
    }

    public void setGreenColor(boolean greenColor) {
        this.greenColor = greenColor;
    }
}
