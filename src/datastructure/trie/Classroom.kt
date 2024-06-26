package datastructure.trie

class Classroom {

    private var root = Node()

    class Node {
        val children: Array<Node?> = Array(26) { null } // considering only 12 lowercase alphabets
        var endOfWord: Boolean = false // End of word
    }

    fun insert(word: String) {
        var curr = this.root
        for (i in word.indices) {
            val index = word[i] - 'a'
            if (curr.children[index] == null) {
                curr.children[index] = Node()
            }

            if (i == word.length - 1) {
                curr.children[index]!!.endOfWord = true
            }
            curr = curr.children[index]!!
        }
    }

    fun search(word: String): Boolean {
        var root = this.root
        word.forEachIndexed { index, c ->
            val idx = c - 'a'
            if (root.children[idx] != null) {
                if (root.children[idx]!!.endOfWord && index == word.length - 1) {
                    return true
                } else {
                    root = root.children[idx]!!
                }
            }
        }
        return false
    }
    /*
    * Given an input string and a dictionary of words, find out if the input string can be broken into space-sperated
    * sequence of dictionary words?
    *
    * ex words = [i, like, samsung, mobile, ice]
    * key = "ilikesamsung" output = true
    * */
    fun wordBreakProblem(key: String): Boolean {
        if (key.isEmpty()) return true

        for (i in 1..key.length) {
            val firstPart = key.substring(0, i)
            val secondPart = key.substring(i)
            if (search(firstPart) && wordBreakProblem(secondPart)) {
                return true
            }
        }
        return false
    }

    /*
    * Given a string prefix, we have to find if there is any previously added string which starts with the
    * given word prefix.
    * */
    fun startsWith(prefix: String): Boolean {
        var curr = root
        for (i in prefix.indices) {
            val index = prefix[i] - 'a'
            if (curr.children[index] != null) {
                curr = curr.children[index]!!
                if (i == prefix.length - 1) {
                    return true
                }
            }
        }

        return false
    }

    /*
    * Given a string of length n of lowercase alphabets characters we need to count the total
    * number of distinct substrings of the strings.
    *
    * ababa -> 10 [a., ab, aba, abab, ababa, b, ba, bab, baba, ""]
    * */
    fun findUniqueSubstrings(str: String): Int {
        for (i in str.indices){
            insert(str.substring(i)) // Step 1: Find suffix and create trie of it
        }
        return countNode(root) // This will count the number of node + 1[empty string]
    }

    private fun countNode(node: Node?): Int{
        if (node == null) {
            return 0
        }

        var count = 0

        for (i in 0 until 26){
            if (node.children[i] != null) {
                count += countNode(node.children[i])
            }
        }

        return count + 1
    }

    fun insertAll(words: Array<String>) {
        for (word in words) {
            insert(word)
        }
    }
}

fun main() {
//    val words = arrayOf("i", "like", "samsung", "mobile", "ice")
    val trie = Classroom()
//    trie.insertAll(words)
//    println(trie.search("their"))
//    println(trie.workBreakProblem("iice"))
//    println(trie.startsWith("mobile"))
    println(trie.findUniqueSubstrings("apple"))
}