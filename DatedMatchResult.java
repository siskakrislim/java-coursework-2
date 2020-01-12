//Name: Siska Kristanti Lim
//Student number: 170281939
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class DatedMatchResult implements Serializable {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private LocalDate date;

    public DatedMatchResult(LocalDate date, String homeTeam, int homeScore, String awayTeam, int awayScore) {
        this.homeTeam = homeTeam;
        this.homeScore = homeScore;
        this.awayTeam = awayTeam;
        this.awayScore = awayScore;
        this.date = date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public LocalDate getDate() {
        return date;
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(getClass() == o.getClass())) return false;
        DatedMatchResult matchResult = (DatedMatchResult) o;
        return matchResult.getHomeTeam() == this.getHomeTeam() && matchResult.getAwayTeam() == this.getAwayTeam()
        		&& matchResult.getHomeScore() == this.getHomeScore() && matchResult.getAwayScore() == this.getAwayScore()
        		&& matchResult.getDate() == this.getDate(); //this statement is here to make the method compile. It should be replaced with your own code
    }

    @Override //should override Object's  hashCode() method when overriding equals()
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, homeScore, awayScore, date);
    }
}
