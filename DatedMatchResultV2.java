//Name: Siska Kristanti Lim
//Student number: 170281939
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class DatedMatchResultV2 implements Serializable {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private LocalDate date;

    public DatedMatchResultV2(LocalDate date, String homeTeam, int homeScore, String awayTeam, int awayScore) {
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
    public String toString() {
       // return date +"\t"+homeTeam+"\t\t"+awayTeam+"\t\t"+homeScore+" "+awayScore;
    	return String.format("%-15s %-17s %-17s %-2s %-2s",date,homeTeam,awayTeam,homeScore,awayScore);
    }
}
