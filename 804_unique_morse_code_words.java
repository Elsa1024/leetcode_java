class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] encodeTable = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> morse = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            for (char c : word.toCharArray())
                sb.append(encodeTable[c - 'a']);
            morse.add(sb.toString());
            sb.setLength(0);
        }
        
        return morse.size();
    }
}
