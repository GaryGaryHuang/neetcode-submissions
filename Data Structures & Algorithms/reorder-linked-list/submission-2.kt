/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        var slow = head
        var fast = head?.next
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        var left = head
        var right = reverse(slow?.next)
        slow?.next = null

        while (left != null && right != null) {
            val nextToLeft = left.next
            val nextToRight = right.next

            left.next = right
            left = left.next
            left?.next = nextToLeft

            left = nextToLeft
            right = nextToRight
        }
    }

    private fun reverse(head: ListNode?): ListNode? {
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
[0, 1, 2, 3, 4, 5, 6]
-> [0, 6, 1, 5, 2, 4, 3]
The first node points to the last node.
The second node points to the second to last. 
I need to find the middle node so that 
I can split the array into the left part and the right part.
Then I reverse the right part.
Finally, I can merge these two linked lists.

I will use fast-slow pointers to find the middle node.
*/
