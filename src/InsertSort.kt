/**
 * Created by igor on 5.7.2017.
 */

fun insertSort(array: Array<Int>) : Array<Int> {
    for(i in 1..array.size-1) {
        val key = array[i]
        var j = i-1
        while(j>= 0 && array[j] > key) {
            array[j+1] = array[j]
            j -= 1
        }
        array[j+1] = key
    }
    return array
}