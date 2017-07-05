/**
 * Created by igor on 5.7.2017.
 */

fun mergeSort(array: Array<Int>): Array<Int> {
    return mergeSort(array, 0, array.size-1)
}

private fun mergeSort(array: Array<Int>, startPoint: Int, endPoint: Int): Array<Int> {
    var arr = array
    if(startPoint < endPoint) {
        val midPoint = ((startPoint+endPoint)/2)
        arr = mergeSort(arr,startPoint, midPoint)
        arr = mergeSort(arr, midPoint+1, endPoint)
        return merge(arr,startPoint, midPoint, endPoint)
    }
    return arr
}


private fun merge(array: Array<Int>, startPoint: Int, midPoint: Int, endPoint: Int): Array<Int> {
    val subArray1 = array.sliceArray(startPoint..midPoint)
    val subArray2 = array.sliceArray(midPoint+1..endPoint)


    var firstArrayIndex = 0
    var secondArrayIndex = 0

    for(i in startPoint..endPoint) {
        if (firstArrayIndex > subArray1.size-1) {
            for(j in secondArrayIndex..subArray2.size-1) {
                val posOffset = j-secondArrayIndex
                array[i+posOffset] = subArray2[j]
            }
            return array
        }
        else if (secondArrayIndex > subArray2.size-1) {
            for(j in firstArrayIndex..subArray1.size-1) {
                val posOffset = j-firstArrayIndex
                array[i+posOffset] = subArray1[j]
            }
            return array
        }
        else {
            if(subArray1[firstArrayIndex] < subArray2[secondArrayIndex]) {
                array[i] = subArray1[firstArrayIndex]
                firstArrayIndex += 1
            } else {
                array[i] = subArray2[secondArrayIndex]
                secondArrayIndex += 1
            }
        }
    }

    return array
}
