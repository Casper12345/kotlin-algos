package peak_element

object PeakElement {

    fun peak(a: Array<Int>): List<Int> {
        val arr = ArrayList<Int>()
        for(i in 1 until a.size -1) {
            if(a[i -1] < a[i] && a[i +1] < a[i]) {
              arr.add(a[i])
            }
        }
        return arr
    }



}

fun main() {
    println(PeakElement.peak(arrayOf(5, 10, 20, 15, 1, 3, 1,0)))
}
