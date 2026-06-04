/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var length = 0
        var current = head
        while (current != null) {
            current = current.next
            length++
        }

        val targetIndex = length - n
        if (targetIndex == 0) return head?.next

        var prev: ListNode? = null
        current = head
        var index = 0
        while (index < targetIndex) {
            prev = current
            current = current?.next
            index++
        }
        prev?.next = current?.next

        return head
    }
}
