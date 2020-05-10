package advance.datastructure;

public class ImplementTrie {
	public static void main(String[] args) {
		
	
	
	 Trie obj = new Trie();
	 obj.insert("word");
	 boolean param_2 = obj.search("word");
	 boolean param_3 = obj.startsWith("wo");
	 
	 System.out.println(param_2+"   "+param_3);
	}

}

class Trie {
	TrieNode root;
	class TrieNode {
		TrieNode[] children;
		boolean isLeaf;
		public TrieNode() {
			children=new TrieNode[26];
			isLeaf=false;

		}
		
	}

    public Trie() {
    	root=new TrieNode();	
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode node=root;
    	for(int i=0;i<word.length();i++) {
    		int index=word.charAt(i)-'a';
    		if(node.children[index]==null)
    			node.children[index]=new TrieNode();
    		node=node.children[index];
    	}
    	node.isLeaf=true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode node=root;
    	for(int i=0;i<word.length();i++) {
    		int index=word.charAt(i)-'a';
    		if(node.children[index]==null)
    			return false;
    		node=node.children[index];
    	}
    	return node!=null && node.isLeaf;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode node=root;
    	for(int i=0;i<prefix.length();i++) {
    		int index=prefix.charAt(i)-'a';
    		if(node.children[index]==null)
    			return false;
    		node=node.children[index];
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
