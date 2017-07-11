/**
 * Created by igor on 10.7.2017.
 */

class QuickSort<T>(val array: Array<T>, val isLess: (T, T) -> Boolean) {

    fun sort() {
        quickSort(0, array.size - 1)
    }

    private fun quickSort(lo: Int, hi: Int) {
        if (lo >= hi) return

        val j = partition(lo, hi)

        quickSort(lo, j - 1)
        quickSort(j + 1, hi)
    }

    private fun partition(lo: Int, hi: Int): Int {
        var i = lo
        var j = hi + 1

        while (true) {
            while (isLess(array[++i], array[lo])) {
                if (i == hi) break
            }

            while (isLess(array[lo], array[--j])) {
                if (j == lo) break
            }

            if (i >= j) break
            swap(i, j)
        }

        swap(lo, j)
        return j
    }

    private fun swap(i: Int, j: Int) {
        val item = array[i]
        array[i] = array[j]
        array[j] = item
    }
}