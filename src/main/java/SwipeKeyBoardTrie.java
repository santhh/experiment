import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

class TrieNode {

  Character c;
  List<TrieNode> child;
  boolean isWord;

  public TrieNode(Character c) {
    this.c = c;
    child = new ArrayList<>();
    isWord = false;
  }

  public void addNode(String word) {
    TrieNode current = this;
    for (Character c : word.toCharArray()) {
      boolean childFound = false;
      for (TrieNode child : current.child) {
        if (child.c == c) {
          current = child;
          childFound = true;
          break;
        }
      }
      if (!childFound) {
        TrieNode newNode = new TrieNode(c);
        current.child.add(newNode);
        current = newNode;
      }
    }
    current.isWord = true;

  }


}
public class SwipeKeyBoardTrie {
  static StringBuilder res = new StringBuilder();
  static List<String> match = new ArrayList<>();
  public static void main(String args[]) {
    ImmutableList<String> words = ImmutableList.of("apple", "bah", "google", "boba", "tea");
    String path = "ghjkoijhghjklkjhgfde";
    TrieNode root = new TrieNode(' ');
    for (String word : words) {
      root.addNode(word);
    }
    DFS(root);
    //System.out.println(res.toString().trim());
    String res = findWord(root,path);
    System.out.println(res);
    System.out.println(match);
  }
  public static  String findWord (TrieNode node, String path){
    StringBuilder sb = new StringBuilder();
    TrieNode current = node;
    sb.append(node.c);
    for (TrieNode child : current.child){
      int pos = find(path, child.c);
      if(pos!=-1){
        sb.append(findWord(child,path.substring(pos)));
      }
    }

    match.add(sb.toString());
    return sb.toString();
  }

  public static int find(String path, Character c){
    int i =0;
    while (i< path.length()){
      if(path.charAt(i)==c){
        return i;
      }
      i +=1;
    }
    return -1;
  }


  public static void DFS(TrieNode node){
    res.append(node.c);
    if(node.isWord){
      res.append("\n");
    }
    for( TrieNode child : node.child){
      DFS(child);
    }
  }

}
