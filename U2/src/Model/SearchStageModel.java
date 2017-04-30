package Model;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Marvin Krüger S0556109.
 */
public class SearchStageModel {
    public static TextField tf, tfReplace;
    public static Stage searchStage;
    public static CheckBox cb;


    public static boolean caseSensitive(){
        return cb.isSelected();
    }



    public static String getSearchString(){
        return tf.getText();
    }
}
