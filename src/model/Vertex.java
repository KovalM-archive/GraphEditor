package model;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * Created by Михаил on 24.03.2015.
 */
public class Vertex extends JLabel{
    private JLabel identifier;

    public Vertex(ImageIcon imageVertex,JLabel identifierCopy){
        super(imageVertex);
        setIdentifier(identifierCopy);
    }

  /*  public void setVertex(JLabel vertexCopy){
        vertex = vertexCopy;
    }

    public JLabel getVertex(){
        return vertex;
    }
*/
    public void setIdentifier(JLabel identifierCopy){
        identifier = identifierCopy;
    }

    public JLabel getIdentifier(){
        return identifier;
    }
}
