class Solution {
    public String addBinary(String a, String b) {
        int set = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || set > 0; i--, j--) {
            int x = i < 0 ? 0 : a.charAt(i) - '0';
            int y = j < 0 ? 0 : b.charAt(j) - '0';
            sb.append((x + y + set) % 2);
            set = (x + y + set) / 2;
        }
        return sb.reverse().toString();
    }
}
