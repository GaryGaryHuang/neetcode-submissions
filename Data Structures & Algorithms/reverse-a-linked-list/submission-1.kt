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
Prev -> Node -> Next -> Next Next
Keep the Next First and reverse the current Node's next.
Pre <- Node , Next -> Next Next
I keep the Next first, so I still have this address.
Set the current node to Prev and Set the Next node to current.
*/