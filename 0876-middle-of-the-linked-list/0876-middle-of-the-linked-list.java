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
    public ListNode middleNode(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;
        while(tortoise != null && tortoise.next != null){
            hare = hare.next;
            tortoise = tortoise.next.next;
        }
        return hare;
    }
}