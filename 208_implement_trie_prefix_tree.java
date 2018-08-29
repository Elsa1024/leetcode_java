class Trie {
    class TrieNode {
        public char val;
        public TrieNode[] children;
        public boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode tn = root;
        for (char c : word.toCharArray()) {
            if (tn.children[c - 'a'] == null) {
                tn.children[c - 'a'] = new TrieNode();
                tn.children[c - 'a'].val = c;
            }
            tn = tn.children[c - 'a'];
        }
        tn.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tn = root;
        for (char c : word.toCharArray()) {
            if (tn.children[c - 'a'] == null)
                return false;
            tn = tn.children[c - 'a'];
        }
        return tn.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode tn = root;
        for (char c : prefix.toCharArray()) {
            if (tn.children[c - 'a'] == null)
                return false;
            tn = tn.children[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// good practice for data structures
