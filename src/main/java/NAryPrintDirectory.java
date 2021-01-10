import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class N {
  String name;
  List<N> child;
   public N(String name){
     this.name =name;
     child = new ArrayList<>();
   }


}
public class NAryPrintDirectory {
static List<String> result = new ArrayList<>();

public static void BFSRecurse(N root){
    if (root == null) return ;
    result.add(root.name);
    for (N child : root.child){
      BFSRecurse(child);
    }
  }

  public static void main (String args[]){
    List<String> files = new ArrayList<>();
    files.addAll(Arrays.asList("tsconfig.json", "index.html", "images/image.png",
        "app/tests/components/header","app/services", "app/components/header"));
    //files.addAll(Arrays.asList("a/b", "a/c", "a/b/d"));
      N root = new N("");

      files.forEach(file->{
        List<String> folders = Arrays.asList(file.split("/"));
        N current = root;
        AtomicInteger level = new AtomicInteger(0);
        for (String name: folders){
           current = current.child.stream().filter(n-> n.name.contains(name)).findFirst()
               .orElse(current);
          level.getAndIncrement();
          if(current.name.indexOf(name)<0){
            StringBuilder nodeName = new StringBuilder();
            int i=0;
            while(i<level.get()){
              i++;
              nodeName.append("-");
            }
            N newfolder = new N(nodeName.append(name).toString());
            current.child.add(newfolder);
            current = newfolder;

          }
        }

      });

      BFSRecurse(root);
      System.out.println(result);


  }
}
