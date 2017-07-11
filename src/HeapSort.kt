/**
 * Created by igor on 11.7.2017.
 */

class HeapSort<T>(items: MutableList<T>, val isLess: (T?, T?) -> Boolean) {

    private val list = items.toMutableList<T?>()
    private var N = list.size

    fun sort(): MutableList<T?> {
        list.add(0, null)
        convertToHeap()

        heapSort()
        return list
    }

    fun heapSort() {
        while (N > 1) {
            swap(1, N)
            N -= 1
            sink(1)
        }
    }

    private fun convertToHeap() {
        for (k in N / 2 downTo 1) {
            sink(k)
        }
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

    private fun swap(i: Int, j: Int) {
        val item = list[i]
        list[i] = list[j]
        list[j] = item
    }
}