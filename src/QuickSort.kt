/**
 * Created by igor on 10.7.2017.
 */


fun <T> quickSort(array: Array<T>, isLess: (T, T) -> Boolean) {
    quickSort(array, 0, array.size - 1, isLess)
}

private fun <T> quickSort(array: Array<T>, lo: Int, hi: Int, isLess: (T, T) -> Boolean) {
    if (lo >= hi) return
    val j = partition(array, lo, hi, isLess)
    quickSort(array, lo, j - 1, isLess)
    quickSort(array, j + 1, hi, isLess)
}

private fun <T> partition(array: Array<T>, lo: Int, hi: Int, isLess: (T, T) -> Boolean): Int {
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
        swap(array, i, j)
    }

    swap(array, lo, j)
    return j
}

private fun <T> swap(array: Array<T>, i: Int, j: Int) {
    val item = array[i]
    array[i] = array[j]
    array[j] = item
}
