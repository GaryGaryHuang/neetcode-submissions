/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null || head.next == null) return true

        var slow = head
        var fast = head.next?.next
        while (fast?.next != null) {
            slow = slow!!.next
            fast = fast.next?.next
        }

        var prev: ListNode? = null
        var node: ListNode? = slow!!.next
        while (node!!.next != null) {
            val temp = node.next
            node.next = prev
            prev = node
            node = temp
        }

        var nodeA = head
        var nodeB = node
        while (nodeB != null) {
            if (nodeA!!.`val` != nodeB.`val`) return false
            nodeA = nodeA.next
            nodeB = nodeB.next
        }
        return true
    }
}
