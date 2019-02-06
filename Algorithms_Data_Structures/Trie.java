public class Trie {
    public Trie[] children;
    char c;
    boolean word;
    public Trie() {
    	this.c = 0;
    	this.word = false;
    	this.children = new Trie[27];
    }
    public void insert(String s) {

    	 if(s.isEmpty()){
    	 	word = true;
    	 	int index = '{' - 'a';
    	 	children[index] = new Trie();
    		children[index].c = '{' - 'a';
    	 	return;
    	 }

    	char letter = s.charAt(0);
    	int index = letter - 'a';
    	if(children[index] == null){
    		children[index] = new Trie();
    		children[index].c = letter;
    	}
    	children[index].insert(s.substring(1));
    }
    public boolean query(String s) {
    	if(s.isEmpty()){
    		return word;
    	}
    	int index = s.charAt(0) - 'a';
    	if(children[index] == null){
    		return false;
    	}
    	return children[index].query(s.substring(1));
    }
}
