package permutations

class Permutations {

    val sb = ArrayList<String>()

    fun permutate(st: String, p: Int = 0) { // time: O(n * n) space: O(1)
        if(p == st.length) {
            sb.add(st)
        }
        for(i in p until st.length) {
            val s = swap(st, i, p)
            permutate(s, p + 1)
        }
    }

    fun swap(s: String, a: Int, b: Int): String {
        val arr = s.toCharArray()
        val temp = arr[b]
        arr[b] = arr[a]
        arr[a] = temp
        return String(arr)
    }
}

fun main() {
    val p = Permutations()
    p.permutate("abcd")
    println(p.sb)

}
