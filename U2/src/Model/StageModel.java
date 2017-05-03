package Model;

import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * A model which stores all components of the main stage GUI
 */
public class StageModel {

    private static Stage prim;
    private static TextArea ta;
    private static MenuBar mb;
    private static ToolBar tb;

    /**
     * Getter fpr the current ToolBar
     * @return the tb
     */
    public static ToolBar getTb() {
        return tb;
    }

    /**
     *
     * @param tb
     */
    public static void setTb(ToolBar tb) {
        StageModel.tb = tb;
    }

    public static MenuBar getMb() {
        return mb;
    }

    public static void setMb(MenuBar mb) {
        StageModel.mb = mb;
    }

    /**
     * Setter for prim
     * @param st the new main stage
     */
    public static void setStage(Stage st){
        prim = st;
    }

    /**
     * Getter for prim
     * @return the current main stage
     */
    public static Stage getPrim() {
        return prim;
    }

    /**
     * Get the content of the TextArea ta
     * @return content of ta
     */
    public static String getText(){
        return ta.getText();
    }

    /**
     * Setter for ta
     * @param value the new content of TextArea ta
     */
    public static void setText(String value){
        ta.setText(value);
    }

    /**
     * Getter for ta
     * @return return the TextField itself
     */
    public static TextArea getTa() {
        return ta;
    }

    /**
     * Set a nex TextArea
     * @param nTa the new TextArea
     */
    public static void setTa(TextArea nTa){
        ta = nTa;
    }

    /**
     * Handles system exit
     */
    public static void exit(){
        prim.close();
        System.exit(0);
    }

    /**
     * Clean the ta
     */
    public static void clean(){
        ta.setText("");
    }

    /**
     * Handles saving a file
     */
    public static void save(){
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(StageModel.getPrim());

        if(file != null) {
            try {
                FileWriter fileWriter = null;

                fileWriter = new FileWriter(file);
                fileWriter.write(getText());
                fileWriter.close();
            } catch (Exception ex) {

            }
        }
    }

    /**
     * Handles opening a file
     */
    public static void open(){
        FileChooser fileChooser = new FileChooser();

        File file = fileChooser.showOpenDialog(StageModel.getPrim());
        String content = "";
        if(file != null) {
            try {
                FileReader fileReader = null;

                fileReader = new FileReader(file);
                BufferedReader br = new BufferedReader(fileReader);
                String line;
                while((line=br.readLine()) != null){
                    content += line;
                }
            } catch (Exception ex) {

            }
        }
        setText(content);
    }
}
