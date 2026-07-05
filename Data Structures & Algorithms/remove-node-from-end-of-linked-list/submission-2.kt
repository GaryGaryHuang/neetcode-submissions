/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var len = 0
        var current = head
        while (current != null) {
            current = current.next
            len++
        }

        val removeIndex = len - n
        if (removeIndex == 0) return head?.next

        var index = 0
        current = head
        while (index + 1 < removeIndex) {
            current = current!!.next
            index++
        }
        current!!.next = current.next!!.next

        return head
    }
}
