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
    private static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        int max = Integer.MIN_VALUE;
        ListNode temp = head;
        ListNode prev = null;
        
        while(temp != null){
            if(temp.val < max){
                prev.next = temp.next;
                temp = temp.next;
                continue;
            }
            max = Math.max(max,temp.val);
            prev = temp;
            temp = temp.next;
        }
        return reverse(head);
    }
}