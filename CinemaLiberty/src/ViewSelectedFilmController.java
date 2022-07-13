import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class ViewSelectedFilmController{
    ConnDB connDB = new ConnDB();

    private FilmTime selectedFilm;

    @FXML
    private Button backButton;

    @FXML
    private Text description;

    @FXML
    private Text endDate;

    @FXML
    private Text startDate;

    @FXML
    private Text title;
   

    @FXML
    void backToPrevScene(ActionEvent event) throws IOException {
        MainController controller = new MainController();
        controller.filmTimeController(event);


    }

    @FXML
    void deleteFilm(ActionEvent event) {

    }
    public void selectFilm(int id) throws IOException {
        List<FilmTime> menuList = connDB.getSelectedFilm(id);
        title.setText(menuList.get(0).filmname);
        description.setText(menuList.get(0).filmDescp);

        
        
        
    }
    public void dataInIt(FilmTime filmTime){
        selectedFilm = filmTime;
        title.setText(selectedFilm.getFilmname());
        description.setText(selectedFilm.getFilmDescp());
        endDate.setText(selectedFilm.getEndTime());
        startDate.setText(selectedFilm.getStartTime());

    }
 

}
