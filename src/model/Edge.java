package model;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * Created by Михаил on 27.03.2015.
 */
public class Edge extends JPanel {
    private JLabel identifier;

    public Edge(JLabel identifierCopy) {
        setIdentifier(identifierCopy);
    }
    public void setIdentifier(JLabel identifierCopy){
        identifier = identifierCopy;
    }

    public JLabel getIdentifier(){
        return identifier;
    }

    public void paintComponent(Graphics g){
        g.drawRect(0,0,10,10);
    }
}
