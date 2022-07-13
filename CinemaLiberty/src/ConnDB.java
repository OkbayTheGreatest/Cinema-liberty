import java.sql.*;
import java.util.List;

import java.util.ArrayList;

public class ConnDB {

    Connection con;
    Statement stmt;
    ResultSet rs;
    public ConnDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            

        } catch (Exception e) {
            System.out.println(e);
            new RuntimeException(e);
        }
       
    }
    
  
  public  List<FilmTime> getFilmTimes()
  {
    List<FilmTime> filmList = new ArrayList<FilmTime>();
    

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "okbay", "1234");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
                " select f.name, v.StartTime, v.endtime, f.FilmDescription,f.ID from FilmTime v join film f on f.id = v.film_id order by v.starttime asc;");
        while (rs.next()) {
            //System.out.println(rs.getString(1));
            
            FilmTime filmtime = new FilmTime();
            filmtime.filmname = rs.getString(1);
            filmtime.startTime = rs.getString(2);
            filmtime.endTime = rs.getString(3);
            filmtime.filmDescp = rs.getString(4);
            filmtime.filmId = rs.getInt(5);
            filmList.add(filmtime);
            

        }
        return filmList; 
    } catch (Exception e) {
       throw new RuntimeException(e);
        
        
    }

  }
  
  public List<FilmTime> getSelectedFilm(int filmTimeId) {
      List<FilmTime> filmList = new ArrayList<FilmTime>();

      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "okbay", "1234");
          String query = "{CALL getSelectedFilm(?)}";
          CallableStatement stmt = con.prepareCall(query);
          stmt.setInt(1, filmTimeId);

          ResultSet rs = stmt.executeQuery();
          while (rs.next()) {
              // System.out.println(rs.getString(1));

              FilmTime filmtime = new FilmTime();
              filmtime.filmname = rs.getString(1);
              filmtime.startTime = rs.getString(2);
              filmtime.endTime = rs.getString(3);
              filmtime.filmDescp = rs.getString(4);
              filmtime.filmId = rs.getInt(5);
              filmList.add(filmtime);

          }
          return filmList;
      } catch (Exception e) {
          throw new RuntimeException(e);

      }

  }

    public List<Seat> getAvailableSeats(int filmTimeId){

      List<Seat> seatList = new ArrayList<Seat>();

      try (
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "okbay", "1234")) {
              String query = "{CALL getAvailableSeats(?)}";
              CallableStatement stmt = con.prepareCall(query);
              stmt.setInt(1,filmTimeId);
            
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
              // System.out.println(rs.getString(1));

              Seat seat = new Seat();
              seat.seatId = rs.getInt(1);
              seat.seatDesc = rs.getString(2);

              seatList.add(seat);

          }
          return seatList;
      } catch (Exception e) {
          throw new RuntimeException(e);
      }

    }

    // reserve a seat
    public String makeReservation(String custName,int filmTimeId,int seatId) {
        String feedBack = "";
        //reserveSeat(custName char(20), viewingId int, seatId int)

        try (
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "okbay", "1234")) {
            String query = "{CALL reserveSeat(?,?,?)}";
            CallableStatement stmt = con.prepareCall(query);
            stmt.setString(1, custName);
            stmt.setInt(2, filmTimeId);
            stmt.setInt(3, seatId);
            stmt.executeQuery();
      
          feedBack = "Reservation sucsessful";
          return feedBack;
        } catch (Exception e) {
            feedBack = "Reservation not sucsessful";
            throw new RuntimeException(e);
        }

    }
  
    //Cancel a reservation
    public String cancelReservation(int seatId, int filmTimeId) {
        String feedBack = "";
        //call cancelReservation(seatId, viewingId)

        try (
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "okbay", "1234")) {
            String query = "{CALL cancelReservation(?,?)}";
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, seatId);
            stmt.setInt(2, filmTimeId);
           
            stmt.executeQuery();
            feedBack = "Reservation canceled sucsessful";
            return feedBack;
        } catch (Exception e) {
            feedBack = "Canceling a reservation not sucsessful";
            throw new RuntimeException(e);
        }
        

    }
    
}
