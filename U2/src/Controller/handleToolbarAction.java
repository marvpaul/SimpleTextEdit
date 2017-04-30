package Controller;

import Model.SearchStageModel;
import Model.TextAreaModel;
import View.GUI;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 * Class which handles toolbar actions for search and replace function
 */
public class handleToolbarAction implements javafx.event.EventHandler<ActionEvent> {

    /**
     * Handles the user input
     * @param event the current event
     */
    @Override
    public void handle(ActionEvent event) {
        System.out.println(((Button) event.getSource()).getText());
        switch (((Button) event.getSource()).getText()){
            case "Search":
                GUI.showSearchDialogue();
                break;
            case "SearchNow":
                GUI.closeStage();
                search();
                break;
        }
    }

    /**
     * A method which search in the textarea for a certain string
     */
    private void search(){
        String searchString = SearchStageModel.getSearchString();
        if(!searchString.equals("")){
            if(SearchStageModel.caseSensitive()){
                if (TextAreaModel.getText().indexOf(searchString) != -1) {
                    int start = TextAreaModel.getText().indexOf(searchString);
                    TextAreaModel.getTa().selectRange(start, start+searchString.length());
                    checkForReplacing(start, start+searchString.length());
                }
            } else{
                if (TextAreaModel.getText().toLowerCase().indexOf(searchString.toLowerCase()) != -1) {
                    int start = TextAreaModel.getText().toLowerCase().indexOf(searchString.toLowerCase());
                    TextAreaModel.getTa().selectRange(start, start+searchString.length());
                    checkForReplacing(start, start+searchString.length());
                }
            }

        }
    }

    /**
     * In case the user want to replace a string in the textarea with another one,
     * this method deletes the old string and insert the new one
     * @param start start index of the founded substring
     * @param end end index of the founded substring
     */
    private void checkForReplacing(int start, int end){
        if(!SearchStageModel.tfReplace.getText().equals("Replace with")){
            TextAreaModel.getTa().deleteText(start, end);
            TextAreaModel.getTa().insertText(start, SearchStageModel.tfReplace.getText());
        }

    }
}
