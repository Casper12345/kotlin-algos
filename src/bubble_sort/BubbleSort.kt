package bubble_sort

object BubbleSort {

    fun sort(a: Array<Int>) {
            var n = 0
            var swapped = false
            while(n < a.size) {
                for(i in 1 until a.size) {
                    if (a[i - 1] > a[i]) {
                        swap(a, i - 1, i)
                        swapped = true
                    }
                }
                if (!swapped) {
                    break
                }

                n++
            }

    }

    fun swap(arr: Array<Int>, a: Int, b: Int) {
        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp

    }

}

fun main() {
    val a = arrayOf(2,1,3,8,9,0,2,3,9,6,7,10,1)
    BubbleSort.sort(a)
    a.forEach { i -> println(i) }
}
