public class Codec {
    Map<Integer, String> shortToLong = new HashMap<Integer, String>();
    String mapTable = "abcdefghijklmnopqrstuvwxyz0123456789-";
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        shortToLong.put(shortToLong.size(), longUrl);
        
        int index = shortToLong.size();
        StringBuilder sb = new StringBuilder();
        while(index > 0) {
            int r = index % 37;
            index = index / 37;
            sb.append(mapTable.charAt(r));
        }
        
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        StringBuilder sb = new StringBuilder();
        int base = 1;
        int index = 0;
        for (char c : shortUrl.toCharArray()) {
            index += base * mapTable.indexOf(c);
            base *= 37;    
        }
        return shortToLong.get(index-1);
    }
}

/* 
key: map
can substitute the specific coding method
*/

/*
reference: https://leetcode.com/problems/encode-and-decode-tinyurl/discuss/100268/Two-solutions-and-thoughts
*/
