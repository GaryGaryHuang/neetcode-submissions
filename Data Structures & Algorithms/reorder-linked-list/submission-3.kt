/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        var left = head
        var right = head?.next?.next
        while (right?.next != null) {
            left = left!!.next
            right = right!!.next
        }
        right = left!!.next
        left!!.next = null

        //  Reverse
        var prev: ListNode? = null
        var current: ListNode? = right
        while (current != null) {
            val temp = current.next
            current.next = prev
            prev = current
            current = temp
        }

        // combine
        var node1 = head
        var node2 = prev
        var cur = ListNode(0)
        while (node1 != null && node2 != null) {
            cur.next = node1
            cur = cur.next!!
            node1 = node1.next

            cur.next = node2
            cur = cur.next!!
            node2 = node2.next
        }
        cur.next = node1
    }
}

/**
1. Find the middle node  
   → Use slow and fast pointers to locate the middle node.  
2. Reverse the second half of the list.  
3. Merge the two lists.
*/
