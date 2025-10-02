package week1

class P7ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        val freq = IntArray(26)
        if (s.length != t.length) return false
        for (c in s) {
            val index = c - 'a'
            freq[index]++
        }
        for (c in t) {
            val index = c - 'a'
            freq[index]--
        }
        return freq.all { it == 0 }
    }
}

fun main() {
    println("valid anagram")
}