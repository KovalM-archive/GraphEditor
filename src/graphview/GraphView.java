package graphview;

import constants.VertexConst;
import graph.GraphModel;

import javax.swing.JOptionPane;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class GraphView {
    private GraphModel graphRoot;
    private List<VertexView> vertexesGraph;
    private WorkingArea boxDrawing;
    private VertexView start;

    public GraphView(WorkingArea boxDrawing){
        this.boxDrawing = boxDrawing;
        graphRoot = new GraphModel();
        vertexesGraph = new ArrayList<VertexView>();
        start = null;
    }

    public void addVertex(VertexView newVertex){
        vertexesGraph.add(newVertex);
    }

    public void removeVertex(VertexView oldVertex){
        vertexesGraph.remove(oldVertex);
    }

    public GraphModel getGraphRoot() {
        return graphRoot;
    }

    public void setGraphRoot(GraphModel graphRoot) {
        this.graphRoot = graphRoot;
    }

    private int minPath;
    private EdgesList answerPath;
    private EdgesList currentPath;

    public void showMinPath(VertexView start,VertexView finish){
        answerPath = null;
        currentPath = new EdgesList();
        minPath = 99999999;
        boxDrawing.setDoubleBuffered(false);
        dfs(start,finish,0);
        boxDrawing.setDoubleBuffered(true);
        if (minPath == 99999999){
            JOptionPane.showMessageDialog(boxDrawing,"Minimum path does not exist");
        } else{
            JOptionPane.showMessageDialog(boxDrawing,minPath);
        }

        if (null != answerPath) {
            int count = answerPath.getNumberAllEdges();
            boxDrawing.setColorBuffer(Color.black);
            for (int i = 0; i < count; i++) {
                boxDrawing.drawEdge(answerPath.getEdgesAtIndex(i));
            }
        }
    }

    private void dfs(VertexView currentVertex,VertexView finish,int lengthPath){
        if (currentVertex.equals(finish)){
            if (lengthPath < minPath){
                minPath = lengthPath;
                if (answerPath != null){
                    int count = answerPath.getNumberAllEdges();
                    boxDrawing.setColorBuffer(Color.black);
                    System.out.println("Erase old path " + count);
                    for (int i = 0; i < count; i++) {
                        boxDrawing.drawEdge(answerPath.getEdgesAtIndex(i));
                    }
                    answerPath = null;
                }

                int count = currentPath.getNumberAllEdges();
                answerPath = new EdgesList();
                for (int i = 0; i < count; i++) {
                    answerPath.addEdges(currentPath.getEdgesAtIndex(i));
                }

                count = answerPath.getNumberAllEdges();
                System.out.println("Create new path " + count);
                boxDrawing.setColorBuffer(Color.green);
                for (int i = 0; i < count; i++) {
                    boxDrawing.drawEdge(answerPath.getEdgesAtIndex(i));
                }
                boxDrawing.setColorBuffer(Color.black);
                long t0=System.currentTimeMillis();
                do { }
                while(System.currentTimeMillis()-t0 < 2000);

            }
        }
        else{
            int n = currentVertex.getNumberEdges();
            for (int i = 0; i < n; i++) {
                EdgeView currentEdge = currentVertex.getEdgesAtIndex(i);
                if (currentEdge.getStart().equals(currentVertex)){
                    VertexView candidate = currentEdge.getFinish();

                    int m = currentPath.getNumberAllEdges();
                    boolean flag = false;

                    for (int j = 0; j < m; j++){
                        if (currentPath.getEdgesAtIndex(j).getStart().equals(candidate) ||
                                currentPath.getEdgesAtIndex(j).getFinish().equals(candidate)){
                            flag = true;
                            break;
                        }
                    }
                    if (!flag){
                        currentPath.addEdges(currentEdge);

                        System.out.println("draw in yellow");
                        boxDrawing.setColorBuffer(Color.yellow);
                        boxDrawing.drawEdge(currentEdge);
                        boxDrawing.setColorBuffer(Color.black);

                        long t0 = System.currentTimeMillis();
                        do { }
                        while(System.currentTimeMillis()-t0 < 2000);

                        dfs(candidate, finish, lengthPath + currentEdge.getEdgeRoot().getWeight());

                        flag = false;
                        if (answerPath != null) {
                            int count = answerPath.getNumberAllEdges();
                            for (int j = 0; j < count; j++) {
                                if (answerPath.getEdgesAtIndex(j).equals(currentEdge)) {
                                    flag = true;
                                    break;
                                }
                            }
                        }

                        if (!flag){
                            System.out.println("draw in black");
                            boxDrawing.setColorBuffer(Color.black);
                            boxDrawing.drawEdge(currentEdge);
                        }
                        currentPath.removeEdge(currentEdge);
                    }
                }
            }
        }
    }

    public VertexView getStart() {
        return start;
    }

    public void setStart(VertexView start) {
        this.start = start;
    }
}
