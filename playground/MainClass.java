import java.util.*;
import java.lang.*;
import java.io.IOException;

public class MainClass {
  /**
   * Iterate through each line of input.
   */
 /* List<Integer> g = new ArrayList<>();
  g.add(4);
  g.add(1);
  g.add(2);
  g.add(2);
  g.add(3);*/
  public static void main(String[] args) {
      String test = ",Course,Percent Grade,Letter Grade";
      String[] result = test.split(",");
      System.out.println("size: " + result.length);
     // String ret = (new Solution()).findMaxGoalsProbability(); 
  }
}

/*
static String findMaxGoalsProbability(List<Integer> teamGoals) {
        Map<Integer, Integer> scoreMap = new HashMap();
        int maxScore = Integer.MIN_VALUE, size = teamGoals.size();
        for (int i = 0; i < teamGoals.size()-1; i++) {
            for (int j = i+1; j < teamGoals.size(); j++) {
                int score = teamGoals.get(i) + teamGoals.get(j);
                maxScore = Math.max(maxScore, score);
                if (scoreMap.get(score) == null)
                    scoreMap.put(score, 0);
                scoreMap.put(score, scoreMap.get(score)+1);
            }
        }
        Double probability = scoreMap.get(maxScore) != null ? 1.0*scoreMap.get(maxScore)/(size*(size-1)/2) : 0.00;
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(probability).toString();
    }

 */