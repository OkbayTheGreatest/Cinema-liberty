import java.io.IOException;
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

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;

public class FilmListController implements Initializable{
    ConnDB connDB = new ConnDB();

    //new

 

    @FXML
    private TableColumn<FilmTime, String> endTime;

    @FXML
    private TableColumn<FilmTime, String> film;

    @FXML
    private TableColumn<FilmTime, Integer> reserveSeat;

    @FXML
    private TableColumn<FilmTime, String> startTime;
    @FXML
    private TableView<FilmTime> table;
    @FXML
    private Text title;

    

    @FXML
    private Text screen;

    ObservableList<FilmTime> filmTable = FXCollections.observableArrayList();
    

    @FXML
    void viewSelectedFilmController(ActionEvent event) throws IOException {
        FilmTime selectedColumn = table.getSelectionModel().getSelectedItem();
        if (selectedColumn == null) {
            screen.setText("Nothing selected");

        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ViewSelectedFilmScene.fxml"));
            Parent root = loader.load();
            ViewSelectedFilmController controller = loader.getController();
            controller.dataInIt(table.getSelectionModel().getSelectedItem());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }
    
    @FXML
    void chooseDate(ActionEvent event) {

    }

    @FXML
    void filterDate(ActionEvent event) {

    }

    @FXML
    public void reserveSeat(ActionEvent event) throws IOException { 
        FilmTime selectedColumn = table.getSelectionModel().getSelectedItem(); 
        if (selectedColumn == null) {
            screen.setText("Please select a film first.");
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Reservation.fxml"));
            Parent root = loader.load();
            SeatsController controller = loader.getController();
            controller.dataInIt(table.getSelectionModel().getSelectedItem());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            //MainController controller = new MainController();
            //controller.viewSelectedFilmController(event);
        }

    }
  

    int filmID;
    
   


   

    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        showFilmMenu();
        film.setCellValueFactory(new PropertyValueFactory<FilmTime, String>("filmname"));
        endTime.setCellValueFactory(new PropertyValueFactory<FilmTime, String>("endTime"));
        startTime.setCellValueFactory(new PropertyValueFactory<FilmTime, String>("startTime"));
        
        
        table.setItems(filmTable);
        
    }

    public void showFilmMenu() {
        List<FilmTime> menuList = connDB.getFilmTimes();

        for (FilmTime filmTime : menuList) {

           filmTable.add(filmTime);
            

        }
        

    }
    public void selectFilm() throws IOException{
        FilmTime film = table.getSelectionModel().getSelectedItem();
       
        
        
        if(film == null){
            screen.setText("Please select a film first.");
            
        }
    }
    public int getFilmId(){
        return filmID;
    }


    public void filterDate(){

    }
    



}
