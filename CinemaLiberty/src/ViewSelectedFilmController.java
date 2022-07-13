import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewSelectedFilmController implements Initializable{
    ConnDB connDB = new ConnDB();

    private FilmTime selectedFilm;

    @FXML
    private Button backButton;

    @FXML
    private Button bookButton;

    @FXML
    private Button deleteFilmButton;

    @FXML
    private Text description;

    @FXML
    private Text endDate;

    @FXML
    private ImageView selectedFilmPoster;

    @FXML
    private Text startDate;

    @FXML
    private Text time;

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

    @FXML
    void goToBookingScene(ActionEvent event)  {
        

    }
    
    public void selectFilm(int id) throws IOException {
        // System.out.println(table.getSelectionModel().getSelectedItem().getFilmId());
        //System.out.println(id);
        List<FilmTime> menuList = connDB.getSelectedFilm(id);
        System.out.println(menuList.get(0).filmname);
        title.setText(menuList.get(0).filmname);
        description.setText(menuList.get(0).filmDescp);

        
        
        
    }
    public void showContent(int id){
        

    
            //System.out.println(filmTime.filmname);
            // title.setText(filmTime.filmname);
            //title.setText(filmTime.filmname);
            //description.setText(filmTime.filmDescp);
        
        //FilmTime film = (FilmTime) menuList;
      
        //description.setText(menuList.get(0).filmDescp);
        
       
        
    }
    public void dataInIt(FilmTime filmTime){
        selectedFilm = filmTime;
        title.setText(selectedFilm.getFilmname());
        description.setText(selectedFilm.getFilmDescp());
        endDate.setText(selectedFilm.getEndTime());
        startDate.setText(selectedFilm.getStartTime());

    }

    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {
        Controller2 controller = new Controller2();
       
        List<FilmTime> menuList = connDB.getSelectedFilm(controller.getFilmId());
        //System.out.println(menuList.get(0).filmname);
        //title.setText(menuList.get(0).filmname);
        //description.setText(menuList.get(0).filmDescp);
        
        // TODO Auto-generated method stub
        
    }

 

}
