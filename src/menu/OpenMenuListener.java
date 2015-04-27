package menu;

import graphview.WorkingArea;
import mode.CreateVertexListener;

import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Михаил on 27.04.2015.
 */
public class OpenMenuListener implements ActionListener {
    private JTabbedPane jtpVkladka;
    private JToolBar jtbMain;
    private JToolBar jtbAlgoritms;
    private JFileChooser jFileChooser;
    private WorkingArea newPanel;

    public OpenMenuListener(JTabbedPane jtpVkladka,JToolBar jtbMainCopy,JToolBar jtbAlgoritmsCopy){
        this.jtpVkladka = jtpVkladka;
        jtbMain = jtbMainCopy;
        jtbAlgoritms = jtbAlgoritmsCopy;
        jFileChooser = new JFileChooser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int result = jFileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            if (jFileChooser.getSelectedFile().getName().contains(".xml")) {
                newPanel = new WorkingArea();
                newPanel.setLayout(null);
                newPanel.addMouseListener(new CreateVertexListener(newPanel, jtbMain));
                newPanel.setPreferredSize(new Dimension(newPanel.getWidth(),newPanel.getHeight()));
                newPanel.setBackground(Color.white);
                jtpVkladka.add("No name", newPanel);
                jtpVkladka.setSelectedComponent(newPanel);
                jtbMain.setVisible(true);
                jtbAlgoritms.setVisible(true);

                jtpVkladka.setTitleAt(jtpVkladka.getSelectedIndex(), jFileChooser.getSelectedFile().getName());
                new XMLFile(jFileChooser.getSelectedFile().getPath(), jtpVkladka).readFile();
            }
        }
    }
}
