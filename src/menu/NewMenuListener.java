package menu;

import graphview.WorkingArea;
import mode.CreateVertexListener;

import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewMenuListener implements ActionListener {
    private JToolBar jtbMain;
    private JToolBar jtbAlgoritms;
    private JTabbedPane jtpVkladka;
    private WorkingArea newPanel;

    public NewMenuListener(JTabbedPane jtpVkladkaCopy, JToolBar jtbMainCopy,JToolBar jtbAlgoritmsCopy) {
        jtpVkladka = jtpVkladkaCopy;
        jtbMain = jtbMainCopy;
        jtbAlgoritms = jtbAlgoritmsCopy;
    }

    public void actionPerformed(ActionEvent ae) {
        newPanel = new WorkingArea();
        newPanel.setLayout(null);

        JToggleButton currentMode = (JToggleButton)jtbMain.getComponentAtIndex(0);
        if (currentMode.isSelected()){
            newPanel.addMouseListener(new CreateVertexListener(newPanel, jtbMain));
        }

        newPanel.setBackground(Color.white);
        //JScrollPane jScroll = new JScrollPane(newPanel);
        //jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        jtpVkladka.add("No name", newPanel);
        jtpVkladka.setSelectedComponent(newPanel);

        jtbMain.setVisible(true);
        jtbAlgoritms.setVisible(true);
    }

}
