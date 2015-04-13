package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Михаил on 09.04.2015.
 */
public class EdgesList {
    private List<Edge> edgesList = new ArrayList<Edge>();

    public int getNumberAllEdges(){
        return edgesList.size();
    }

    public Edge getEdgesOfNumber(int x){
        if (x >= 0 && x < edgesList.size()){
            return edgesList.get(x);
        }
        else{
            return null;
        }
    }

    public void addEdges(Edge edge){
        edgesList.add(edge);
    }

    public  void removeEdge(Edge edge){
        edgesList.remove(edge);
    }

}
