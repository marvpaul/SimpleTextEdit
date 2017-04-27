package Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

/**
 * Created by Marvin Krüger S0556109.
 */
public class ImageLoader {
    public ImageView loadIcon(String icon){
        Image image = new Image(getClass().getResourceAsStream("../icons/" + icon + ".png"));
        ImageView iconView = new ImageView(image);
        iconView.setFitWidth(15);
        iconView.setFitHeight(15);
        return iconView;
    }
}
