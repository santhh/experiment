import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

class TreeNode1 {
  int val;
  TreeNode1 left;
  TreeNode1 right;
  TreeNode1() {}

  TreeNode1(int val) {
    this.val = val;
  }

  TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}


public class CommonBSTNodes {

  public static TreeNode1 insert(TreeNode1 node, int key)
  {
    /* If the tree is empty, return a new Node */
    if (node == null) return new TreeNode1(key);

    /* Otherwise, recur down the tree */
    if (key < node.val)
      node.left = insert(node.left, key);
    else if (key > node.val)
      node.right = insert(node.right, key);

    /* return the (unchanged) Node pointer */
    return node;
  }

  public static void populate (TreeNode1 root,  Stack<TreeNode1> s ){
       if(root==null) return;
       s.push(root);
       populate(root.left,s);
     }

  public static List<Integer> findCommonnElements(TreeNode1 root1, TreeNode1 root2){
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode1> s1 = new Stack<>();
    Stack<TreeNode1> s2 = new Stack<>();
    populate(root1, s1);
    populate(root2,s2);

    while (!s1.isEmpty() && !s2.isEmpty()){
      TreeNode1 r1 = s1.peek();
      TreeNode1 r2 = s2.peek();
      if(r1.val<r2.val){
        s1.pop();
        populate(r1.right,s1);
      }else if (r2.val<r1.val){
        s2.pop();
        populate(r2.right,s2);
      }else{
        result.add(r1.val);
        s1.pop();
        s2.pop();
        populate(r1.right,s1);
        populate(r2.right,s2);



      }
    }

    return result;

  }

  public static void main (String args[]){
    TreeNode1 root1 = null;
    root1 = insert(root1, 5);
    root1 = insert(root1, 1);
    root1 = insert(root1, 10);
    root1 = insert(root1, 0);
    root1 = insert(root1, 4);
    root1 = insert(root1, 7);
    root1 = insert(root1, 9);

    // Create second tree as shown in example
    TreeNode1 root2 = null;
    root2 = insert(root2, 10);
    root2 = insert(root2, 7);
    root2 = insert(root2, 20);
    root2 = insert(root2, 4);
    root2 = insert(root2, 9);

    System.out.println(findCommonnElements(root1,root2));
  }
}
