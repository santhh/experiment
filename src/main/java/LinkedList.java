
class MyNode{
  int value =0;
  MyNode next;
  public MyNode(int value){
    this.value=value;
    next = null;
  }
}
public class LinkedList {

  public static MyNode insertTail(MyNode head, int value){
      MyNode current = head;
      if(head ==null){
        head = new MyNode(value);
        return head;
      }
      while (head.next!=null){
        head = head.next;
      }
      head.next = new MyNode(value);
      return current;
  }
  public static void print (MyNode head){
    while(head!=null){
      System.out.println(head.value);
      head = head.next;
    }
  }
  public static MyNode insertHead(MyNode head , int value){
    if (head==null){
      return new MyNode(value);
    }
    MyNode prevHead = head;
    head = new MyNode(value);
    head.next = prevHead;
    return head;
  }

  public static MyNode reverse(MyNode head){
    MyNode prev = null;

    while (head!=null){
      MyNode next = head.next;
      head.next= prev;
      prev = head;
      head = next;
    }
    return prev;

  }
  public static MyNode reverseBetween(MyNode head , int m, int n){
    MyNode dummy = new MyNode(0);
    dummy.next = head;
    MyNode current = head;
    MyNode prev = null;
    for (int i =0; i<m;i++){
      prev = current;
      current = current.next;
    }
    MyNode prev1  = prev;
    MyNode current2 = current;
   for (int i = m; i<=n;i++){
     MyNode next =  current2.next;
     current2.next  = prev1;
     prev1  = current2;
     current2 = next;
    }

   prev.next = prev1;
   current.next = current2;
   return dummy.next;

  }
  public static void main (String args[]){
    MyNode head = null;
    head = insertTail (head, 2);
    head = insertTail (head, 4);
    head = insertTail (head, 5);
    //print(head);
    //System.out.println();
    MyNode head1 = null;
    head1 = insertHead (head1, 2);
    head1 = insertHead (head1, 4);
    head1 = insertHead (head1, 5);
    head1 = insertHead (head1, 6);
    // print(head1);
    // System.out.println();
    // print(reverse(head));
    // System.out.println();
    print(reverseBetween(head1,1,2));

  }
}
