class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap();
        List<List<String>> anagramList = new ArrayList<>();
        if (strs != null && strs.length > 0) {
            for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String meme = String.valueOf(chars);
            if (anagramMap.get(meme) == null)
                anagramMap.put(meme, new ArrayList<>());
                anagramMap.get(meme).add(str);
            }
        
            for (String key : anagramMap.keySet())
             anagramList.add(anagramMap.get(key));
        }
        return anagramList;
    }
}
