class Trie {
    
      class Node{
        char c;
        Node[] arr;
        boolean b;
        
        Node(char c){
            this.c = c;
            this.arr = new Node[26];
        }
    }
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node('\0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            Node temp = node.arr[c - 'a'];
            if(temp == null){
                temp = new Node(c);
                node.arr[c - 'a'] = temp;
            }
            node = temp;
        }
        node.b = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
     Node node = root;
        for(char c : word.toCharArray()){
            node = node.arr[c - 'a'];
            if(node == null){
                return false;
            }
        }
        return node.b;   
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char c : prefix.toCharArray()){
            node = node.arr[c - 'a'];
            if(node == null){
                return false;
            }
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
