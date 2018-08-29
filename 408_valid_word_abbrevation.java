class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordIndex = 0, abbrIndex = 0, counter, numStart, numEnd;
        while (wordIndex < word.length() && abbrIndex < abbr.length()) {
            if (abbr.charAt(abbrIndex) >= 'a' && abbr.charAt(abbrIndex) <= 'z') {
                if (word.charAt(wordIndex) != abbr.charAt(abbrIndex))
                    return false;
                wordIndex++;
                abbrIndex++;
            } else if (abbr.charAt(abbrIndex) >= '1' && abbr.charAt(abbrIndex) <= '9') {
                numStart = abbrIndex;
                while (abbrIndex < abbr.length() && abbr.charAt(abbrIndex) >= '0' && abbr.charAt(abbrIndex) <= '9')
                    abbrIndex++;
                numEnd = abbrIndex;
                wordIndex += Integer.parseInt(abbr.substring(numStart, numEnd));
            } else 
                return false;
        }
        
        return wordIndex == word.length() && abbrIndex == abbr.length();
    }
}

/*
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordIndex = 0, abbrIndex = 0, counter, numStart, numEnd;
        while (wordIndex < word.length() && abbrIndex < abbr.length()) {
            if (abbr.charAt(abbrIndex) >= 'a' && abbr.charAt(abbrIndex) <= 'z') {
                if (word.charAt(wordIndex) == abbr.charAt(abbrIndex)) {
                    wordIndex++;
                    abbrIndex++;
                    continue;
                } 
		return false;
            }
           
            if (abbr.charAt(abbrIndex) < '1' || abbr.charAt(abbrIndex) > '9')
                return false;

            numStart = abbrIndex;
            while (abbrIndex < abbr.length() && abbr.charAt(abbrIndex) >= '0' && abbr.charAt(abbrIndex) <= '9')
                abbrIndex++;
            numEnd = abbrIndex;
            wordIndex += Integer.parseInt(abbr.substring(numStart, numEnd));
        }
        
        return wordIndex == word.length() && abbrIndex == abbr.length();
    }
}
*/
