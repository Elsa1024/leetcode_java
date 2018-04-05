class Solution {
    public int numJewelsInStones(String J, String S) {
        Set jewels = new HashSet();
        int counter = 0;
        for (String j : J.split("")) {
            jewels.add(j);
        }
        for (String s : S.split("")) {
            if (jewels.contains(s)) 
                counter++;
        }
        
        return counter;
    }
}

/*
class Solution {
    public int numJewelsInStones(String J, String S) {
       int[] jewels = new int[128];
        
       for (char j : J.toCharArray()) 
           jewels[j] = 1;
        
       int counter = 0;
       for (char s : S.toCharArray())
           counter += jewels[s];
        
       return counter; 
    }
}
*/


/*
class Solution {
  public int numJewelsInStones(String J, String S) {
    int[] f = new int[128];
    for (final char c : J.toCharArray())
      f[c] = 1;
    int ans = 0;
    for (final char c : S.toCharArray())
      ans += f[c];
    return ans;
  }
}
*/

/* reference: http://zxi.mytechroad.com/blog/hashtable/leetcode-771-jewels-and-stones/ */
