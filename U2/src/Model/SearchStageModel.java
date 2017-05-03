package Model;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * A model which stores all components of the SeachStage GUI
 */
public class SearchStageModel {

    private static TextField tf, tfReplace;
    private static Stage searchStage;
    private static CheckBox cb;
    private static Button bt;

    public static Button getBt() {
        return bt;
    }

    public static void setBt(Button bt) {
        SearchStageModel.bt = bt;
    }

    /**
     * Check if CheckBox cb is clicked
     * @return true if cb is selected
     */
    public static boolean caseSensitive(){
        return cb.isSelected();
    }

    /**
     * Return the content of TextField tf
     * @return text of tf
     */
    public static String getSearchString(){
        return tf.getText();
    }

    public static TextField getTf() {
        return tf;
    }

    public static void setTf(TextField tf) {
        SearchStageModel.tf = tf;
    }

    public static TextField getTfReplace() {
        return tfReplace;
    }

    public static void setTfReplace(TextField tfReplace) {
        SearchStageModel.tfReplace = tfReplace;
    }

    public static Stage getSearchStage() {
        return searchStage;
    }

    public static void setSearchStage(Stage nSearchStage) {

        searchStage = nSearchStage;
        searchStage.initOwner(StageModel.getPrim());
        searchStage.initModality(Modality.WINDOW_MODAL);
    }

    public static CheckBox getCb() {
        return cb;
    }

    public static void setCb(CheckBox cb) {
        SearchStageModel.cb = cb;
    }

    public static void closeStage(){
        searchStage.close();
    }
}
