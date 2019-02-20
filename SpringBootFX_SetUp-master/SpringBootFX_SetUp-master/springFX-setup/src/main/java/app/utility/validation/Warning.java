package app.utility.validation;


import javafx.scene.control.Alert;

/**
 * Created by Demesmaecker Daniel on 3/11/2017.
 */
public interface Warning {

    /**
     * Promptts the user with a warning message
     * @param title String
     * @param content String
     */
    static void alert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();

    }
}

