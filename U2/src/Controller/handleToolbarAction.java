package Controller;

import Model.StageModel;
import Model.TextAreaModel;
import View.GUI;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

/**
 * Created by Marvin Krüger S0556109.
 */
public class handleToolbarAction implements javafx.event.EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        System.out.println(((Button) event.getSource()).getText());
        switch (((Button) event.getSource()).getText()){
            case "Search":
                StageModel.showSearchDialogue();
                break;
            case "SearchNow":
                StageModel.closeStage();
                search();
                break;
        }
    }

    private void search(){
        String searchString = StageModel.getSearchString();
        if(searchString != ""){
            if(StageModel.caseSensitive()){
                if (TextAreaModel.getText().indexOf(searchString) != -1) {
                    int start = TextAreaModel.getText().indexOf(searchString);
                    GUI.ta.selectRange(start, start+searchString.length());
                }
            } else{
                if (TextAreaModel.getText().toLowerCase().indexOf(searchString.toLowerCase()) != -1) {
                    int start = TextAreaModel.getText().toLowerCase().indexOf(searchString.toLowerCase());
                    GUI.ta.selectRange(start, start+searchString.length());
                }
            }

        }
    }
}
