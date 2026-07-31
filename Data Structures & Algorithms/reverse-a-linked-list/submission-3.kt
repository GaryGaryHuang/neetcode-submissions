/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var current: ListNode? = head
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
0 -> 1 -> 2 -> 3

a. null <- 0
b. 1 <- 2
c. 2 <- 3
d. return 3

If I change the current node's next, the original next node will disappear.
To prevent not missing the original node, I need to keep it.

Prev null 0 1 2     3
Curr 0    1 2 3     null
Next 1    2 3 null  null

*/
