import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class StarterPageController {

    @FXML
    private TextArea descText;

    @FXML
    private Button showProBtn;

    @FXML
    private Text welcomeText;

    @FXML
    void showMenu(ActionEvent event) throws IOException {
        MainController controller = new MainController();
        controller.filmTimeController(event);

    }

}
