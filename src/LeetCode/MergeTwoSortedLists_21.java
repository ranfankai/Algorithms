package LeetCode;

/**
 * Created by haha on 2018/7/17.
 */

public class MergeTwoSortedLists_21 {
    //非递归
//    public LeetCode.ListNode mergeTwoLists(LeetCode.ListNode l1, LeetCode.ListNode l2) {
//        if (l1 == null)return l2;
//        if (l2 == null)return l1;
//        LeetCode.ListNode res = new LeetCode.ListNode(-1);
//        LeetCode.ListNode head = res;
//        while (l1 != null && l2 != null)
//        {
//            if (l1.val <= l2.val)
//            {
//                res.next = new LeetCode.ListNode(l1.val);
//                res = res.next;
//                l1 = l1.next;
//            }
//            else {
//                res.next = new LeetCode.ListNode(l2.val);
//                res = res.next;
//                l2 = l2.next;
//            }
//        }
//        if (l2 != null)l1 = l2;
//
//        while (l1 != null)
//        {
//            res.next = new LeetCode.ListNode(l1.val);
//            res = res.next;
//            l1 = l1.next;
//        }
//        return head.next;
//    }
    //递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)return l2;
        if (l2 == null)return l1;
        ListNode head = null;

        if (l1.val <= l2.val)
        {
            head = l1;
            head.next = mergeTwoLists(l1.next,l2);
        }
        else
        {
            head = l2;
            head.next = mergeTwoLists(l2.next,l1);
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);ListNode l2 = new ListNode(2);ListNode l3 = new ListNode(4);
        l1.next = l2; l2.next = l3;

        ListNode l4 = new ListNode(1);ListNode l5 = new ListNode(3);ListNode l6 = new ListNode(4);
        l4.next = l5; l5.next = l6;
        ListNode head = new MergeTwoSortedLists_21().mergeTwoLists(l1,l4);
        while (head!=null){
            System.out.println(head.val);head = head.next;
        }
    }
}
