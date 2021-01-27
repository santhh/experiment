import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

class Folder {
  String name;
  List<Folder> child;
  public Folder(String name){
    this.name = name;
    child = new ArrayList<>();
  }
}
public class PrintFileDirectoryP {

  public static void DFS(Folder root){
    if(root ==null) return;
    System.out.println(root.name);
    for (Folder folder : root.child){
      DFS(folder);
    }
  }

    public static Folder createPath(List<String> files){
      Folder root = new Folder("");
      files.forEach(file->{
        Scanner scan = new Scanner(file);
        AtomicInteger level = new AtomicInteger(0);
        scan.useDelimiter("/");
        Folder current = root;
        while(scan.hasNext()){
          Folder node = new Folder(scan.next());
          current = root.child.stream().filter(f->f.name==node.name).findFirst().orElse(current);
          level.getAndIncrement();
          if(current.name.indexOf(node.name)<0){
            StringBuilder builder = new StringBuilder();
            int i = 0;
            while(i<level.get()){
              builder.append("-");
              i++;
            }
            node.name= builder.toString().concat(node.name);
            current.child.add(node);
            current = node;
          }


        }

      });
      return root;
  }

  public static void main (String args[]) {
    ImmutableList<String> files = ImmutableList.of("/app/components/header",
        "/app/services", "/app/tests/components/header",
        "/images/image.png", "tsconfig.json", "index.html");
    Collections.sort(new ArrayList<>(files));
    DFS(createPath(files));

  }
}
