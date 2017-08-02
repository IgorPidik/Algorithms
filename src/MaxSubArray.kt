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
        var sum = 0
        var leftIndex = midIndex
        var rightIndex = midIndex

        var maxLeftSum = Int.MIN_VALUE
        var leftMostIndex = midIndex
        while (leftIndex >= startIndex) {
            sum += array[leftIndex]
            if (sum > maxLeftSum) {
                maxLeftSum = sum
                leftMostIndex = leftIndex
            }
            leftIndex--
        }

        sum = 0
        var maxRightSum = Int.MIN_VALUE
        var rightMostIndex = midIndex
        while (rightIndex < endIndex) {
            rightIndex++
            sum += array[rightIndex]
            if (sum > maxRightSum) {
                maxRightSum = sum
                rightMostIndex = rightIndex
            }
        }

        return Triple(leftMostIndex, rightMostIndex, maxLeftSum + maxRightSum)
    }
}