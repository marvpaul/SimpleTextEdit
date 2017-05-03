package Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * A class to load images
 */
public class ImageLoader {
    /**
     * Method which loads an image from resources and convert it into ImageView
     * @param icon the icon to load as .png in folder ../icons/
     * @return the ImageView of this icon
     */
    public ImageView loadIcon(String icon){
        Image image = new Image(getClass().getResourceAsStream("../icons/" + icon + ".png"));
        ImageView iconView = new ImageView(image);
        iconView.setFitWidth(15);
        iconView.setFitHeight(15);
        return iconView;
    }
}
