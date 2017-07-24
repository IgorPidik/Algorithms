/**
 * Created by igor on 25.7.2017.
 */

class BucketSort(val array: Array<Double>) {

    fun sort(): Array<Double> {
        var output = emptyArray<Double>()
        val n = array.size
        val buckets = Array<MutableList<Double>?>(n, { null })

        for (i in array) {
            val index = (i * n).toInt()
            println("index: {$index}")
            var bucket = buckets[index]
            if (bucket == null) {
                bucket = emptyList<Double>().toMutableList()
            }
            bucket.add(i)
            buckets[index] = bucket
        }

        for (bucket in buckets) {
            if (bucket != null) {
                output += sortBucket(bucket)
            }
        }

        return output
    }

    private fun sortBucket(bucket: MutableList<Double>): Array<Double> {
        val input = bucket.toTypedArray()
        //TODO: change classes so that they don't have to instantiated everytime we need to sort array
        InsertSort<Double>(input, { a, b -> a < b }).sort()
        return input
    }
}