        else
        {
            head = new ListNode(l1.val);
            l1 = l1.next;
        }
        ListNode result = head;
        while (l1 != null && l2 != null)
        {
            System.out.println("L1.val = " + l1.val + " l2.val: " + l2.val);
            if (l1.val < l2.val)
            {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else
            {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        while (l1 != null)
        {
            head.next = new ListNode(l1.val);
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null)
        {
            head.next = new ListNode(l2.val);
            head = head.next;
            l2 = l2.next;
        }
        return result;
        
        // while (l1 != null || l2 != null)
        // {
        //     while (l2 != null && l1.val > l2.val)
        //     {
        //         System.out.println("In first while, l2 = " + l2.val);
        //         head.next = new ListNode(l2.val);
        //         head = head.next;
        //         l2 = l2.next;
        //     }
        //     while (l1 != null && l2.val > l1.val)
        //     {
        //         System.out.println("In second while, l1 = " + l1.val);
        //         head.next = new ListNode(l1.val);
        //         head = head.next;
        //         l1 = l1.next;
        //     } 
        // }
        // return head;
    }
}
