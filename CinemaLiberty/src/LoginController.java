/*import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class LoginController {
    // second

    @FXML
    private Button logInButton;

    @FXML
    private PasswordField passwordBox;

    @FXML
    private TextField usernameBox;

    @FXML
    private Text wrongCredentials;

    @FXML
    void exitButton(MouseEvent event) {

    }

    @FXML
    void loginClick(ActionEvent event) {

    }
    
    public void selectFilm(int id) throws IOException {
        // System.out.println(table.getSelectionModel().getSelectedItem().getFilmId());
        System.out.println(id);
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
        Parent root = loader.load();
        Image icon = new Image("logo.png");
        primaryStage.getIcons().add(icon);
        Scene scene = new Scene(root, 1000, 800);

        
        URL settingsURL = getClass().getResource("styles.css");
        if (settingsURL != null) {
            scene.getStylesheets().add(settingsURL.toExternalForm());
        }

        primaryStage.setScene(scene);
        primaryStage.setTitle("Cinema Liberty");
        primaryStage.show();

    }
}
*/
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LoginController implements Initializable{

    @FXML
    private Button logInButton;

    @FXML
    private PasswordField passwordBox;

    @FXML
    private TextField usernameBox;

    @FXML
    private Text wrongCredentials;

    @FXML
    void exitButton(MouseEvent event) {

    }

    @FXML
    void loginClick(ActionEvent event) {

    }
    
    private FilmTime selectedFilm;
    
    ConnDB connDB = new ConnDB();

    public void dataInIt(FilmTime filmTime) {
        selectedFilm = filmTime;
        //title.setText(selectedFilm.getFilmname());
        int id = selectedFilm.getFilmId();
        System.out.println(selectedFilm.getFilmId());
        

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        Controller2 controller = new Controller2();
        List<FilmTime> menuList = connDB.getSelectedFilm(controller.getFilmId());
        
    }

}
