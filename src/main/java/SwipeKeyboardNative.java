import com.google.common.collect.ImmutableList;

public class SwipeKeyboardNative {

  public static int find(String haystack, Character needle){
    int i =0;
    while (i< haystack.length()){
      if(haystack.charAt(i) ==needle){
        return i;
      }
      i +=1;
    }
    return -1;

  }
  public static boolean findWord(String word, String path ){
    int i =0;
    for (Character c: word.toCharArray()){
      int pos = find(path.substring(i),c);
      if(pos==-1) return false;
      i +=pos;
    }
    return true;
  }
  public static void main(String args[]){
    //['google','bah','apple','boba','tea']
    ImmutableList<String> dict = ImmutableList.of("google", "bah", "apple","boba","tea");
    String path = "ghjkoijhghjklkjhgfde";
    StringBuilder res = new StringBuilder();
    for (String word : dict){
      if(findWord(word, path)){
        res.append(word);
      }
    }
    System.out.println(res);





  }
}
