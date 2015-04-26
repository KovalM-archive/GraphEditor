package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphModel {
    private List<VertexModel> vertexesGraph;

    public GraphModel(){
        vertexesGraph = new ArrayList<VertexModel>();
    }

    public void addVertex(VertexModel newVertex){
        vertexesGraph.add(newVertex);
    }

    public void removeVertex(VertexModel oldVertex){
        vertexesGraph.remove(oldVertex);
    }

    public VertexModel getVertexAtIndex(int x){
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

    public List<VertexModel> findMinPath(VertexModel start,VertexModel finish){
        List<VertexModel> answer = new ArrayList<VertexModel>();
        return answer;
    }

    private void printGraph(){
        int n = vertexesGraph.size();
        VertexModel currentVertex;
        EdgeModel currentEdge;

        for (int i = 0; i<n; i++){
            currentVertex = vertexesGraph.get(i);
            System.out.println(currentVertex);

            int m = currentVertex.getEdgeSize();
            for (int j=0; j<m; j++){
                currentEdge = currentVertex.getEdgeAtIndex(j);
                System.out.println(currentEdge.getStart()+" "+currentEdge.getFinish()+" "+currentEdge.getWeight());
            }
        }
    }
}
