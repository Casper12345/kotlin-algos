package quick_sort

import kotlin.random.Random

class QuickSort {

    fun partition(a: Array<Int>, lo: Int, hi: Int): Int {
        val pivot = a[hi]
        var j = lo -1

        for(i in lo until hi) {
            if(a[i] < pivot) {
                j++
                if(i != j){
                    swap(a, j, i)
                }
            }
        }
        j++
        swap(a, j, hi)
        return j
    }

    fun sort(arr: Array<Int>, lo: Int = 0, hi: Int = arr.size -1): Array<Int> {
        var l = lo
        var h = hi
        while(l < h){
            val p = partition(arr, l, h)
            if (p - l < h - p){
                sort(arr, l, p - 1)
                l = p + 1
            } else {
                sort(arr, p + 1, h)
                h = p - 1
            }
        }
        return arr
    }

    private fun swap(arr: Array<Int>, a: Int, b: Int) {
        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }


}

class OptimizedQuickSort {

    fun sort(arr: Array<Int>) {
        arr.shuffle()
        sort(arr, 0, arr.size -1)
    }

    fun sort(arr: Array<Int>, lo: Int, hi: Int) {
        if (lo < hi) {
            val (l, r) = threeWayPartition(arr, lo, hi)

            sort(arr, lo, l - 1)
            sort(arr, r, hi)
        }
    }

    fun threeWayPartition(arr: Array<Int>, lo: Int, hi: Int): Pair<Int, Int> {
        var lt = lo
        var i = lo
        var gt = hi
        val p = arr[hi]
        while (i <= gt) {
            when {
                arr[i] < p -> {
                    if(lt != i) {
                        arr.swap(lt, i)
                    }
                    lt++
                    i++
                }
                arr[i] > p -> {
                    if(gt != i) {
                        arr.swap(i, gt) // [1,2,2,5,5]
                    }
                    gt--
                }
                else -> i++
            }
        }
        return Pair(lt, gt + 1)
    }

    fun Array<Int>.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }

}

fun main() {
//    val q = QuickSort()
//    val a = arrayOf(2,1,3,8,9,0,2,3,9,6,7,10,1) // [0]
//    q.sort(a, 0, a.size -1)
//    a.forEach { i -> println(i) }

    val op = OptimizedQuickSort()
    val ar = arrayOf(1,2,3,8,6,5) // [0]
    op.sort(ar, 0, ar.size -1)
    ar.forEach { i -> println(i) }
}
