package algoritmsmode;

import graphview.VertexView;
import graphview.WorkingArea;
import mode.ClickVertexListener;
import mode.CreateVertexListener;
import mode.MoveVertexListener;

import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Михаил on 25.04.2015.
 */
public abstract class AlgorithmModeListener implements ActionListener {
    protected JTabbedPane jtpVkladka;
    protected JToolBar jtbMain;
    protected JToolBar jtbAlgorithm;

    protected AlgorithmModeListener(JTabbedPane jtpVkladkaCopy,JToolBar jtbMainCopy,JToolBar jtbAlgorithmCopy){
        jtpVkladka = jtpVkladkaCopy;
        jtbAlgorithm = jtbAlgorithmCopy;
        jtbMain = jtbMainCopy;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton currentButton;

        for (int i=0; i<4; i++){
            currentButton = (JToggleButton) jtbMain.getComponentAtIndex(i);
            currentButton.setSelected(false);
            currentButton.setEnabled(false);
        }

        int count = jtbAlgorithm.getComponentCount();
        int numberNoSelectedButton = 0;
        for (int i=0; i<count; i++){
            currentButton = (JToggleButton) jtbAlgorithm.getComponentAtIndex(i);
            if (!currentButton.isSelected()){
                numberNoSelectedButton++;
            }
        }

        if (numberNoSelectedButton == count){
            returnToWorkWithGraph();
        } else{
            for (int i=0; i<count; i++){
                currentButton = (JToggleButton) jtbAlgorithm.getComponentAtIndex(i);
                if (e.getActionCommand().equals(currentButton.getActionCommand())){
                    currentButton.setSelected(true);
                }else{
                    currentButton.setSelected(false);
                }
            }
            changeMode();
        }
    }

    protected void returnToWorkWithGraph(){
        JToggleButton currentButton;
        int numberPanel = jtpVkladka.getComponentCount();
        for (int i = 0; i < numberPanel; i++) {
            WorkingArea currentPanel = (WorkingArea)jtpVkladka.getComponentAt(i);

            int numberLabel = currentPanel.getComponentCount();
            for (int j = 0; j < numberLabel; j++) {
                try {
                    VertexView currentVertex = (VertexView) currentPanel.getComponent(j);

                    MouseListener currentLabelListeners[] = currentVertex.getMouseListeners();

                    for (MouseListener currentListener : currentLabelListeners) {
                        currentVertex.removeMouseListener(currentListener);
                    }

                    currentVertex.addMouseMotionListener(new MoveVertexListener(currentVertex, currentPanel));
                    currentVertex.addMouseListener(new ClickVertexListener(currentVertex));

                } catch (Exception error){
                    System.out.println("No vertex");
                }
            }

            MouseListener currentPanelListeners[] = currentPanel.getMouseListeners();

            for (MouseListener currentListener : currentPanelListeners){
                currentPanel.removeMouseListener(currentListener);
            }

            MouseMotionListener currentPanelMotionListeners[] = currentPanel.getMouseMotionListeners();

            for (MouseMotionListener currentListener : currentPanelMotionListeners){
                currentPanel.removeMouseMotionListener(currentListener);
            }

            currentPanel.addMouseListener(new CreateVertexListener(currentPanel,jtbMain));
            currentPanel.setCursor(Cursor.getDefaultCursor());
        }

        currentButton = (JToggleButton) jtbMain.getComponentAtIndex(0);
        currentButton.setSelected(true);
        for (int i=0; i<4; i++){
            currentButton = (JToggleButton) jtbMain.getComponentAtIndex(i);
            currentButton.setEnabled(true);
        }
    }
    protected void changeMode(){

    }
}
