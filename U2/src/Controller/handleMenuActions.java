package Controller;

import Model.StageModel;
import Model.TextAreaModel;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;

/**
 * Created by Marvin Krüger S0556109.
 */
public class handleMenuActions implements javafx.event.EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        switch (((MenuItem) event.getSource()).getText()){
            case "Exit":
                exit();
                break;
            case "Save":

                TextAreaModel.save();
                break;
            case "New":
                TextAreaModel.clean();
                break;
            case "Open":
                System.out.println("Open");
                TextAreaModel.open();
                break;
        }

    }

    private void exit(){
        StageModel.getPrim().close();
        System.exit(0);
    }
}
