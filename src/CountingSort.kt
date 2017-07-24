/**
 * Created by igor on 24.7.2017.
 */

class CountingSort(val array: Array<Int>) {

    fun sort(): Array<Int> {
        if (array.isEmpty())
            return emptyArray()

        val output = Array(array.size, { 0 })
        val countHolder = Array(getMaxElement() + 1, { 0 })

        for (i in array) {
            countHolder[i] += 1
        }

        for (j in 1..countHolder.size - 1) {
            countHolder[j] = countHolder[j] + countHolder[j - 1]
        }

        for (k in array.size - 1 downTo 0) {
            output[countHolder[array[k]] - 1] = array[k]
            countHolder[array[k]] -= 1
        }
        return output
    }

    private fun getMaxElement(): Int {
        return array.max()!!
    }
}
