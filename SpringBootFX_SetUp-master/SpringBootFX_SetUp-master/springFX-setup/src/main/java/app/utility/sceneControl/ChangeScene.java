package app.utility.sceneControl;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.stage.Stage;
import app.MainApp;
import app.utility.validation.Warning;

/**
 * Created by Demesmaecker Daniel on 26/10/2017.
 */

public interface ChangeScene {

    /**
     * Changes the page in the current window
     * @param resource String
     * @param title String
     */
    @FXML
    static void init(String resource, String title){
        Parent root = null;
        try {
            root = ControllerBean.getBean(resource);
        } catch (Exception e) {
            Warning.alert("Error!", "Er ging iets fout tijdens het laden van de pagina!");
            e.printStackTrace();
        }
        Stage window = MainApp.stage;
        window.setTitle(title);
        window.getScene().setRoot(root);
        window.show();
    }
}
