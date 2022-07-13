import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class Cinema extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    // building the Scene
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FilmList.fxml"));
        Parent root = loader.load();
        Image icon = new Image("logo.png");
        primaryStage.getIcons().add(icon);
        Scene scene = new Scene(root);


        /* use the stylesheet, if there is one defined */
        URL settingsURL = getClass().getResource("styles.css");
        if (settingsURL != null) {
            scene.getStylesheets().add(settingsURL.toExternalForm());
        }

        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cinema Liberty");
        primaryStage.show();

      //  Controller controller = new Controller();
       // controller.runProgram();
    }

}