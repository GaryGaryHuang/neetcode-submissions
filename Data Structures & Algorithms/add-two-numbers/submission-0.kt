/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val head = ListNode(0)
        var n1 = l1
        var n2 = l2
        var node = head

        var add = 0
        while (n1 != null || n2 != null) {
            val sum = (n1?.`val` ?: 0) + (n2?.`val` ?: 0) + add
            add = sum / 10

            val next = ListNode(sum % 10)
            node.next = next
            node = next

            n1 = n1?.next
            n2 = n2?.next
        }
        if (add > 0) {
            node.next = ListNode(add)
        }

        return head.next
    }
}

/**
1 2 3 4 5 -> 54321
1 2 -> 21
54321 + 21 = 54342 -> 2 4 3 4 5

9 8 7 6 -> 6789
6 7 8 -> 876
6789 + 876 = 7665 -> 5 6 6 7
*/
