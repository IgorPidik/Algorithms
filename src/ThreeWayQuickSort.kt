/**
 * Created by igor on 10.7.2017.
 */

fun <T> threeWayQuickSort(array: Array<T>, compare: (T, T) -> Int) {
    threeWayQuickSort(array, 0, array.size - 1, compare)
}

private fun <T> threeWayQuickSort(array: Array<T>, lo: Int, hi: Int, compare: (T, T) -> Int) {
    if (lo >= hi) return
    var i = lo
    var lt = lo
    var gt = hi
    val v = array[lo]

    while (i <= gt) {
        val cmp = compare(array[i], v)
        if (cmp < 0) swap(array, lt++, i++)
        else if (cmp > 0) swap(array, i, gt--)
        else i++
    }

    threeWayQuickSort(array, lo, lt - 1, compare)
    threeWayQuickSort(array, gt + 1, hi, compare)
}

private fun <T> swap(array: Array<T>, i: Int, j: Int) {
    val item = array[i]
    array[i] = array[j]
    array[j] = item
}
