package listeners;

import mediators.CursorScin;
import mediators.ToolBarMediator;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Михаил on 27.02.2015.
 */
public class NewMenuListener implements ActionListener {

    JToolBar jtbMain;
    JTabbedPane jtpVkladka;
    JPanel newPanel;

    public NewMenuListener(JTabbedPane jtpVkladkaCopy, JToolBar jtbMainCopy) {

        jtpVkladka = jtpVkladkaCopy;
        jtbMain = jtbMainCopy;
    }

    public void actionPerformed(ActionEvent ae) {
        //Scanner scan = new Scanner(System.in);
        //String c = scan.nextLine();
        newPanel = new JPanel();
        newPanel.setLayout(null);

        JToggleButton currentMode = (JToggleButton)jtbMain.getComponentAtIndex(0);//&&&&&
        if (currentMode.isSelected()){
            newPanel.addMouseListener(new BoxDrawingListener(newPanel, jtbMain));
        }

        newPanel.setBackground(Color.white);

        //JScrollPane jScroll = new JScrollPane(newPanel);
        //jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        jtpVkladka.add("No name", newPanel);
        jtpVkladka.setSelectedComponent(newPanel);

        jtbMain.setVisible(true);
    }

}
