
class MyNode{
  int value =0;
  MyNode next;
  public MyNode(int value){
    this.value=value;
    next = null;
  }
}
public class LinkedList {


  public static MyNode insertTail (MyNode head, int value){
    if(head==null){
      return new MyNode(value);
    }
    MyNode prev = null;
    MyNode dummy = head;
    while (head !=null){
      prev = head;
      head = head.next;
    }
    prev.next = new MyNode(value);
    return dummy;

  }

  public static MyNode insertHead(MyNode head, int value){
    if(head==null){
      return  new MyNode(value);
    }
    MyNode newHead = new MyNode(value);
    newHead.next = head;
    return newHead;

  }

  public static MyNode delete(MyNode head, int value){
    MyNode dummy = new MyNode(-1);
    MyNode prev =dummy;
    dummy.next = head;
    while (head!=null){
      if(head.value==value){
        prev.next = head.next;
      }else{
        prev = head;
      }
      head = head.next;
    }

    return dummy.next;
  }

  public static MyNode rotate(MyNode head){
    MyNode prev = null;

    while (head!=null){
      MyNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;

    }
    return prev;
  }

  public static MyNode mergeTwoList(MyNode l1, MyNode l2){
    MyNode dummy = new MyNode(-1);
    MyNode prev =dummy;
    while (l1!=null && l2!=null){
      if(l1.value <= l2.value){
        prev.next = l1;
        l1 = l1.next;
      } else{
        prev.next = l2;
        l2 = l2.next;
      }
      prev = prev.next;
    }
    prev.next = l1!=null?l1:l2;
    return dummy.next;
  }
  public static boolean isCycle(MyNode head){

    MyNode fast = head;
    MyNode slow = head;
    while (fast!=null && fast.next!=null){
      fast = fast.next.next;
      slow = slow.next;
      if (fast==slow){
        return true;
      }
    }
    return false;
  }

  public static void main (String args[]){
      MyNode head =null;
    head = insertTail(head, 2);
    head = insertTail(head, 4);
    head = insertTail(head, 6);
   // head = delete(head, 4);
   //  head = rotate(head);
   //  while (head!=null){
   //    System.out.print(head.value+" ");
   //    head = head.next;
   //  }
   //  System.out.println();
    MyNode head1 =null;
    head1 = insertTail(head1, 1);
    head1 = insertTail(head1, 3);
    head1 = insertTail(head1, 5);
   //  head1 = rotate(head1);
   //  while (head1!=null){
   //    System.out.print(head1.value+" ");
   //    head1 = head1.next;
   //  }
    System.out.println();
    MyNode newHead = mergeTwoList(head, head1);
    while (newHead!=null){
      System.out.println(newHead.value);
      newHead = newHead.next;
    }



  }
}
