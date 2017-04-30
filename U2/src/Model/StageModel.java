package Model;

import javafx.stage.Stage;

/**
 * Created by Marvin Krüger S0556109.
 */
public class StageModel {
    private static Stage prim;

    public static void setStage(Stage st){
        prim = st;
    }

    public static Stage getPrim() {
        return prim;
    }
}
