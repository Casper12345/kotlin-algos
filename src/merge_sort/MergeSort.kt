package merge_sort

import binary_heap.HeapSort
import quick_sort.OptimizedQuickSort
import java.time.Instant
import kotlin.random.Random

class MergeSort {

    fun sort(a: Array<Int>): Array<Int> { // time: O(n logn) space: O(n)
        if(a.size > 1){
            val (l,r) = split(a, a.size / 2)
            return merge(sort(l), sort(r))
        }
        return a
    }

    private fun merge(a: Array<Int>, b: Array<Int>): Array<Int> {
        val arr = Array(a.size + b.size){0}
        var i = 0
        var p1 = 0
        var p2 = 0
        while(i < arr.size) {
            if(p1 < a.size && p2 < b.size) {
                if (a[p1] < b[p2]) {
                    arr[i] = a[p1]
                    p1++
                } else if (a[p1] > b[p2]) {
                    arr[i] = b[p2]
                    p2++
                } else {
                    arr[i] = a[p1]
                    i++
                    arr[i] = b[p2]
                    p1++
                    p2++
                }
            } else {
                if(p1 < a.size) {
                    arr[i] = a[p1]
                    p1++
                } else {
                    arr[i] = b[p2]
                    p2++
                }
            }
            i++
        }
      return arr
    }

    private fun split(a: Array<Int>, p: Int): Pair<Array<Int>, Array<Int>> {

        if(p > a.size) {
            throw IndexOutOfBoundsException("partition larger than array size")
        }
        val a1 = Array((p)) {0}
        val a2 = Array((a.size - p)) {0}

        for(i in 0 until a1.size) {
            a1[i] = a[i]
        }
        for(i in p until a.size) {
            a2[i - p] = a[i]
        }
        return Pair(a1, a2)
    }


}

fun main() {
    val m = MergeSort()
    val q = OptimizedQuickSort()
    val seq = generateSequence { Random.nextInt(1000000)}.take(10000000).toList().toIntArray().toTypedArray()
    val seq2 = seq.clone()
    val seq3 = seq.clone()
    val seq4 = seq.clone()


    val t1 = Instant.now().toEpochMilli()
    val rs = m.sort(seq)
    val t2 = Instant.now().toEpochMilli()
    println(t2 - t1)
//    rs.forEach { i -> println(i) }

    val t3 = Instant.now().toEpochMilli()
    val rs2 = q.sort(seq2)
    val t4 = Instant.now().toEpochMilli()
    println(t4 - t3)

    val t5 = Instant.now().toEpochMilli()
    val rs3 = seq3.sort()
    val t6 = Instant.now().toEpochMilli()
    println(t6 - t5)

    val t7 = Instant.now().toEpochMilli()
    val rs4 = seq3.sort()
    val t8 = Instant.now().toEpochMilli()
    println(t8 - t7)

    val t9 = Instant.now().toEpochMilli()
    val rs5 = q.sort(seq3)
    val t10 = Instant.now().toEpochMilli()
    println(t10 - t9)

    val t11 = Instant.now().toEpochMilli()
    val rs6 = HeapSort.sort(seq4)
    val t12 = Instant.now().toEpochMilli()
    println(t12 - t11)

    println(seq2.contentEquals(seq3))
    println(seq4.contentEquals(seq3))
}
