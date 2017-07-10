/**
 * Created by igor on 10.7.2017.
 */

fun <T> shellSort(array: Array<T>, isLess: (T, T) -> Boolean) {
    val size = array.size
    var h = 1
    while (h < size / 3) h = h * 3 + 1

    while (h >= 1) {

        for (i in h..size-1) {
            var j = i
            while (j >= h && isLess(array[j], array[j-h])) {
                swap(array, j, j-h)
                j -= h
            }
        }
        h /= 3
    }
}

private fun <T> swap(array: Array<T>, i: Int, j: Int) {
    val item = array[i]
    array[i] = array[j]
    array[j] = item
}