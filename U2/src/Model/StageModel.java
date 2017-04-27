package Model;

import Controller.handleToolbarAction;
import View.GUI;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Marvin Krüger S0556109.
 */
public class StageModel {
    private static TextField tf;
    private static Stage searchStage;
    private static CheckBox cb;


    public static boolean caseSensitive(){
        return cb.isSelected();
    }
    public static void closeStage(){
        searchStage.close();
    }
    public static Stage getText(){
        return GUI.prim;
    }

    public static String getSearchString(){
        return tf.getText();
    }

    public static void showSearchDialogue(){

        searchStage = new Stage();
        searchStage.initModality(Modality.WINDOW_MODAL);
        BorderPane layout = new BorderPane();
        searchStage.initOwner(GUI.prim);
        Scene sc = new Scene(layout);

        tf = new TextField();
        Button bt = new Button("SearchNow");
        bt.setOnAction(new handleToolbarAction());
        cb = new CheckBox("Case sensitive");
        layout.setCenter(tf);
        layout.setBottom(bt);
        layout.setRight(cb);
        searchStage.setScene(sc);
        //Fill stage with content
        searchStage.show();
    }
}
