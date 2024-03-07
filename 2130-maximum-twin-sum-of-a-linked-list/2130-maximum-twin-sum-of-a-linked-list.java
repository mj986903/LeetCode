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
    public int pairSum(ListNode head) {
        ListNode temp = head;
        int n = 0;
        while(temp != null){
            temp = temp.next;
            n++;
        }
        
        int mid = n/2;
        ListNode prev = null;
        ListNode curr = head;
        for(int i=0;i<mid;i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        int sum = 0;
        for(int i=0;i<mid;i++){
            sum = Math.max(sum,prev.val+curr.val);
            prev = prev.next;
            curr = curr.next;
        }
        return sum;
    }
}



/*class Solution {
    public int pairSum(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null){
            list.add(curr.val);
            curr = curr.next;
        }
        int left = 0;
        int right = list.size()-1;
        int sum = 0;
        while(left<right){
            sum = Math.max(sum,list.get(left)+list.get(right));
            left++;
            right--;
        }
        return sum;
    }
}*/