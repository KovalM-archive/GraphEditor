package model;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Created by Михаил on 27.03.2015.
 */
public class WorkingArea extends JPanel{
    private Edge currenEdge = null;

    public Edge getCurrenEdge(){
        return currenEdge;
    }

    public void setCurrenEdge(Edge edge){
        currenEdge = edge;
    }
}
