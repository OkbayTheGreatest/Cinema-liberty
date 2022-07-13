import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;


public class Controller implements Initializable{
    ConnDB connDB = new ConnDB();
    ObservableList<FilmTime> list;
    @FXML
    private ListView<String> listView;
    String currentFood;
    ArrayList<String> food = new ArrayList<String>();
    String takeIt= "ok";
    

    public void runProgram() {
        showFilmMenu();
        
        System.out.println("******************");
        //showAvailableSeats();
        System.out.println("******************");
        //makeReservation();
        //cancelReservation();

    }
    
    
    public void showFilmMenu(){
        List<FilmTime> menuList = connDB.getFilmTimes();

        for (FilmTime filmTime : menuList) {
            System.out.println(filmTime.filmname + " Start Time: " + filmTime.startTime + " End Time: "
                    + filmTime.endTime + " Description: " + filmTime.filmDescp);

            
                  String filmLine = filmTime.filmname + "  Starts at: "+ filmTime.startTime + " End Time: "+ filmTime.endTime;
                  food.add(filmLine);
                  
           
            

        }
        

    }
    
    public void showAvailableSeats() {
        List<Seat> seatList = connDB.getAvailableSeats(2);

        for (Seat availableSeat: seatList) {
            System.out.println("Seat number. "+availableSeat.seatId + "   Description: " + availableSeat.seatDesc);

        }

    }

    public void makeReservation() {
        String feedBack = connDB.makeReservation("David", 4, 9);
        System.out.println(feedBack);

    }
    
    public void cancelReservation() {
        String feedBack = connDB.cancelReservation(9,4);
        System.out.println(feedBack);

    }
    public void logInButtonClick(){
        System.out.println("User loged In");
        
    }
    // (String filmname, String filmDescp, String startTime, String endTime)
    
    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        showFilmMenu();
        listView.getItems().addAll(food);
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                // TODO Auto-generated method stub
                currentFood = listView.getSelectionModel().getSelectedItem();
            }
            
        });

        
    }


    
}
