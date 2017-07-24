/**
 * Created by igor on 24.7.2017.
 */

class RadixSort(val array: Array<Int>) {

    private val countingSort = CustomCountingSort()

    fun sort(): Array<Int> {
        if (array.isEmpty()) {
            return emptyArray()
        }

        var output = array.clone()
        val maxLen = getMaxNumberLength(array.max()!!)
        for (i in 1..maxLen) {
            output = countingSort.sort(output, i)
        }
        return output
    }

    fun getMaxNumberLength(num: Int): Int {
        var count = 0
        var n = num
        while (n != 0) {
            n /= 10
            count += 1
        }
        return count
    }

    private class CustomCountingSort {

        fun sort(array: Array<Int>, byDigitAt: Int): Array<Int> {
            val output = Array(array.size, { 0 })
            val countHolder = Array(getMaxElementDigitAt(array, byDigitAt) + 1, { 0 })

            for (i in array) {
                val digit = getDigitAt(i, byDigitAt)
                countHolder[digit] += 1
            }

            for (j in 1..countHolder.size - 1) {
                countHolder[j] += countHolder[j - 1]
            }

            for (k in array.size - 1 downTo 0) {
                val digit = getDigitAt(array[k], byDigitAt)
                output[countHolder[digit] - 1] = array[k]
                countHolder[digit] -= 1
            }

            return output
        }

        private fun getMaxElementDigitAt(array: Array<Int>, byDigitAt: Int): Int {
            return getDigitAt(array.maxBy { getDigitAt(it, byDigitAt) }!!, byDigitAt)
        }

        private fun getDigitAt(num: Int, at: Int): Int {
            //to get only digit at position byDigitAt compute (number%(10^byDigit))/(10^byDigitAt-1)
            return (num % (Math.pow(10.toDouble(), at.toDouble())) / Math.pow(10.toDouble(), (at - 1).toDouble())).toInt()
        }
    }
}