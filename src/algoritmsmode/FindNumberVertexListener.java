package algoritmsmode;

import graphview.WorkingArea;

import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class FindNumberVertexListener extends AlgorithmModeListener {
    protected JTabbedPane jtpVkladka;
    protected JToolBar jtbMain;
    protected JToolBar jtbAlgorithm;

    public FindNumberVertexListener(JTabbedPane jtpVkladkaCopy,JToolBar jtbMainCopy,JToolBar jtbAlgorithmCopy){
        super(jtpVkladkaCopy, jtbMainCopy, jtbAlgorithmCopy);
        jtpVkladka = jtpVkladkaCopy;
        jtbMain = jtbMainCopy;
        jtbAlgorithm = jtbAlgorithmCopy;
    }

    protected void changeMode(){
        WorkingArea boxDrawing = (WorkingArea) jtpVkladka.getSelectedComponent();
        boxDrawing.getGraphView().showNumberVertex();

        JToggleButton currentButton;
        int count = jtbAlgorithm.getComponentCount();
        for (int i=0; i<count; i++){
            currentButton = (JToggleButton) jtbAlgorithm.getComponentAtIndex(i);
            currentButton.setSelected(false);
        }
        returnToWorkWithGraph();
    }
}
