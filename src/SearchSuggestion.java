import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ankujgup on 18-Feb-20.
 */
class SearchSuggestion {
  class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;
    List<String> suggestions;

    TrieNode() {
      children = new HashMap();
      isWord = false;
      suggestions = new ArrayList();
    }

  }

  class Trie {
    TrieNode root;
    Trie() {
      root = new TrieNode();
    }

    public void insert(String word) {
      TrieNode node = root;
      for (int i=0;i<word.length();i++) {
        Character ch = word.charAt(i);
        node = node.children.computeIfAbsent(ch, k -> new TrieNode());
        if (node.suggestions.size() < 3)
          node.suggestions.add(word);
      }
      node.isWord = true;
    }

    public boolean search(String word) {
      TrieNode node = root;
      for (int i=0;i<word.length();i++) {
        Character ch = word.charAt(i);
        if (node.children.containsKey(ch)) {
          node = node.children.get(ch);
        } else {
          return false;
        }
      }
      return node.isWord;
    }
  }

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {

    Trie trie = new Trie();
    Arrays.sort(products);
    for (int i=0;i<products.length;i++) {
      trie.insert(products[i]);
    }

    List<List<String>> result = new ArrayList<>();
    TrieNode temp = trie.root;
    for (int i=0;i<searchWord.length();i++) {
      Character ch = searchWord.charAt(i);
      if (temp != null) {
        temp = temp.children.getOrDefault(ch, null);
      }
      result.add(temp != null ? temp.suggestions : new ArrayList<>());
    }
    return result;

  }


}
