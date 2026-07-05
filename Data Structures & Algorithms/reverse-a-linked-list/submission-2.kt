/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var current = head
        while (current != null) {
            val temp = current.next
            current.next = prev

            prev = current
            current = temp
        }
        return prev
    }
}

/**
0 -> 1 -> 2
Prev, Cur, Temp
null, 0, null

temp = cur's next (1)
prev = cur's next
cur = temp

null <- 0, 1 -> 2
*/
