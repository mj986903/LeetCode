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
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp = head;
        int n= 0;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        
        int mid = n/2;
        ListNode prev = null;
        ListNode curr = head;
        for(int i=1;i<=mid;i++){
            prev = curr;
            curr = curr.next;
        }
        
        if(prev == null){
            head = head.next;
        }else{
            prev.next = curr.next;
        }
        return head;
    }
}