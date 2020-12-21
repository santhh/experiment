import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class TreeNode {
  int val;
  List<Node> children;
  public TreeNode(){
    children = new ArrayList<>();
  }
  public TreeNode(int val){
    this.val = val;
  }
  public TreeNode( int val, List<Node> children){
    this.val= val;
    this.children = children;
  }

}
public class PrintDirectory {



  public static void preProcess(List<String> files){
    Set<String> rootSet = new HashSet<>();
    for (int i=0; i<files.size(); i++){
      String [] folders = files.get(i).split("/");
      if(folders.length>1){
        for(int j=1;j<folders.length;j++){
          if(!rootSet.contains(folders[i])){
            TreeNode n = new TreeNode(j,new ArrayList<>());
          }else{
            rootSet.add(folders[i]);

          }
        }
      }
    }

  }


    public static String printDirectory(String input){
      StringBuilder sb = new StringBuilder();
      String [] temp = input.split("/");
      if(temp.length==1){
        return sb.append("- "+input).toString();
      }
      for (int i=1; i<temp.length;i++){
        int repeat =1;
          while (repeat<=i) {
            sb.append("-");
            repeat++;
          }
          sb.append(" "+temp[i] +"\n");

      }

      return sb.toString();
    }

    public static void main (String args[]){
      //System.out.println(printDirectory("/home/user/foo"));
      List<String> files = new ArrayList<>();
      files.addAll(Arrays.asList("tsconfig.json", "index.html", "/images/image.png",
          "/app/tests/components/header","/app/services", "/app/components/header"));
      Collections.sort(files);
      files.forEach(file->{
        System.out.println(printDirectory(file));
      });
    }
}
