/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy: ListNode = ListNode(-101)
        var pre: ListNode = dummy
        var node1: ListNode? = list1
        var node2: ListNode? = list2
        while (node1 != null && node2 != null) {
            if (node1.`val` <= node2.`val`) {
                pre.next = node1
                pre = node1!!
                node1 = node1.next
            } else {
                pre.next = node2
                pre = node2!!
                node2 = node2.next
            }
        }
        pre.next = node1 ?: node2
        return dummy.next
    }
}

/**
If the head of list1 is smaller or equal to the head in list2,
let prev node point to it.
When a head is pointed, I need to assign a new head to its next one.

I compare two nodes when they are not null.
If a listNode becomes null first, then I can let the prev node point to the remaining listNode.
*/
