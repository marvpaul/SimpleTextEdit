package View;

import Controller.handleMenuActions;
import Controller.handleToolbarAction;
import Model.ImageLoader;
import Model.SearchStageModel;
import Model.StageModel;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;


/**
 * Class which creates and configures the gui
 */
//TODO: Add menu button mnemomics
public class GUI{
    /**
     * Method which is called initial to create the GUI
     * @param primaryStage the main stage for the GUI
     */
    public static void initialize(Stage primaryStage){

        StageModel.setStage(primaryStage);
        createMenuBar();
        createToolbar();

        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();

        //Set stage properties
        primaryStage.setTitle("TextAreaModel Edit");
        primaryStage.setWidth(screenWidth / 100 * 60);
        primaryStage.setHeight(screenHeight / 100 * 60);

        //Creates TextArea
        StageModel.setTa(new TextArea());
        StageModel.getTa().setWrapText(true);

        //Set layout and add elements
        BorderPane layout = new BorderPane();
        layout.setTop(StageModel.getMb());
        layout.setCenter(StageModel.getTa());
        layout.setBottom(StageModel.getTb());

        //Set new scene and loading stylesheet
        Scene sc = new Scene(layout);
        sc.getStylesheets().add("style.css");
        primaryStage.setScene(sc);

        primaryStage.show();
    }

    /**
     * Method which handles all necessary stuff to add a menu bar
     * @return
     */
    public static void createMenuBar(){
        StageModel.setMb(new MenuBar());

        //Menu File
        Menu menuFile = new Menu("_File");

        //Menu items
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
        StageModel.getMb().getMenus().addAll(menuFile);
    }

    public static void createToolbar(){
        Button search = new Button("Search");
        search.setOnAction(new handleToolbarAction());
        StageModel.setTb(new ToolBar(search));
    }

    public static void showSearchDialogue(){

        SearchStageModel.setSearchStage(new Stage());


        BorderPane layout = new BorderPane();
        Scene sc = new Scene(layout);

        SearchStageModel.setTf(new TextField("Search"));
        SearchStageModel.setBt(new Button("SearchNow"));
        SearchStageModel.getBt().setOnAction(new handleToolbarAction());
        SearchStageModel.setCb(new CheckBox("Case sensitive"));
        SearchStageModel.setTfReplace(new TextField("Replace with"));

        BorderPane nestedLayout = new BorderPane();
        nestedLayout.setBottom(SearchStageModel.getTfReplace());
        nestedLayout.setCenter(SearchStageModel.getTf());
        layout.setCenter(nestedLayout);
        layout.setBottom(SearchStageModel.getBt());
        layout.setRight(SearchStageModel.getCb());
        SearchStageModel.getSearchStage().setScene(sc);
        SearchStageModel.getSearchStage().show();
    }




}
