package model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Михаил on 24.03.2015.
 */
public class Vertex extends JLabel{
    private JLabel identifier;
    private List<Edge> vertexEdges = new ArrayList<Edge>();

    public Vertex(ImageIcon imageVertex,JLabel identifierCopy){
        super(imageVertex);
        this.setBackground(new Color(255,255,255,0));
        setIdentifier(identifierCopy);
    }

    public void addEdge(Edge edge){
        vertexEdges.add(edge);
    }

    public  void removeEdge(Edge edge){
        vertexEdges.remove(edge);
    }

    public Edge getEdgesOfNumber(int x){
        if (x >= 0 && x < vertexEdges.size()){
            return vertexEdges.get(x);
        }
        else{
            return null;
        }
    }

    public int getNumberEdges(){
        return vertexEdges.size();
    }

    public void setIdentifier(JLabel identifierCopy){
        identifier = identifierCopy;
    }

    public JLabel getIdentifier(){
        return identifier;
    }
}
