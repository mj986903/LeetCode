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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null && head.next == null){
            return null;
        }
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        int index = size-n+1;
        ListNode prev = null;
        ListNode curr = head;
        for(int i=1;i<index;i++){
            prev = curr;
            curr = curr.next;
        }
        if(prev == null){
            head = head.next;
            return head;
        }else{
            prev.next = curr.next;
            return head;
        }
    }
}
