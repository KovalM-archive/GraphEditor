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

public class Edge {
    private JLabel identifier;
    private Vertex start = null;
    private Vertex finish = null;
    private boolean isCreate = false;

    public Edge(JLabel identifierCopy) {
        setIdentifier(identifierCopy);
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
