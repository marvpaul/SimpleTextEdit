package Controller;

import Model.StageModel;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * A class which controls menu action
 */
public class handleMenuActions implements javafx.event.EventHandler<ActionEvent> {

    /**
     * Method which is called by processing an event from menu
     * @param event
     */
    @Override
    public void handle(ActionEvent event) {
        switch (((MenuItem) event.getSource()).getText()){
            case "Exit":
                StageModel.exit();
                break;
            case "Save":

                StageModel.save();
                break;
            case "New":
                StageModel.clean();
                break;
            case "Open":
                StageModel.open();
                break;
        }

    }
}
