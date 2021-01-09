import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

class TNode {
  public int val;
  public List<TNode> children;
  public TNode parent = null;
  public TNode(int _val) {
    val = _val;
    children = new ArrayList<>();
  }
  public void addChild(TNode _child) {
    _child.parent = this;
    children.add(_child);
  }

  public TNode getChild(int index) {
    if (this.children != null) {
      return this.children.get(index);
    }
    return null;
  }
}



public class MaxDepth {

  static List<Integer> result = new ArrayList<>();
  public static int maxDepth(TNode node) {
    if (node == null)
      return 0;
    if (node.children.isEmpty())
      return 1;
     else{
        List<Integer> res = new ArrayList<>();
        for (TNode n : node.children){
          res.add(maxDepth(n));
        }
      return Collections.max(res)+1;
    }
  }
  public static void recurse(TNode current, List<List<Integer>> result, int level){
    if(current==null) return;
    if(result.size()==level) result.add(new ArrayList<>());
    List<Integer> list = result.get(level);
    list.add(current.val);
    for (TNode n: current.children){
      recurse(n,result,level+1);
    }



  }
  public static List<List<Integer>> BFSRecurse(TNode root){

    List<List<Integer>> result = new ArrayList<>();
    recurse(root, result, 0);
    return result;

  }


  public static List<Integer> BFS(TNode root){
    List<Integer> result = new ArrayList<>();
    Queue<TNode> queue = new ArrayDeque<>();
    queue.add(root);
    while(!queue.isEmpty()){
      TNode current = queue.poll();
      result.add(current.val);
      for (TNode n: current.children){
        queue.add(n);
      }
    }
    return result;
  }

  public static void dfsPreorder(TNode root ){
    if(root ==null) return;
    result.add(root.val);
    for (TNode n : root.children){
      dfsPreorder(n);
    }

  }
  public static void main (String args[]){
    //[1,null,3,2,4,null,5,6]
    TNode root = new TNode(1);
    root.addChild(new TNode(3));
    root.addChild(new TNode(2));
    root.addChild(new TNode(4));
    root.getChild(0).addChild(new TNode(5));
    root.getChild(0).addChild(new TNode(6));
    System.out.println(maxDepth(root));
    System.out.println(BFS(root));
    dfsPreorder(root);
    System.out.println("PreOrder: "+result);



  }
}
