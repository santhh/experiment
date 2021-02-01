import com.google.common.collect.ImmutableList;
import java.util.Deque;
import java.util.LinkedList;

class Trie{
  boolean enfOfWord;
  Trie [] child;
  public  Trie(){
    child = new Trie[26];
    enfOfWord = false;
  }
  public void insert(String s){
   Trie t = this;
    for (Character c: s.toCharArray()){
      if(t.child[c-'a']==null){
        t.child[c-'a'] = new Trie();
      }
      t = t.child[c-'a'];
    }
    t.enfOfWord = true;
  }
  public boolean  search (Deque<Character> s){
      Trie t = this;
      StringBuilder sb = new StringBuilder();
      for (Character c: s){
        if(t.child[c-'a']==null) {
          return false;
        }
        t = t.child[c-'a'];
        sb.append(t.child[c-'a']);
        if(t.enfOfWord) return true;
      }
      return false;


  }
}
public class SwipeKeyBoard {
  static Trie t = new Trie();
   static Deque<Character> inputQueue = new LinkedList<>();
  public static void main (String args[]){
    ImmutableList<String> words = ImmutableList.of("google","bah","apple","boba","tree");
    String path = "bnhjkioikjhnbvcxsza";
    for (String w : words){
      StringBuilder sb = new StringBuilder(w);
      t.insert(sb.reverse().toString());
    }


  }

  public String gussWord(String path){
    return null;
  }
}
