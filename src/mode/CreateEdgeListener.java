package mode;

import graph.EdgeModel;
import graphview.EdgeView;
import graphview.VertexView;
import graphview.WorkingArea;
import constants.VertexConst;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateEdgeListener extends MouseAdapter {
    private VertexView vertex;
    private WorkingArea boxDrawing;
    private EdgeView newEdge;

    public CreateEdgeListener(VertexView vertexCopy, WorkingArea boxDrawingCopy) {
        vertex = vertexCopy;
        boxDrawing = boxDrawingCopy;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (boxDrawing.getCurrentEdge() == null) {
            newEdge = new EdgeView(new JLabel(""));
            newEdge.setStart(vertex);
            boxDrawing.setCurrentEdge(newEdge);
        } else {
            newEdge = boxDrawing.getCurrentEdge();
            newEdge.setFinish(vertex);

            int x1 = newEdge.getStart().getX() + VertexConst.VERTEX_SIZE_X / 2;
            int y1 = newEdge.getStart().getY() + VertexConst.VERTEX_SIZE_Y / 2;
            int x2 = newEdge.getFinish().getX() + VertexConst.VERTEX_SIZE_X / 2;
            int y2 = newEdge.getFinish().getY() + VertexConst.VERTEX_SIZE_Y / 2;

            int x,y;

            if (x1==x2 && y1==y2){
                x = x1 + 50;
                y = y1;
                boxDrawing.drawLoop(boxDrawing.getCurrentEdge());
            }else{
                x = Math.min(x1, x2) + Math.abs(x1 - x2) / 2;
                y = Math.min(y1, y2) + Math.abs(y1 - y2) / 2;
                boxDrawing.drawEdge(boxDrawing.getCurrentEdge());
            }

            newEdge.getIdentifier().setBounds(x, y, VertexConst.FONT_SIZE * 4, VertexConst.FONT_SIZE);
            newEdge.getStart().addEdge(boxDrawing.getCurrentEdge());
            if (!(x1 == x2 && y1 == y2)){
                newEdge.getFinish().addEdge(boxDrawing.getCurrentEdge());
            }

            boxDrawing.getAllEdges().addEdges(boxDrawing.getCurrentEdge());
            boxDrawing.add(newEdge.getIdentifier());

            EdgeModel newEdgeModel = new EdgeModel(newEdge.getStart().getVertexRoot(),newEdge.getFinish().getVertexRoot());
            newEdge.setEdgeRoot(newEdgeModel);
            newEdge.getStart().getVertexRoot().addEdge(newEdgeModel);
            if (!(x1 == x2 && y1 == y2)){
                newEdge.getFinish().getVertexRoot().addEdge(newEdgeModel);
            }

            boxDrawing.setCurrentEdge(null);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        vertex.setIcon(VertexConst.GREEN_VERTEX_IMAGE);
        vertex.updateUI();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        vertex.setIcon(VertexConst.GREY_VERTEX_IMAGE);
        vertex.updateUI();
    }
}
