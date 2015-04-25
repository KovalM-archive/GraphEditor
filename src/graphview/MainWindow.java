package graphview;

import mode.NewMenuListener;
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

        //Создание панели меню
        JMenuBar jmbMain = new JMenuBar();

        //Создание меню Файл и установка для него мнемонической клавиши
        JMenu jmFile = new JMenu("File");
        jmFile.setMnemonic(KeyEvent.VK_F);

        //Создание пунктов меню Файл и привязка к ним клавиш быстрого доступа
        JMenuItem jmiCreate = new JMenuItem("New", KeyEvent.VK_N);
        jmiCreate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));

        JMenuItem jmiOpen = new JMenuItem("Open",KeyEvent.VK_O);
        jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));

        JMenuItem jmiClose = new JMenuItem("Close", KeyEvent.VK_L);
        jmiClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));

        JMenuItem jmiSave = new JMenuItem("Save", KeyEvent.VK_S);
        jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

        JMenuItem jmiSaveAs = new JMenuItem("Save as");

        JMenuItem jmiExit = new JMenuItem("Exit",KeyEvent.VK_Q);
        jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));

        //Включение пунктов с состав меню Файл
        jmFile.add(jmiCreate);
        jmFile.add(jmiOpen);
        jmFile.add(jmiClose);
        jmFile.add(jmiSave);
        jmFile.add(jmiSaveAs);
        jmFile.add(jmiExit);

        //Добавление меню Файл к панели меню
        jmbMain.add(jmFile);

        //Создание меню Алгоритмы и связывание его с подменю Найти минимальный путь
        JMenu jmAlgorithms = new JMenu("Algorithms");
        jmAlgorithms.setMnemonic(KeyEvent.VK_A);
        JMenuItem jmiFindMinPath = new JMenuItem("Find min path");
        jmiFindMinPath.setMnemonic(KeyEvent.VK_F);
        jmAlgorithms.add(jmiFindMinPath);
        jmbMain.add(jmAlgorithms);

        //Включение меню в состав фрейма
        jfMainWin.setJMenuBar(jmbMain);

        //Создание панели инструментов
        JToolBar jtbMain = new JToolBar("ToolBar",JToolBar.VERTICAL);

        ImageIcon imVertex = new ImageIcon("image\\toolbar\\1.png");
        ImageIcon imEdge = new ImageIcon("image\\toolbar\\2.png");
        ImageIcon imChanges = new ImageIcon("image\\toolbar\\3.png");
        ImageIcon imDelete = new ImageIcon("image\\toolbar\\4.png");

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

        //Создание панели вкладок
        JTabbedPane jtpVkladka = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.WRAP_TAB_LAYOUT);
        jfMainWin.add(jtpVkladka, BorderLayout.CENTER);

        NewMenuListener nmlListener = new NewMenuListener(jtpVkladka,jtbMain);
        jmiCreate.addActionListener(nmlListener);

        //Создание слушателя для кнопок панели инструментов

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
