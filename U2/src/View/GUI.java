package View;

import Controller.handleMenuActions;
import Controller.handleToolbarAction;
import Model.ImageLoader;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;

/**
 * Created by Marvin Krüger S0556109.
 */
public class GUI{
    public static TextArea ta =null;
    public static Stage prim;
    public static void initialize(Stage primaryStage){
        prim = primaryStage;
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();

        primaryStage.setTitle("TextAreaModel Edit");

        primaryStage.setWidth(screenWidth / 100 * 60);
        primaryStage.setHeight(screenHeight / 100 * 60);

        ta = new TextArea();
        ta.setWrapText(true);
        BorderPane layout = new BorderPane();
        layout.setTop(addMenuBar());
        layout.setCenter(ta);
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
        Menu menuFile = new Menu("Main");

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


}
