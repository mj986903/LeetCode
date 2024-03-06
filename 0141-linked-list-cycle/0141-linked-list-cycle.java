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
    public boolean hasCycle(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;

        while(tortoise != null && tortoise.next != null){
            tortoise = tortoise.next.next;
            hare = hare.next;

            if(tortoise == hare){
                return true;
            }
        }
        return false;
    }
}