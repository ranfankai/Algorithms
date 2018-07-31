package LeetCode;

class ListNode {
    int val;
    ListNode next;
    //LeetCode.ListNode(){};
    ListNode(int x) { val = x; }
}

class AddTwoNumbers_2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        if (l1 == null || l2 == null)return null;
        ListNode res = new ListNode(0);
        ListNode head = res;

        //res = res.next;
        while(l1 != null || l2 !=null || carry > 0)
        {
            res.next = new ListNode(0);
            res = res.next;

            if (l1 != null && l2 !=null){
                res.val = l1.val + l2.val + carry;
                l1 = l1.next;l2 = l2.next;
            }
            else if (l1 != null){
                res.val = l1.val + carry;
                l1 = l1.next;
            }
            else if (l2!=null) {
                res.val = l2.val + carry;
                l2 = l2.next;
            }
            else res.val = carry;

            if (res.val>=10)
            {
                res.val -= 10;
                carry = 1;
            }
            else carry = 0;
        }
        return head.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers_2 a2 = new AddTwoNumbers_2();

        ListNode l1 = new ListNode(0);


        //l1 = l1.next;
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(8);
        l3.next = l4;

        ListNode res = a2.addTwoNumbers(l1,l3);
        while (res!=null)
        {
            System.out.println(res.val+"->");
            res = res.next;
        }
        //System.out.println(l3);
    }
}
