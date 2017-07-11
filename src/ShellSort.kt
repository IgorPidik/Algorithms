/**
 * Created by igor on 10.7.2017.
 */

class ShellSort<T>(val array: Array<T>, val isLess: (T, T) -> Boolean) {

    fun sort() {
        val size = array.size
        var h = 1
        while (h < size / 3) h = h * 3 + 1

        while (h >= 1) {

            for (i in h..size - 1) {
                var j = i
                while (j >= h && isLess(array[j], array[j - h])) {
                    swap(array, j, j - h)
                    j -= h
                }
            }
            h /= 3
        }
    }

    private fun swap(array: Array<T>, i: Int, j: Int) {
        val item = array[i]
        array[i] = array[j]
        array[j] = item
    }
}