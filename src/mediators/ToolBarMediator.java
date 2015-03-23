package mediators;

import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * Created by Михаил on 22.03.2015.
 */
public class ToolBarMediator {
    private static JToolBar jtbMain;
    private static boolean hasContent = false;

    public static void setToolBarMediator(JToolBar jtbMainCopy){
        jtbMain = jtbMainCopy;
        hasContent = true;
    }

    public static int getNumberSelectedButton(){
        if (hasContent) {
            for (int i = 0; i < 4; i++) {
                JToggleButton buf = (JToggleButton) jtbMain.getComponentAtIndex(i);
                if (buf.isSelected()) return i;
            }

        }
        return -1;
    }
}
