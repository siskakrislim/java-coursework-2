//Name: Siska Kristanti Lim
//Student number: 170281939
import java.util.Comparator;

/**
 * If teams have equal points, compare goal difference. If they are still equal, compare goals scored.
 * If all three are equal then the teams are in equal position.
 * (for simplicity's sake we are ignoring the fact that if two teams vying for the title, relegation or qualification to other competitions were truly equal there would be a play-off match at a neutral venue.)
 */
public class LeagueStandingComparator implements Comparator<LeagueStanding> {
    @Override
    public int compare(LeagueStanding a, LeagueStanding b) {
        int aPoints = a.getPoints();
        int bPoints = b.getPoints();
        if (aPoints != bPoints) {
            return aPoints > bPoints ? -1 : 1;
        }

        //if we get here, equal points
        int aGoalDif = a.getGoalDifference();
        int bGoalDif = b.getGoalDifference();
        if(aGoalDif != bGoalDif) {
        	return aGoalDif > bGoalDif ? -1 : 1;
        }
        
        int aGoals = a.getGoalsFor();
        int bGoals = b.getGoalsFor();
        if(aGoals != bGoals) {
        	return aGoals > bGoals ? -1 : 1;
        }
        
        return 0;
    }
}
