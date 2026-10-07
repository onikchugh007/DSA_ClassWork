public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0 , lenB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;

        while(tempA != null){
            tempA = tempA.next;
            lenA++;
        }

        while(tempB != null){
            tempB = tempB.next;
            lenB++;
        }

        int diff = Math.abs(lenA - lenB);
        tempA = headA;
        tempB = headB;
        if(lenA > lenB){
            for(int i=0;i<diff;i++){
                tempA = tempA.next;
            }
        }
        else{
            for(int i=0;i<diff;i++){
                tempB = tempB.next;
            }
        }

        while(tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
}