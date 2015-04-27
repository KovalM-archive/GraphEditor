package menu;

import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveMenuListener implements ActionListener {
    private JTabbedPane jtpVkladka;
    private JFileChooser jFileChooser;

    public SaveMenuListener(JTabbedPane jtpVkladka) {
        this.jtpVkladka = jtpVkladka;
        jFileChooser = new JFileChooser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( jFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION ) {
            try {
                new XMLFile(jFileChooser.getSelectedFile().getPath(), jtpVkladka).writeFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (TransformerException e1) {
                e1.printStackTrace();
            } catch (ParserConfigurationException e1) {
                e1.printStackTrace();
            }
        }
    }
}
