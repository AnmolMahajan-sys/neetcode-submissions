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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        return mergeKListsHelper(lists,0,lists.length-1);
    }
    private ListNode mergeKListsHelper(ListNode[] lists,int start,int end){
        if(start==end) return lists[end];
        if(end==start+1) return merge2Lists(lists[start],lists[end]);

        int mid=start+(end-start)/2;

        ListNode left=mergeKListsHelper(lists,start,mid);
        ListNode right=mergeKListsHelper(lists,mid+1,end);

        return merge2Lists(left,right);
    }
    private ListNode merge2Lists(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode ptr=dummy;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                ptr.next=l1;
                l1=l1.next;
                ptr=ptr.next;
            }else{
                ptr.next=l2;
                l2=l2.next;
                ptr=ptr.next;
            }
        }
        ptr.next=(l1!=null)?l1:l2;
        return dummy.next;
    }
}
