import java.util.*;
import java.lang.*;
import java.text.*;
// avoid redundant comparation with 0
public class Solution {
    public String findMaxGoalsProbability() {
        List<Integer> teamGoals = new ArrayList<>();
        teamGoals.add(1);
        teamGoals.add(2);
        teamGoals.add(2);
        teamGoals.add(3);
        Map<Integer, Integer> scoreMap = new HashMap();
        int maxScore = 0, size = teamGoals.size();
        for (int i = 0; i < teamGoals.size()-1; i++) {
            for (int j = i+1; j < teamGoals.size(); j++) {
                int score = teamGoals.get(i) + teamGoals.get(j);
                maxScore = Math.max(maxScore, score);
                if (scoreMap.get(score) == null)
                    scoreMap.put(score, 0);
                scoreMap.put(score, scoreMap.get(score)+1);
            }
        }
        Double probability = 1.0*scoreMap.get(maxScore)/(size*(size-1)/2);
        DecimalFormat df = new DecimalFormat("0.00");
        String ret =  df.format(probability).toString();
        System.out.println("ret: " + ret);
        return ret;
    }
}
