/**
 * Created by igor on 10.7.2017.
 */

class ThreeWayQuickSort<T>(val array: Array<T>, val compare: (T, T) -> Int) {

    fun sort() {
        threeWayQuickSort(0, array.size - 1)
    }

    private fun threeWayQuickSort(lo: Int, hi: Int) {
        if (lo >= hi) return

        var i = lo
        var lt = lo
        var gt = hi
        val v = array[lo]

        while (i <= gt) {
            val cmp = compare(array[i], v)
            if (cmp < 0) swap(lt++, i++)
            else if (cmp > 0) swap(i, gt--)
            else i++
        }

        threeWayQuickSort(lo, lt - 1)
        threeWayQuickSort(gt + 1, hi)
    }

    private fun swap(i: Int, j: Int) {
        val item = array[i]
        array[i] = array[j]
        array[j] = item
    }
}