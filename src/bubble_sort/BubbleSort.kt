package bubble_sort

object BubbleSort {

    fun sort(a: Array<Int>): Array<Int> {
        for (i in 0 until a.size) {
            for (j in i + 1 until a.size) { // time: O(n * n) space: O(1)
                if(a[i] > a[j]) {
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
    BubbleSort.sort(arrayOf(5, 3, 4, 1, 0, 12, 0, 33, 1)).forEach { i -> println(i) }

}
