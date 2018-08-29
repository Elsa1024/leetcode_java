import java.util.*;
import java.lang.*;
// avoid redundant comparation with 0
public class Solution {   
    public static int calculate(int[] maxBunnies, int curr, int candidate, int[] exits, int[][] path) {
        int ans = 0;
        if (max_bunnies[curr] > -1)
            ans = maxBunnies[curr];
        else {
            int[] p = path[curr];
            List<Integer> nextPods = new ArrayList<>();
            for (int i = 0; i < p.length; i++) {
                if (p[i] > 0)
                    nextPods.add(i);
            }
            for pod in nextPods {
                if exits.indexOf(pod) >= 0
                    ans += p[pod];
                else
                    ans += calculate(maxBunnies, pod, p[pod], exits, path);
            }
        }
        int supply = candidate == -1 || candidate > ans ? ans : candidate;
        maxBunnies[curr] = ans-supply;
        return supply;
    }

    public static int answer(int[] entrances, int[] exits, int[][] path) { 
        // Your code goes here.
        int[] maxBunnies = new int[path.length];
        int totalBunnies = 0;
        for entrance in entrances:
            totalBunnies += calculate(maxBunnies, entrance, -1, exits, path);
        return totalBunnies;
    } 
}