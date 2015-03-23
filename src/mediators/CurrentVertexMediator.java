package mediators;

import javax.swing.JLabel;

/**
 * Created by Михаил on 22.03.2015.
 */
public class CurrentVertexMediator {
    private static JLabel currenVertex;
    private static boolean hasContent = false;

    public static void setCurrenVertex(JLabel currenVertexCopy){
        currenVertex = currenVertexCopy;
        hasContent = true;
    }

    public static JLabel getCurrenVertex(){
        if (hasContent) {
            return currenVertex;
        }

        return null;
    }
}
