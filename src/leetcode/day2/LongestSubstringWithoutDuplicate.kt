package leetcode.day2

class LongestSubstringWithoutDuplicate {
    fun lengthOfLongestSubstring(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        var start = 0
        var max = 0
        for (i in s.indices) {
            if (map.containsKey(s[i])) {
                start = maxOf(map[s[i]]!!, start)
            }
            max = maxOf(max, i - start + 1)
            map[s[i]] = i + 1
        }
        return max
    }
}

fun main() {
    val longestSubstringWithoutDuplicate = LongestSubstringWithoutDuplicate()
    longestSubstringWithoutDuplicate.lengthOfLongestSubstring("abcabcbb").also { println(it) }
}