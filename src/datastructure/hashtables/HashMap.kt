package datastructure.hashtables

import java.util.LinkedList
import kotlin.math.abs

data class Entry<K, V>(val key: K, val value: V?)

interface Map<K, V> {
    fun put(key: K, value: V?)
    fun get(key: K): V?
    fun contains(key: K): Boolean
    fun keySet(): Set<K>
    fun size(): Int
}

class HashMap<K, V> : Map<K, V> {

    // We are using linked list for chaining
    private var N = 10
    val buckets = Array(N) { LinkedList<Entry<K, V>>() }

    private fun hashFunction(key: K): Int {
        val hashcode = key.hashCode()
        return abs(hashcode) % N
    }
    override fun put(key: K, value: V?) {
        val k = hashFunction(key)

        for (i in 0..buckets.size){
            if (k == buckets[i].first.key){

            }
        }
    }

    override fun get(key: K): V? {
        TODO("Not yet implemented")
    }

    override fun contains(key: K): Boolean {
        TODO("Not yet implemented")
    }

    override fun keySet(): Set<K> {
        TODO("Not yet implemented")
    }

    override fun size(): Int {
        TODO("Not yet implemented")
    }


}