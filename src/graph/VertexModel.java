package graph;

import java.util.ArrayList;
import java.util.List;

public class VertexModel {
    private List<EdgeModel> edgeList;

    public VertexModel(){
        edgeList = new ArrayList<EdgeModel>();
    }

    public void addEdge(EdgeModel newEdge){
        edgeList.add(newEdge);
    }

    public void removeEdge(EdgeModel oldEdge){
        edgeList.remove(oldEdge);
    }

    public EdgeModel getEdgeAtIndex(int x){
        if (x >= 0 && x < edgeList.size()){
            return edgeList.get(x);
        }
        else{
            return null;
        }
    }

    public int getEdgeSize(){
        return edgeList.size();
    }
}
