package datastructure.hashtables

import java.util.*


class CustomHashtable<K, V> {
    private val initialCapacity = 16
    private val loadFactor = 0.75f
    private var table: Array<MutableList<Entry<K, V>>> = Array(initialCapacity) { mutableListOf() }
    private var size = 0

    private data class Entry<K, V>(val key: K, var value: V)

    private fun hash(key: K): Int {
        return key.hashCode() % table.size
    }

    @Synchronized
    fun put(key: K, value: V) {
        require(key != null && value != null) { "Key or Value cannot be null" }

        val index = hash(key)
        val entries = table[index]

        // Check if key already exists; if so, replace the value
        for (entry in entries) {
            if (entry.key == key) {
                entry.value = value
                return
            }
        }

        // Add new entry
        entries.add(Entry(key, value))
        size++

        // Check for resizing
        if (size.toFloat() / table.size > loadFactor) {
            resize()
        }
    }

    @Synchronized
    fun get(key: K): V? {
        val index = hash(key)
        val entries = table[index]

        for (entry in entries) {
            if (entry.key == key) {
                return entry.value
            }
        }

        return null
    }

    private fun resize() {
        val oldTable = table
        table = Array(oldTable.size * 2) { mutableListOf() }
        size = 0

        for (bucket in oldTable) {
            for (entry in bucket) {
                put(entry.key, entry.value)
            }
        }
    }

    @Synchronized
    fun size(): Int {
        return size
    }
}

