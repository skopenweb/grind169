package week2

class P3ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val resultSet = mutableSetOf<List<Int>>()
        var prev = nums[0] - 1

        for (i in nums.indices) {
            if (nums[i] != prev) {
                findAndUpdate(nums, i, resultSet)

                prev = nums[i]
            }
        }
        return resultSet.toList()
    }

    private fun findAndUpdate(
        a: IntArray,
        t: Int,
        resultSet: MutableSet<List<Int>>
    ) {
        var l = 0
        var r = a.size - 1
        while (l < r) {
            if (l == t) {
                l++
                continue
            } else if (r == t) {
                r--
                continue
            }
            if (a[l] + a[r] < -a[t]) {
                l++
            } else if (a[l] + a[r] > -a[t]) {
                r--
            } else {
                val min = a[l].coerceAtMost(a[r]).coerceAtMost(a[t])
                val max = a[l].coerceAtLeast(a[r]).coerceAtLeast(a[t])
                val other = a[l] + a[r] + a[t] - min - max
                resultSet.add(listOf(min, other, max))
                l++
                r--
            }
        }
    }
}

fun main() {
    val result = P3ThreeSum().threeSum(intArrayOf(-1, 0, 1, 0))

    val input = "abcdef"

    val map = hashMapOf<String, Int>()
    map.remove(input)
    for (r in result) {
        print("")
        for (i in r) {
            print("$i ")
        }
        println("")
    }
}