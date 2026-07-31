/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var fast = head
        repeat(n) {
            fast = fast?.next
        }

        val dummy = ListNode(0)
        dummy.next = head

        var prev = dummy
        var current = head
        while (fast != null) {
            fast = fast.next
            prev = current!!
            current = current.next
        }
        prev.next = current!!.next

        return dummy.next
    }
}

/**
9 8 7 6 5 4 3 2 1

*/
