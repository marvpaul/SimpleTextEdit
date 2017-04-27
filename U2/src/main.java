import View.GUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * Created by Marvin Krüger S0556109.
 */
public class main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        GUI.initialize(primaryStage);

    }
}
