package min_max

object MinMax {

    fun minMax(a: Array<Int>): List<Int> { // time: O(n) space: O(1)
        val arr = ArrayList<Int>()
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE

        for (i in 0 until a.size) {
            if(a[i] < min) {
                min = a[i]
            }
            if(a[i] > max) {
                max = a[i]
            }
        }
        arr.add(min)
        arr.add(max)
        return arr
    }
}

fun main() {
    println(MinMax.minMax(arrayOf(1,2,4,90,0,-100,0,40)))
}
