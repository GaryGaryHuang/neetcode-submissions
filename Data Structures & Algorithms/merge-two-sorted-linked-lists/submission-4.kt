/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var node1 = list1
        var node2 = list2
        while (node1 != null && node2 != null) {
            if (node1.`val` <= node2.`val`) {
                val temp = node1.next
                node1.next = node2
                node1 = temp
            } else {
                val temp = node2.next
                node2.next = node1
                node2 = temp
            }
        }
        return when {
            list1 == null -> list2
            list2 == null -> list1
            list1.`val` <= list2.`val` -> list1
            else -> list2
        }
    }
}

/**
Compare two nodes,
if node1's value is less than or equal to node2's value,
node1 points to node2, 
otherwise node2 points to node1.

Before pointing to the other node, keep its next node
so that we can keep comparing nodes.

If node1 or node2 is null, we can stop comparing
because the current node is already sorted.
*/