import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SeatsController{
    ConnDB connDB = new ConnDB();
    ArrayList<Integer> availableSeats = new ArrayList<Integer>();

    @FXML
    private Label filmName;
   
    @FXML
    private Text alreadyBooked;

    @FXML
    private AnchorPane fix;
    

    @FXML
    private TextArea information;

    @FXML
    private Button nr1;

    @FXML
    private Button nr2;

    @FXML
    private Button nr3;

    @FXML
    private Button nr4;

    @FXML
    private Button nr5;

    @FXML
    private Button nr6;

    @FXML
    private Button nr7;

    @FXML
    private Button nr8;

    @FXML
    private Button nr9;

    @FXML
    private TextField userName;
    @FXML
    private Button backButton1;
    @FXML
    private Text allSeatsReserved;

 
    @FXML
     void reserveSeat(ActionEvent event) throws IOException {
  
  
        
        final Node source = (Node) event.getSource();
        String id = source.getId();
        source.setAccessibleText("ok");
       
    
        int seatId = changeButtonIdToInt(id);
        Button btn = checkSeatButton(seatId);
        if (btn.getText() == "Book"){
            alreadyBooked.setText("");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Booking.fxml"));
            Parent root = loader.load();
            Image icon = new Image("logo.png");
            BookingController controller = loader.getController();
            controller.dataInIt(filmID,seatId, this);
            Stage primaryStage = new Stage();
            primaryStage.getIcons().add(icon);
            Scene scene = new Scene(root);

     

            primaryStage.setScene(scene);
            primaryStage.setTitle("Cinema Liberty");
            primaryStage.show();
        
            
        }else{
            alreadyBooked.setText("This seat is already Booked!");
          
        }
       
        System.out.println(seatId);
        
    
        
    }
    public int changeButtonIdToInt(String buttonId){
        int seatId = 0;
        switch (buttonId) {
            case "nr1":
                seatId = 1;
                break;

            case "nr2":
                seatId = 2;
                break;

            case "nr3":
                seatId = 3;
                break;

            case "nr4":
                seatId = 4;
                break;

            case "nr5":
                seatId = 5;
                break;

            case "nr6":
                seatId = 6;
                break;

            case "nr7":
                seatId = 7;
                break;

            case "nr8":
                seatId = 8;
                break;

            case "nr9":
                seatId = 9;
                break;

            default:
                seatId = 0;
                break;
        }
        return seatId;


    }

    @FXML
    void seat(MouseEvent event) {

    }
    int filmID;
    
    /**
     * @return the filmID
     */
    public int getFilmID() {
        return filmID;
    }
    /**
     * @param filmID the filmID to set
     */
    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }
    private FilmTime selectedFilm;
    
    public void dataInIt(FilmTime filmTime) {
        selectedFilm = filmTime;
        filmID = selectedFilm.getFilmId();
        showAvailableSeats();


    }
    
    public void showAvailableSeats() {
        List<Seat> seatList = connDB.getAvailableSeats(selectedFilm.filmId);
        availableSeats.clear();
        int countSeats = 0;
        for (Seat availableSeat : seatList) {
            Button btn = checkSeatButton(availableSeat.seatId);
 
            btn.setStyle("-fx-background-color: #1a73e8");
            btn.setText("Book");
            availableSeats.add(availableSeat.seatId);
            countSeats++;
        }
        if(countSeats==0){
            allSeatsReserved.setText("Sorry, all seats are reserved at this time.");
        }
       
  


    }
    
    @FXML
    void backToPrevScene(ActionEvent event) throws IOException {
        MainController controller = new MainController();
        controller.filmTimeController(event);

    }
    public Button checkSeatButton( int seatId){
            Button btn = nr1;
            switch (seatId){
            case 1:
                btn = nr1;
                break;

            case 2:
                btn = nr2;
                break;

            case 3:
                btn = nr3;
                break;

            case 4:
                btn = nr4;
                break;

            case 5:
                btn = nr5;
                break;

            case 6:
                btn = nr6;
                break;

            case 7:
                btn = nr7;
                break;

            case 8:
                btn = nr8;
                break;

            case 9:
               btn =nr9;
                break;

            default :
               break;
        }
        return  btn;
    
        
    }


}
