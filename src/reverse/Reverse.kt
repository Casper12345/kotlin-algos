package reverse

object Reverse {

    fun reverse(a: Array<Int>): Array<Int> { // time: O(n) space: O(1)
        var l = 0
        var r = a.size -1

        while(l != r) {
            swap(a, l, r)
            l++
            r--
        }
      return a
    }

    fun swap(arr: Array<Int>, a: Int, b: Int) {
       val temp = arr[a]
       arr[a] = arr[b]
       arr[b] = temp
    }

}

fun main() {
    Reverse.reverse(arrayOf(8,7,6,5,4,3,2,1,0)).forEach { i -> println(i) }
}
