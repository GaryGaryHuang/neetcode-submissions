/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head?.next?.next == null) return

        var slow = head
        var fast = head.next
        // find middle
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        var secondHalf = slow?.next
        slow?.next = null
        
        var prev: ListNode? = null
        while (secondHalf != null) {
            val temp = secondHalf?.next
            secondHalf?.next = prev
            prev = secondHalf
            secondHalf = temp
        }

        var node1 = head
        var node2 = prev
        while (node2 != null) {
            val next1 = node1?.next
            node1?.next = node2
            val next2 = node2?.next
            node2?.next = next1
            node1 = next1
            node2 = next2
        }
    }
}
