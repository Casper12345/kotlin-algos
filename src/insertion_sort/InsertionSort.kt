package insertion_sort

object InsertionSort {

    fun sort(arr: Array<Int>) {
        val n = arr.size
        for (i in 1 until n) {
            val key = arr[i]
            var j = i - 1


            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]
                j = j - 1
            }
            arr[j + 1] = key
        }
    }


}

fun main() {
    val a = arrayOf(2,1,3,8,9,0,2,3,9,6,7,10,1)
    InsertionSort.sort(a)
    a.forEach { i -> println(i) }
}
