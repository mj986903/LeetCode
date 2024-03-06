/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;
        int pos = 0;
        while(tortoise != null && tortoise.next != null){
            tortoise = tortoise.next.next;
            hare = hare.next;
            pos++;
            if(hare == tortoise){
                hare = head;
                while(hare != tortoise){
                    hare = hare.next;
                    tortoise = tortoise.next;
                }
                return hare;
            }
        }
        return null;
    }
}