package mediators;

import myConstants.ImageConst;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

/**
 * Created by Михаил on 22.03.2015.
 */
public class CursorScin {

    private static Cursor myCursor = setCursorScin();

    public static Cursor getCursor(){
        return myCursor;
    }

    private static Cursor setCursorScin(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image scin = tk.createImage("image\\greyVertex.png");
        return tk.createCustomCursor(scin,new Point(0,0),null);
    }
}
