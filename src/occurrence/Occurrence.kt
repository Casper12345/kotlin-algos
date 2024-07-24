package occurrence

import java.time.Instant
import kotlin.concurrent.thread
import kotlin.random.Random

object Occurrence {

    fun occurrence(k: Int, a: Array<Int>): Int {
        var c = 0
        for(i in 0 until a.size) {
            if(a[i] == k) {
                c++
            }
        }
        return c
    }

}

object OccurrenceTernary {
    object RunOccurrenceTernary {
        fun runOccurrenceTernary(k: Int, a: Array<Int>, l: Int, r: Int): Int {
            var count = 0
            for (i in l until r) {
                if (a[i] == k) {
                    count++
                }
            }
            return count
        }
    }

    fun run(k: Int, a: Array<Int>): Int {
        // 0, (a.size)/3 = 3
        // (a.size)/3, (a.size)/3 + (a.size)/3 = 3 = 6
        // (a.size)/3 + (a.size)/3 + (a.size)/3
        // [1,2,3,4] [5,6,7] [8,9,10]
        var c1 = 0
        var c2 = 0
        var c3 = 0

        val m1 = (a.size)/3
        val m2 = (a.size)/3 + (a.size)/3

        val t1 = thread { c1 = RunOccurrenceTernary.runOccurrenceTernary(k, a, 0, m1) }
        val t2 = thread { c2 = RunOccurrenceTernary.runOccurrenceTernary(k, a, m1, m2) }
        val t3 = thread { c3 = RunOccurrenceTernary.runOccurrenceTernary(k, a, m2, a.size)}

        t1.join()
        t2.join()
        t3.join()
        return c1 +  c2  + c3 // [3,3,3,[1],2,3,[4],4,2,3,3]
    }

}


fun main() {
    val seq = generateSequence { Random.nextInt(100)}.take(100000000).toList().toIntArray().toTypedArray()
    val t1 = Instant.now().toEpochMilli()
    val rs = Occurrence.occurrence(3, seq)
    val t2 = Instant.now().toEpochMilli()

    println(t2 - t1)
    println(rs)

    val t3 = Instant.now().toEpochMilli()
    val rs1 = OccurrenceTernary.run(3, seq)
    val t4 = Instant.now().toEpochMilli()
    println(t4 - t3)
    println(rs1)

}
