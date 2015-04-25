package graphview;

import java.util.ArrayList;
import java.util.List;

public class EdgesList {
    private List<EdgeView> edgesList = new ArrayList<EdgeView>();

    public int getNumberAllEdges(){
        return edgesList.size();
    }

    public EdgeView getEdgesAtIndex(int x){
        if (x >= 0 && x < edgesList.size()){
            return edgesList.get(x);
        }
        else{
            return null;
        }
    }

    public void addEdges(EdgeView edge){
        edgesList.add(edge);
    }

    public  void removeEdge(EdgeView edge){
        edgesList.remove(edge);
    }

}
