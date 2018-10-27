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
    int[] nums = new int[]{1};
    int target = 1;

    int[] ans = (new Solution()).searchRange(nums, target);
    System.out.println("ans: " + Arrays.toString(ans));
  }
}