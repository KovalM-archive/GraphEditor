package graphview;

import graph.EdgeModel;

import javax.swing.JLabel;

public class EdgeView {
    private JLabel identifier;
    private VertexView start;
    private VertexView finish;
    private EdgeModel edgeRoot;

    public EdgeView(JLabel identifierCopy) {
        setIdentifier(identifierCopy);
    }

    public void setIdentifier(JLabel identifierCopy){
        identifier = identifierCopy;
    }

    public JLabel getIdentifier(){
        return identifier;
    }

    public VertexView getStart() {
        return start;
    }

    public void setStart(VertexView start) {
        this.start = start;
    }

    public VertexView getFinish() {
        return finish;
    }

    public void setFinish(VertexView finish) {
        this.finish = finish;
    }

    public EdgeModel getEdgeRoot() {
        return edgeRoot;
    }

    public void setEdgeRoot(EdgeModel edgeRoot) {
        this.edgeRoot = edgeRoot;
    }
}
