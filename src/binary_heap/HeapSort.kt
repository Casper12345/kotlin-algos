package binary_heap

object HeapSort {

    fun sort(a: Array<Int>) {
        val arr = move(a)
        heapify(arr)
        for(i in a.size -1 downTo 0){
            a[i] = arr[1]
            arr[1] = arr[i + 1]
            sink(arr, 1, i)
        }
    }

    fun heapify(a: Array<Int>) {
        for(k in (a.size -1) / 2 downTo 1) {
            sink(a, k,  a.size - 1)
        }
    }


    fun sink(a: Array<Int>, i: Int, size: Int) {
        var k = i
        while(2*k <= size) {
            var j = 2*k // 5
            if(j < size && a[j] < a[j+1]) {
                j++
            }
            if(a[k] >= a[j]) {
                break
            }
            swap(a, k, j)
            k = j
        }

    }

    fun swap(arr: Array<Int>, a: Int, b: Int) {
        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }

    fun move(a: Array<Int>): Array<Int> {
        val arr = Array(a.size + 1){0}
        for(i in 0 until a.size){
            arr[i + 1] = a[i]
        }
        return arr
    }


}

fun main() {
    val a = arrayOf(5,4,3,2,3,1)
    HeapSort.sort(a)
    a.forEach { i -> println(i) }
}
