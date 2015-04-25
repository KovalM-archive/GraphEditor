package graph;

import graphview.VertexView;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<VertexView> vertexesGraph;

    public Graph(){
        vertexesGraph = new ArrayList<VertexView>();
    }

    public void addVertex(VertexView newVertex){
        vertexesGraph.add(newVertex);
    }

    public void removeVertex(VertexView oldVertex){
        vertexesGraph.remove(oldVertex);
    }

    public VertexView getVertexAtIndex(int x){
        if (x >= 0 && x < vertexesGraph.size()){
            return vertexesGraph.get(x);
        }
        else{
            return null;
        }
    }

    public int getVertexesGraphSize(){
        return vertexesGraph.size();
    }

    public VertexView getEdgeOfVertexAtIndex(VertexView currentVertex, int x){
        if (x >= 0 && x < currentVertex.getNumberEdges()){
            if (currentVertex.equals(currentVertex.getEdgesAtIndex(x).getFinish())) {
                return currentVertex.getEdgesAtIndex(x).getStart();
            } else {
                return currentVertex.getEdgesAtIndex(x).getFinish();
            }
        }
        else{
            return null;
        }

    }
}
