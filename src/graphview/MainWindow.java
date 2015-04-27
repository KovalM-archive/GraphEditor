package graphview;

import algoritmsmode.FindMinPathListener;
import algoritmsmode.FindNumberEdgeListener;
import algoritmsmode.FindNumberVertexListener;
import menu.ExitMenuListener;
import menu.NewMenuListener;
import menu.OpenMenuListener;
import menu.SaveMenuListener;
import mode.ChangeIdentifierModeListener;
import mode.CreateEdgeModeListener;
import mode.CreateMoveVertexModeListener;
import mode.DeleteModeListener;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MainWindow {

    MainWindow(){

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame jfMainWin = new JFrame("Graph editor");

        jfMainWin.setLayout(new BorderLayout());

        jfMainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfMainWin.setSize(600, 600);
        jfMainWin.setLocationRelativeTo(null);

        JTabbedPane jtpVkladka = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.WRAP_TAB_LAYOUT);
        JScrollPane jScroll = new JScrollPane(jtpVkladka);
        jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jfMainWin.add(jScroll, BorderLayout.CENTER);

        JMenuBar jmbMain = new JMenuBar();
        JMenu jmFile = new JMenu("File");
        jmFile.setMnemonic(KeyEvent.VK_F);

        JMenuItem jmiCreate = new JMenuItem("New", KeyEvent.VK_N);
        jmiCreate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        JMenuItem jmiOpen = new JMenuItem("Open",KeyEvent.VK_O);
        jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        JMenuItem jmiSave = new JMenuItem("Save", KeyEvent.VK_S);
        JMenuItem jmiExit = new JMenuItem("Exit",KeyEvent.VK_Q);
        jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));

        jmFile.add(jmiCreate);
        jmFile.add(jmiOpen);
        jmFile.add(jmiSave);
        jmFile.add(jmiExit);
        jmbMain.add(jmFile);
        jfMainWin.setJMenuBar(jmbMain);

        JToolBar jtbMain = new JToolBar("Work with area",JToolBar.VERTICAL);
        ImageIcon imVertex = new ImageIcon("image\\toolbarArea\\VertexButton.png");
        ImageIcon imEdge = new ImageIcon("image\\toolbarArea\\EdgeButton.png");
        ImageIcon imChanges = new ImageIcon("image\\toolbarArea\\ChangesButton.png");
        ImageIcon imDelete = new ImageIcon("image\\toolbarArea\\DeleteButton.png");

        JToggleButton jbtVertex = new JToggleButton(imVertex,false);
        jbtVertex.setActionCommand("Vertex");
        jbtVertex.setSelected(true);
        JToggleButton jbtEdge = new JToggleButton(imEdge,false);
        jbtEdge.setActionCommand("Edge");
        JToggleButton jbtChanges = new JToggleButton(imChanges,false);
        jbtChanges.setActionCommand("Changes");
        JToggleButton jbtDelete = new JToggleButton(imDelete,false);
        jbtDelete.setActionCommand("Delete");

        jtbMain.add(jbtVertex);
        jtbMain.add(jbtEdge);
        jtbMain.add(jbtChanges);
        jtbMain.add(jbtDelete);

        jtbMain.setFloatable(false);
        jtbMain.setVisible(false);
        jfMainWin.add(jtbMain,BorderLayout.WEST);

        JToolBar jtbFile = new JToolBar("Work with file",JToolBar.HORIZONTAL);

        ImageIcon imNew = new ImageIcon("image\\toolbarFile\\NewButton.png");
        ImageIcon imOpen = new ImageIcon("image\\toolbarFile\\OpenButton.png");
        ImageIcon imSave = new ImageIcon("image\\toolbarFile\\SaveButton.png");

        JButton jbNew = new JButton(imNew);
        jbNew.setActionCommand("New");
        JButton jbOpen = new JButton(imOpen);
        jbOpen.setActionCommand("Open");
        JButton jbSave = new JButton(imSave);
        jbSave.setActionCommand("Save");

        jtbFile.add(jbNew);
        jtbFile.add(jbOpen);
        jtbFile.add(jbSave);
        jtbFile.setFloatable(false);
        jtbFile.setVisible(true);
        jfMainWin.add(jtbFile,BorderLayout.NORTH);

        JToolBar jtbAlgorithm = new JToolBar("Work with graph",JToolBar.VERTICAL);
        JToggleButton jbtFindMinPath = new JToggleButton("Find min path");
        jbtFindMinPath.setActionCommand("FindMinPath");
        jbtFindMinPath.setMargin(new Insets(0, 10, 10, 10));

        JToggleButton jbtFindNumberVertexs = new JToggleButton("Find number of vertex");
        jbtFindNumberVertexs.setActionCommand("FindNumberVertex");
        jbtFindNumberVertexs.setMargin(new Insets(0, 10, 10, 10));

        JToggleButton jbtFindNumberEdges = new JToggleButton("Find number of edge");
        jbtFindNumberEdges.setActionCommand("FindNumberEdge");
        jbtFindNumberEdges.setMargin(new Insets(0, 10, 10, 10));

        jtbAlgorithm.add(jbtFindMinPath);
        jtbAlgorithm.add(jbtFindNumberVertexs);
        jtbAlgorithm.add(jbtFindNumberEdges);

        jtbAlgorithm.setFloatable(false);
        jtbAlgorithm.setVisible(false);
        jfMainWin.add(jtbAlgorithm,BorderLayout.EAST);

        NewMenuListener newMenuListener = new NewMenuListener(jtpVkladka,jtbMain,jtbAlgorithm);
        jmiCreate.addActionListener(newMenuListener);
        jbNew.addActionListener(newMenuListener);

        SaveMenuListener saveMenuListener = new SaveMenuListener(jtpVkladka);
        jmiSave.addActionListener(saveMenuListener);
        jbSave.addActionListener(saveMenuListener);

        OpenMenuListener openMenuListener = new OpenMenuListener(jtpVkladka,jtbMain,jtbAlgorithm);
        jmiOpen.addActionListener(openMenuListener);
        jbOpen.addActionListener(openMenuListener);

        jmiExit.addActionListener(new ExitMenuListener());

        jbtFindMinPath.addActionListener(new FindMinPathListener(jtpVkladka,jtbMain,jtbAlgorithm));
        jbtFindNumberVertexs.addActionListener(new FindNumberVertexListener(jtpVkladka,jtbMain,jtbAlgorithm));
        jbtFindNumberEdges.addActionListener(new FindNumberEdgeListener(jtpVkladka,jtbMain,jtbAlgorithm));
        jbtVertex.addActionListener(new CreateMoveVertexModeListener(jtpVkladka,jtbMain));
        jbtEdge.addActionListener(new CreateEdgeModeListener(jtpVkladka,jtbMain));
        jbtChanges.addActionListener(new ChangeIdentifierModeListener(jtpVkladka,jtbMain));
        jbtDelete.addActionListener(new DeleteModeListener(jtpVkladka,jtbMain));

        jfMainWin.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
}
