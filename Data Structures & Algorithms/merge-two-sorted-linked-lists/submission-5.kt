/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var current = dummy
        var node1 = list1
        var node2 = list2
        while (node1 != null && node2 != null) {
            if (node1.`val` <= node2.`val`) {
                current.next = node1
                current = node1
                node1 = node1.next
            } else {
                current.next = node2
                current = node2
                node2 = node2.next
            }
        }
        if (node1 != null) current.next = node1
        if (node2 != null) current.next = node2
        return dummy.next
    }
}

/**
Create dummy node, and then compare two nodes,
if node1's value is less than or equal to node2's value,
dummy node points to node1, otherwise point to node2.

If node1 or node2 is null, we can stop comparing
because the current node is already sorted.
*/