import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainController {
    private Stage stage;
    private Scene scene;


    public void filmTimeController(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Sample2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void viewSelectedFilmController(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewSelectedFilmScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
}
