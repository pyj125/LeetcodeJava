package history;

public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode a = p,b=p,pre=null;
        while(--left>=0){
            pre = a;
            a= a.next;
        }
        while(--right>=0){
            b= b.next;
        }
        ListNode temp =  reverseGapNode(a,b);
        pre.next = temp;
        return p.next;
    }

    private ListNode reverseGapNode(ListNode head,ListNode tail){
        //尾结点不是null 而是tail.next 反转后将作为 head节点的前驱
        //要考虑到前驱，后继，游标当前移动指针
        ListNode pre = tail.next;
        ListNode record = tail.next;
        ListNode p = head;
        ListNode q = null;
        while(p != record){
            q = p.next;
            p.next = pre;
            pre = p;
            p=q;
        }
        return pre;
    }

    public static void main(String[] args) {
        LeetCode92 solution = new LeetCode92();
        ListNode a0 = new ListNode(11);
        ListNode a1 = new ListNode(12);
        ListNode a2 = new ListNode(13);
        ListNode a3 = new ListNode(14);
        ListNode a4 = new ListNode(15);
        a0.next= a1;
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=null;
        ListNode res = solution.reverseBetween(a0,2,4);
        System.out.println(res);
    }
}

