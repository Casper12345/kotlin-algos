package zero_compression

object Compress {

    fun compress(a: Array<Int>, l: Int = 0) { // time: O(n) space: O(1)
            var i = l
            while(i < a.size && a[i] != 0) {
                i++
            }
            var p: Int = i
            while(p < a.size && a[p] == 0) {
                p++
            }
            if(i < a.size && p < a.size) {
                swap(a, i, p)
                compress(a, i)
            }
    }

    fun swap(arr: Array<Int>, a: Int, b: Int) {
        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }

}

fun main() {
    val a = arrayOf(3,0,1,1,0,1,1,0,1,2,3)
    Compress.compress(a)
    a.forEach {i -> println(i) }
}
