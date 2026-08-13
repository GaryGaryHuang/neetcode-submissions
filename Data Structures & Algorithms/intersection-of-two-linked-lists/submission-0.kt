/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var nodeA = headA
        var nodeB = headB
        while (nodeA != nodeB) {
            if (nodeA == null) nodeA = headB
            else nodeA = nodeA.next

            if (nodeB == null) nodeB = headA
            else nodeB = nodeB.next
        }
        return nodeA
    }
}
