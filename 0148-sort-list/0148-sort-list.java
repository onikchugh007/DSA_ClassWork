class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode left = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;

        ListNode ans = null;
        left = sortList(left);
        right = sortList(right);
        ans = merge(left,right);
        return ans;
    }

    public ListNode merge(ListNode left,ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode temp1 = left;
        ListNode temp2 = right;

        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }
            else if(temp1.val >= temp2.val){
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1 == null){
            temp.next = temp2;
        }
        else if(temp2 == null){
            temp.next = temp1;
        }
        return dummy.next;
    }
}