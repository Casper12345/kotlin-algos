package selection_sort

object SelectionSort {

    fun sort(a: Array<Int>): Array<Int> {
        for (i in 0 until a.size) { // 2
            for (j in i + 1 until a.size) {
                if(a[i] > a[j]) { // [1,2,3,4,5j]
                    swap(a, i, j)
                }
            }
        }
        return a
    }

    private fun swap(arr: Array<Int>, a: Int, b: Int) {
        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }
}

fun main() {
    SelectionSort.sort(arrayOf(5, 3, 4, 1, 0, 12, 0, 33, 1, 3, 2, 1, 6, 1, 22, 1)).forEach { i -> println(i) }

}
