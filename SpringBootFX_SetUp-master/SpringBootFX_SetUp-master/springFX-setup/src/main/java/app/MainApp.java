package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApp extends Application {
    public static Stage stage;
    public static ConfigurableApplicationContext springContext;
    private Parent root;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(MainApp.class);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        loader.setControllerFactory(springContext::getBean);
        root = loader.load();
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("Royal Flush");
        Image icon = new Image(getClass().getResourceAsStream("/images/logo.png"));
        stage.getIcons().add(icon);
        stage.setScene(new Scene(root, 1200, 800));
        stage.show();
    }
}
