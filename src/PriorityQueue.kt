/**
 * Created by igor on 11.7.2017.
 */

class PriorityQueue<T>(val isLess: (T?, T?) -> Boolean) {
    private var N: Int = 0
    private val list: MutableList<T?> = listOf<T?>(null).toMutableList()

    fun isEmpty(): Boolean {
        return N == 0
    }

    fun insert(item: T) {
        list.add(item)
        N++
        swim(N)
    }

    fun getTopItem(): T? {
        if (isEmpty()) return null

        val maxItem = list[1]
        swap(1, N--)
        sink(1)
        list.removeAt(N + 1)
        return maxItem
    }

    private fun swim(k: Int) {
        var itemID = k
        while (itemID > 1 && isLess(list[itemID / 2], list[itemID])) {
            swap(itemID / 2, itemID)
            itemID /= 2
        }
    }

    private fun swap(i: Int, j: Int) {
        val item = list[i]
        list[i] = list[j]
        list[j] = item
    }

    private fun sink(k: Int) {
        var itemID = k
        while (2 * itemID <= N) {
            var j = itemID * 2
            if (j < N && isLess(list[j], list[j + 1])) j += 1
            if (!isLess(list[itemID], list[j])) break
            swap(itemID, j)
            itemID = j
        }
    }
}