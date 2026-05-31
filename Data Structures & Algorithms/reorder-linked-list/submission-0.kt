/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        var current = head
        while (current?.next?.next != null) {
            val temp = current?.next

            var secondToLast = temp
            var last = secondToLast?.next
            while (last?.next != null) {
                secondToLast = last
                last = last?.next
            }
            //  split the last one
            secondToLast?.next = null

            current?.next = last
            last?.next = temp
            current = temp
        }
    }
}

/**
Original: 2 -> 4 -> 6 -> 8
Reorder: 2 -> 8 -> 4 -> 6

The current node should point to the last node, 
and the last node should point to the current node’s next node. 
Iterate through the nodes until the next node is null.
*/
