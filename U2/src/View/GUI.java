package View;

import Controller.handleMenuActions;
import Controller.handleToolbarAction;
import Model.ImageLoader;
import Model.SearchStageModel;
import Model.StageModel;
import Model.TextAreaModel;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import static Model.SearchStageModel.*;

/**
 * Created by Marvin Krüger S0556109.
 */
//TODO: Add menu button mnemomics
public class GUI{
    public static void initialize(Stage primaryStage){
        StageModel.setStage(primaryStage);
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();

        primaryStage.setTitle("TextAreaModel Edit");

        primaryStage.setWidth(screenWidth / 100 * 60);
        primaryStage.setHeight(screenHeight / 100 * 60);

        TextAreaModel.setTa(new TextArea());
        TextAreaModel.getTa().setWrapText(true);
        BorderPane layout = new BorderPane();
        layout.setTop(addMenuBar());
        layout.setCenter(TextAreaModel.getTa());
        layout.setBottom(addToolbar());

        Scene sc = new Scene(layout);
        sc.getStylesheets().add("style.css");

        primaryStage.setScene(sc);
        addMenuBar();
        primaryStage.show();
    }

    public static MenuBar addMenuBar(){
        MenuBar menuBar = new MenuBar();

        // --- Menu File
        Menu menuFile = new Menu("_File");

        //Create menu items
        MenuItem mI1 = new MenuItem("New");
        MenuItem mI2 = new MenuItem("Open");
        MenuItem mI3 = new MenuItem("Save");
        MenuItem mI4 = new MenuItem("Exit");

        //Add icons to menu items
        mI1.setGraphic(new ImageLoader().loadIcon("new"));
        mI2.setGraphic(new ImageLoader().loadIcon("open"));
        mI3.setGraphic(new ImageLoader().loadIcon("save"));
        mI4.setGraphic(new ImageLoader().loadIcon("exit"));

        //set actions
        mI1.setOnAction(new handleMenuActions());
        mI2.setOnAction(new handleMenuActions());
        mI3.setOnAction(new handleMenuActions());
        mI4.setOnAction(new handleMenuActions());

        //Set shortcuts
        mI1.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.SHORTCUT_DOWN));
        mI2.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.SHORTCUT_DOWN));
        mI3.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN));
        mI4.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.SHORTCUT_DOWN));


        menuFile.getItems().addAll(mI1, mI2, mI3, mI4);
        menuBar.getMenus().addAll(menuFile);
        return menuBar;

    }

    public static ToolBar addToolbar(){
        Button search = new Button("Search");
        search.setOnAction(new handleToolbarAction());
        ToolBar toolBar = new ToolBar(search);
        return toolBar;
    }

    public static void showSearchDialogue(){

        searchStage = new Stage();
        searchStage.initModality(Modality.WINDOW_MODAL);
        BorderPane layout = new BorderPane();
        searchStage.initOwner(StageModel.getPrim());
        Scene sc = new Scene(layout);

        tf = new TextField("Search");
        Button bt = new Button("SearchNow");
        bt.setOnAction(new handleToolbarAction());
        cb = new CheckBox("Case sensitive");
        tfReplace = new TextField("Replace with");
        BorderPane nestedLayout = new BorderPane();
        nestedLayout.setBottom(tfReplace);
        nestedLayout.setCenter(tf);
        layout.setCenter(nestedLayout);
        layout.setBottom(bt);
        layout.setRight(cb);
        searchStage.setScene(sc);
        searchStage.show();
    }

    public static void closeStage(){
        searchStage.close();
    }


}
