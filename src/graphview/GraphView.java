package graphview;

import graph.GraphModel;

public class GraphView {
    private GraphModel graphRoot;

    public GraphView(){
        graphRoot = new GraphModel();
    }

    public GraphModel getGraphRoot() {
        return graphRoot;
    }

    public void setGraphRoot(GraphModel graphRoot) {
        this.graphRoot = graphRoot;
    }

    public void showMinPath(VertexView start,VertexView finish){
        graphRoot.findMinPath(start.getVertexRoot(),finish.getVertexRoot());
    }
}
