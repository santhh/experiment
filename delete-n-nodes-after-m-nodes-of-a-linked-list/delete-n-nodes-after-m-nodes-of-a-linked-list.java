/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode newHead =head;
      
        while (head !=null){
            for (int i =0; i<m & head !=null; i++){
                prev = head;
                head = head.next;
            }
            
            for (int i = 0;i< n && head !=null; i++){
                head = head.next;
            }
            
            prev.next = head;
        }
        
     return  newHead;
    }
}