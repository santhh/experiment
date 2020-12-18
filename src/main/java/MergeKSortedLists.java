import java.util.*;

class ListNode {
  int value;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class MergeKSortedLists {

  public static ListNode merge(ListNode[] lists) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparing(ln->ln.value));
    for (ListNode ln : lists){
      if(ln!=null){
        minHeap.offer(ln);
      }
    }
    ListNode head = null;
    ListNode tail = null;
    while(!minHeap.isEmpty()){
      ListNode current = minHeap.poll();
      if(head==null){
        head = current;
        tail = current;
      }else{
        tail.next = current;
        tail = tail.next;
      }
      if(current.next!=null){
        minHeap.offer(current.next);
      }


    }


    return head;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(6);
    l1.next.next = new ListNode(8);

    ListNode l2 = new ListNode(3);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(7);

    ListNode l3 = new ListNode(1);
    l3.next = new ListNode(3);
    l3.next.next = new ListNode(4);

    ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
    System.out.print("Here are the elements form the merged list: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
