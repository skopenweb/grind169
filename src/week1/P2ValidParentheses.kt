package week1

import java.util.*

class P2ValidParentheses {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        val chars = listOf('(', '{', '[')
        val map = mapOf(
            '(' to ')',
            '{' to '}',
            '[' to ']',
        )

        for (c in s) {
            if (chars.contains(c)) {
                stack.push(c)
            } else if (stack.isNotEmpty() && map[stack.peek()] == c) {
                stack.pop()
            } else {
                return false
            }
        }

        return stack.isEmpty()
    }
}