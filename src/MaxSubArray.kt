/**
 * Created by igor on 28.7.2017.
 */

class MaxSubArray {

    private var array: Array<Int> = emptyArray()

    fun getMaxSubArray(array: Array<Int>): Triple<Int, Int, Int> {
        this.array = array
        return getMaxSubArray(0, array.size - 1)
    }

    //return max array => Triple of <startIndex, endIndex, sum>
    private fun getMaxSubArray(startIndex: Int, endIndex: Int): Triple<Int, Int, Int> {
        if (startIndex == endIndex) {
            return Triple(startIndex, endIndex, array[startIndex])
        }

        val midIndex = (startIndex + endIndex) / 2
        val (leftStart, leftEnd, leftSum) = getMaxSubArray(startIndex, midIndex)
        val (rightStart, rightEnd, rightSum) = getMaxSubArray(midIndex + 1, endIndex)
        val (crossStart, crossEnd, crossSum) = getMaxCrossSubArray(startIndex, midIndex, endIndex)

        if (leftSum > rightSum && leftSum > crossSum) return Triple(leftStart, leftEnd, leftSum)
        else if (rightSum > leftSum && rightSum > crossSum) return Triple(rightStart, rightEnd, rightSum)
        else return Triple(crossStart, crossEnd, crossSum)
    }

    private fun getMaxCrossSubArray(startIndex: Int, midIndex: Int, endIndex: Int): Triple<Int, Int, Int> {
        var sum = array[midIndex]
        var leftMostIndex = midIndex
        var rightMostIndex = midIndex

        while (leftMostIndex > startIndex && (sum + array[leftMostIndex - 1]) > sum) {
            leftMostIndex--
            sum += array[leftMostIndex]
        }

        while (rightMostIndex < endIndex && (sum + array[rightMostIndex + 1]) > sum) {
            rightMostIndex++
            sum += array[rightMostIndex]
        }

        return Triple(leftMostIndex, rightMostIndex, sum)
    }
}