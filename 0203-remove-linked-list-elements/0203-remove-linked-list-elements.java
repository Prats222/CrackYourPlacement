class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dum = new ListNode(0); // Create a dummy node
        ListNode current = dum;         // Pointer to build the new list
        dum.next = head;                // Link dummy node to head of the list
        ListNode temp = head;           // Temporary pointer to traverse the list
        
        while (temp != null) {
            if (temp.val != val) {
                current.next = temp;    // Keep the node if its value is not 'val'
                current = current.next; // Move 'current' pointer forward
            }
            temp = temp.next;           // Move 'temp' pointer forward
        }
        
        current.next = null; // Terminate the list
        return dum.next;     // Return the new head (next of dummy)
    }
}
