package quick_sort

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
        if(lo < hi){
            val p = partition(arr, lo, hi)
            sort(arr, lo, p - 1)
            return sort(arr, p + 1, hi)
        } else {
            return arr
        }
    }

    private fun swap(arr: Array<Int>, a: Int, b: Int) {
        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }


}

fun main() {
    val q = QuickSort()
    val a = arrayOf(2,1,3,8,9,0,2,3,9,6,7,10,1) // [0]
    q.sort(a, 0, a.size -1)
    a.forEach { i -> println(i) }
}
