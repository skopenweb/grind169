package week2

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

}

class LevelOrderTraversal {

//    fun levelOrder2(n: TreeNode?): List<List<Int>> {
//        val result = LinkedList<List<Int>>()
//        val nodes = LinkedList<TreeNode?>().map{it}
//        val currLevel = LinkedList<Int>()
//
//        nodes.apply {
//            offer(n)
//            offer(null)
//        }
//        while (nodes.isNotEmpty()) {
//            val node = nodes.poll()
//            if (node == null) {
//                result.offer(currLevel.toList())
//                currLevel.clear()
//                if (nodes.isNotEmpty()) {
//                    nodes.offer(null)
//                }
//            } else {
//                currLevel.offer(node.`val`)
//                if (node.left != null) {
//                    nodes.offer(node.left)
//                }
//                if (node.right != null) {
//                    nodes.offer(node.right)
//                }
//            }
//        }
//        return result
//    }

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = LinkedList<List<Int>>()
        var currList = LinkedList<TreeNode?>().apply {
            offer(root)
        }
        while (currList.isNotEmpty()) {
            val newList = LinkedList<TreeNode?>()
            val level = mutableListOf<Int>()

            while (currList.isNotEmpty()) {
                val node = currList.poll()
                node?.let {
                    it.left?.let { n ->
                        newList.offer(n)
                    }
                    it.right?.let { n ->
                        newList.offer(n)
                    }
                    level.add(it.`val`)
                }
            }
            result.add(level)
            currList = newList
        }
        return result
    }
}

fun isPossibleToRearrange(s: String, t: String, k: Int): Boolean {
    val map = hashMapOf<String, Int>()

    val len = s.length / k
    for (i in 0..<k) {
        val start = i * len
        val end = start + len
        val key = s.substring(start, end)
        map.put(key, (map[key] ?: 0) + 1)
    }

    for (i in 0..<k) {
        val start = i * len
        val end = start + len

        val key = s.substring(start, end)

        val value = map[key]
        if (value == null) {
            return false
        } else if (value == 1) {
            map.remove(key)
        } else {
            map.put(key, value - 1)
        }
    }
    return map.isEmpty()
}

fun main() {

//    val ans = isPossibleToRearrange("aabbcc", "bbaacc", 2)
//    println("ans = $ans")

    val l1 = TreeNode(9)

    val r11 = TreeNode(15)
    val r12 = TreeNode(7)
    val r1 = TreeNode(20)

    r1.left = r11
    r1.right = r12

    val root = TreeNode(3)
    root.left = l1
    root.right = r1

    val result = LevelOrderTraversal().levelOrder(root)

    for (l in result) {
        println()
        for (i in l) {
            print("$i ")
        }
        println()
    }

}