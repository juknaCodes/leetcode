import java.util.HashMap;
import java.util.Map;

/**
 * Created by ankujgup on 08-Mar-20.
 */
public class DataSearchAdd {

  Trie trie;

  class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    TrieNode() {
      children = new HashMap();
      isWord = false;
    }
  }

  class Trie {
    TrieNode root;

    Trie() {
      root = new TrieNode();
    }
  }

  /** Initialize your data structure here. */
  public DataSearchAdd() {
    trie = new Trie();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    TrieNode crawl = trie.root;
    for (int i=0;i<word.length();i++) {
      Character ch = word.charAt(i);
      crawl = crawl.children.computeIfAbsent(ch, k -> new TrieNode());
    }
    crawl.isWord = true;
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  public boolean search(String word) {
    return searchUtil(word, 0, trie.root);
  }

  public boolean searchUtil(String word, int k, TrieNode root) {
    if (root == null) return false;
    if (k == word.length()) return root.isWord;
    if (word.charAt(k) != '.') {
      return searchUtil(word, k+1, root.children.get(word.charAt(k)));
    } else {
      for (Character ch : root.children.keySet()) {
        if (root.children.containsKey(ch) &&
          searchUtil(word, k+1, root.children.get(ch))) {
          return true;
        }
      }
    }

    return false;


  }
}
