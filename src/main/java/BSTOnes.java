class Node{
  Node left,right;
  int data;
  Node(int data){
    this.data=data;
    left=right=null;
  }
}
public class BSTOnes {

  public static Node insert(Node root,int data){
    if(root==null){
      return new Node(data);
    }
    else{
      Node cur;
      if(data<=root.data){
        cur=insert(root.left,data);
        root.left=cur;
      }
      else{
        cur=insert(root.right,data);
        root.right=cur;
      }
      return root;
    }
  }
  static int maxHeight =0;
  public static int getHeight(Node root){
    if (root ==null) return 0;
    int leftHeight = 1+ getHeight(root.left);
    int rightHeight = 1+ getHeight(root.right);
    maxHeight = Math.max(rightHeight,leftHeight);
    return maxHeight;
  }

  public static int calcHeight(Node root){
    if (root==null) return 0;
    int leftHeight = 1+ getHeight(root.left);
    int rightHeight = 1+ getHeight(root.right);
    return Math.max(leftHeight,rightHeight)-1;
  }
  static int totalSum =0;
  public static int nodeSum(Node root){
    if (root ==null) return 0;
    totalSum += root.data;
    nodeSum(root.left);
    nodeSum(root.right);
    return totalSum;

  }
  static int maxValue =0;
  public static int maxNode(Node root){
    if(root==null) return 0;
    maxValue = Math.max(maxValue, root.data);
    maxNode(root.right);
    maxNode(root.right);
    return maxValue;


  }

  public static int findHeight(Node root){
    if(root==null) return -1;
    return 1+Math.max(findHeight(root.left),findHeight(root.right));
  }
  public static int findDepth(Node root){
    if(root==null) return 0;
    return 1+Math.max(findDepth(root.left),findDepth(root.right));
  }

  public static void main (String args[]){
    Node root=null;
    root=insert(root,3);
    root=insert(root,5);
    root=insert(root,2);
    root=insert(root,1);
    root=insert(root,4);
    root=insert(root,6);
    root=insert(root,7);
    System.out.println(calcHeight(root));
    System.out.println(nodeSum(root));
    System.out.println(maxNode(root));
    System.out.println(findHeight(root));
    System.out.println(findDepth(root));
  }
}
