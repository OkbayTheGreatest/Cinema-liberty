import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class BookingController implements Initializable {
    int filmId;
    int seatId;
    SeatsController controller;
    
    @FXML
    private Button logInButton;

    @FXML
    private TextField username;

   
    @FXML
    private Text feedback;
    String userName;
    @FXML
    private Text success;

    @FXML
    void bookingClick(ActionEvent event) {
        if( username.getText() == null || userName==null ){
            feedback.setText("User name is empty.");
        }else{
            if(logInButton.getText()!="Booked"){
                userName = username.getText();

                makeReservation();

            }else{
                feedback.setText("You cannot book a seat twice.");
                success.setText("");

            }

        
            

        }

    }
    
    public void makeReservation() {
        ConnDB connDB = new ConnDB();
        if(userName.isEmpty()){
            feedback.setText("Please enter your username.");
        }else{
            
            String feedBack = connDB.makeReservation(userName, filmId, seatId);
            logInButton.setText("Booked");
            feedback.setText(feedBack);
            feedBack.toUpperCase();
            feedback.setStyle("-fx-background-color: #1a73e8");
            success.setText("Reservation successsful");
            feedback.setText("");
            

        }


        

    }
    
    public void dataInIt(int filmId, int seatId, SeatsController controller) {
        this.filmId = filmId;
        this.seatId = seatId;
        this.controller= controller;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userName = username.getText();
        
        // TODO Auto-generated method stub
        
    }

}
