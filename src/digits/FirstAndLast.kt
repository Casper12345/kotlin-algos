package digits

object FirstAndLast {

    fun first(i: Int): Int {
        var n = i
        while(n > 9){
            n /= 10;
        }
        return n
    }

    fun last(i: Int): Int {
        return i % 10
    }

    fun reverse(i: Int): Int {
        var num = i
        var rev_num = 0
        while (num > 0) {
            rev_num = rev_num * 10 + num % 10
            num /= 10
        }
        return rev_num
    }

}

fun main() {
    println(FirstAndLast.first(9999999))
    println(FirstAndLast.reverse(1234542))
}
