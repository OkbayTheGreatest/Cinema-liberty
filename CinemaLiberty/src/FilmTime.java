public class FilmTime {
    String filmname;
    String filmDescp;
    String startTime;
    String endTime;
    int filmId;

    public String getFilmname() {
        return this.filmname;
    }

    public void setFilmname(String filmname) {
        this.filmname = filmname;
    }

    public String getFilmDescp() {
        return this.filmDescp;
    }

    public void setFilmDescp(String filmDescp) {
        this.filmDescp = filmDescp;
    }

    public String getStartTime() {
        //return this.startTime;
         return this.startTime.substring(0, this.startTime.length() - 3);
    }
    
    public String getEndTime() {
        return this.endTime.substring(0, this.endTime.length() - 3);
    }
    
    public  Integer getFilmId() {
        return this.filmId;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    
}
