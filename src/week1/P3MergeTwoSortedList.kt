package week1

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class P3MergeTwoSortedList {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var l1 = list1
        var l2 = list2
        val result = ListNode(0)

        while (l1 != null && l2 != null) {
            if (l1.`val` <= l2.`val`) {
                result.next = l1
                l1 = l1.next
            } else {
                result.next = l2
                l2 = l2.next
            }
        }
        result.next = l1 ?: l2

        return result.next
    }
}