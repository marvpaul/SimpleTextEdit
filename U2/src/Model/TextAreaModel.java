package Model;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by Marvin Krüger S0556109.
 */
public class TextAreaModel {
    private static TextArea ta;
    public static String getText(){
       return ta.getText();
    }

    public static void setText(String value){
        ta.setText(value);
    }

    public static TextArea getTa() {
        return ta;
    }

    public static void setTa(TextArea taN) {
        ta = taN;
    }

    public static void clean(){
        ta.setText("");
    }

    public static void save(){
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(StageModel.getPrim());

        if(file != null) {
            try {
                FileWriter fileWriter = null;

                fileWriter = new FileWriter(file);
                fileWriter.write(TextAreaModel.getText());
                fileWriter.close();
            } catch (Exception ex) {

            }
        }
    }

    public static void open(){
        FileChooser fileChooser = new FileChooser();

        //Show file dialog
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
