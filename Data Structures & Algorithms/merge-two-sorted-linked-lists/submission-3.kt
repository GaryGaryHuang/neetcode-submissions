/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy: ListNode = ListNode(0)
        var tail: ListNode = dummy
        var node1: ListNode? = list1
        var node2: ListNode? = list2
        while (node1 != null && node2 != null) {
            if (node1.`val` <= node2.`val`) {
                tail.next = node1
                node1 = node1.next
            } else {
                tail.next = node2
                node2 = node2.next
            }
            tail = tail.next!!
        }
        tail.next = node1 ?: node2
        return dummy.next
    }
}

/**
Use a dummy node to simplify head handling.
Keep `tail` pointing to the last node in the merged list.

While both lists are non-empty, compare their current nodes, 
attach the smaller one to `tail.next`, advance the pointer of the list we used, 
then move `tail` forward.

When one list is exhausted, append the remaining sorted suffix of the other list.
*/
