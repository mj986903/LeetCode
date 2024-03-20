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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int count = 0;
        
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode temp = list1;
        
        while(count<a){
            p1 = temp;
            temp = temp.next;
            count++;
        }
        while(count<=b){
            p2 = temp.next;
            temp = temp.next;
            count++;
        }
        temp = list2;
        while(temp.next != null){
            temp = temp.next;
        }
        
        p1.next = list2;
        temp.next = p2;
        
        return list1;
    }
}