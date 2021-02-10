
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
    MyNode current = dummy;
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

  public boolean detectCycle(MyNode head){
    MyNode fast = head;
    MyNode slow = head;
    while (fast!=null && fast.next!=null){
      fast = fast.next.next;
      slow = slow.next;
      if(fast ==slow) return  true;
    }
    return false;
  }
  // merge sort
  public static MyNode sort(MyNode head){
      if (head == null || head.next == null) return  head;
      MyNode fast = head;
      MyNode slow = head;
      MyNode prev =null;
      while (fast !=null && fast.next!=null){
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
      }
      prev.next = null;

      MyNode l1 = sort(slow);
      MyNode l2 = sort(head);
      return merge (l1,l2);

  }

  public static MyNode merge(MyNode l1, MyNode l2){
    MyNode l = new MyNode(0);
    MyNode p = l;
    while (l1!=null || l2!=null){
      if(l1.value<l2.value){
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }
    if (l1!=null){
     p.next = l1;
    }

    if (l2!=null){
      p.next =l2;
    }
    return l.next;
  }


  public static void main (String args[]){
    MyNode head = null;
    head = insertTail (head, 2);
    head = insertTail (head, 4);
    head = insertTail (head, 5);
    //print(head);
    //System.out.println();
    // MyNode head1 = null;
    // head1 = insertHead (head1, 2);
    // head1 = insertHead (head1, 4);
    // head1 = insertHead (head1, 5);
    // head1 = insertHead (head1, 6);
    //  print(head1);
    // System.out.println();
    // print(reverse(head));
    // System.out.println();
   // print(reverseBetween(head1,1,2));
    print(sort(head));

  }
}
