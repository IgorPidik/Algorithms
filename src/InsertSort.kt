/**
 * Created by igor on 5.7.2017.
 */

class InsertSort<T>(val array: Array<T>, val isLess: (T, T) -> Boolean) {

    fun sort() {
        for (i in 1..array.size - 1) {
            val key = array[i]
            var j = i - 1
            while (j >= 0 && !isLess(array[j], key)) {
                array[j + 1] = array[j]
                j -= 1
            }
            array[j + 1] = key
        }
    }
}