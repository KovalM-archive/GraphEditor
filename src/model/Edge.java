package model;

import com.sun.prism.BasicStroke;

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
    JPanel buffer;

    public Edge(JLabel identifierCopy) {
        setIdentifier(identifierCopy);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        //g2d.clearRect(0,0,this.getWidth(),this.getHeight());
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawLine(0, 0, this.getWidth(), this.getHeight());
        g2d.drawLine(this.getWidth(),this.getHeight(),this.getWidth()-10,this.getHeight()-20);
        g2d.drawLine(this.getWidth(),this.getHeight(),this.getWidth()-20,this.getHeight()-10);
        this.setBackground(new Color(255,255,255,0));
        g2d.setClip(null);
       // g2d.drawLine(0,0,this.getWidth(),this.getHeight());
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
}
