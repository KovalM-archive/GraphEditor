package graphview;

import graph.VertexModel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class VertexView extends JLabel{
    private JLabel identifier;
    private List<EdgeView> vertexEdges;
    private VertexModel vertexRoot;

    public VertexView(ImageIcon imageVertex, JLabel identifierCopy){
        super(imageVertex);
        this.setBackground(new Color(255,255,255,0));
        setIdentifier(identifierCopy);
        vertexEdges = new ArrayList<EdgeView>();
    }

    public void addEdge(EdgeView edge){
        vertexEdges.add(edge);
    }

    public  void removeEdge(EdgeView edge){
        vertexEdges.remove(edge);
    }

    public EdgeView getEdgesAtIndex(int x){
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

    public VertexModel getVertexRoot() {
        return vertexRoot;
    }

    public void setVertexRoot(VertexModel vertexRoot) {
        this.vertexRoot = vertexRoot;
    }
}
