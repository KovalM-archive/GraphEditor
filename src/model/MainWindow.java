package model;

import listeners.NewMenuListener;
import listeners.ToolBarListener;
import listeners.modeListeners.ChangeIdentifierMode;
import listeners.modeListeners.CreateEdgeMode;
import listeners.modeListeners.CreateMoveVertexMode;
import listeners.modeListeners.DeleteMode;
import mediators.ToolBarMediator;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created by Михаил on 23.02.2015.
 */
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
        jmiClose.setEnabled(false);

        JMenuItem jmiSave = new JMenuItem("Save", KeyEvent.VK_S);
        jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        jmiSave.setEnabled(false);

        JMenuItem jmiSaveAs = new JMenuItem("Save as");
        jmiSaveAs.setEnabled(false);

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


        //Создание меню Редактировать и установка для него мнемонической клавиши
        JMenu jmEdit = new JMenu("Edit");
        jmEdit.setMnemonic(KeyEvent.VK_E);

        //Создание пунктов меню Редактировать и привязка к ним клавиш быстрого доступа
        JMenuItem jmiCreateVertex = new JMenuItem("Create vertex", KeyEvent.VK_1);
        jmiCreateVertex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK));

        JMenuItem jmiCreateEdge = new JMenuItem("Create edge", KeyEvent.VK_2);
        jmiCreateEdge.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK));

        JMenuItem jmiChangeName = new JMenuItem("Change vertex's name", KeyEvent.VK_3);
        jmiChangeName.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_MASK));

        JMenuItem jmiChangeWeight = new JMenuItem("Change edges name", KeyEvent.VK_4);
        jmiChangeWeight.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_MASK));

        JMenuItem jmiDeleteVertex = new JMenuItem("Delete vertex", KeyEvent.VK_5);
        jmiDeleteVertex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, InputEvent.CTRL_MASK));

        JMenuItem jmiDeleteEdge = new JMenuItem("Delete edge", KeyEvent.VK_6);
        jmiDeleteEdge.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, InputEvent.CTRL_MASK));

        //Включение пунктов с состав меню Редактировать
        jmEdit.add(jmiCreateVertex);
        jmEdit.add(jmiCreateEdge);
        jmEdit.add(jmiChangeName);
        jmEdit.add(jmiChangeWeight);
        jmEdit.add(jmiDeleteVertex);
        jmEdit.add(jmiDeleteEdge);

        //Добавление меню Редактировать к панели меню
        jmbMain.add(jmEdit);


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

        ImageIcon imVertex = new ImageIcon("image\\toolbar\\181.png");
        ImageIcon imEdge = new ImageIcon("image\\toolbar\\181.png");
        ImageIcon imChanges = new ImageIcon("image\\toolbar\\181.png");
        ImageIcon imDelete = new ImageIcon("image\\toolbar\\181.png");

        JToggleButton jbtVertex = new JToggleButton(imVertex,false);
        jbtVertex.setActionCommand("Vertex");
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

        ToolBarMediator.setToolBarMediator(jtbMain);
        jtbMain.setFloatable(false);
        jtbMain.setVisible(false);

        jfMainWin.add(jtbMain,BorderLayout.WEST);

        //Создание панели вкладок
        JTabbedPane jtpVkladka = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.WRAP_TAB_LAYOUT);
        jfMainWin.add(jtpVkladka, BorderLayout.CENTER);

        NewMenuListener nmlListener = new NewMenuListener(jtpVkladka,jtbMain);
        jmiCreate.addActionListener(nmlListener);

        //Создание слушателя для кнопок панели инструментов

        jbtVertex.addActionListener(new CreateMoveVertexMode(jtpVkladka,jtbMain));
        jbtEdge.addActionListener(new CreateEdgeMode(jtpVkladka,jtbMain));
        jbtChanges.addActionListener(new ChangeIdentifierMode(jtpVkladka,jtbMain));
        jbtDelete.addActionListener(new DeleteMode(jtpVkladka,jtbMain));

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
