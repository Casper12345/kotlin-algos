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

object OccurrencePar {
    object RunOccurrencePar {
        fun runOccurrencePar(k: Int, a: Array<Int>, l: Int, r: Int): Int {
            var count = 0
            for (i in l until r) {
                if (a[i] == k) {
                    count++
                }
            }
            return count
        }
    }

    fun run(k: Int, a: Array<Int>, par: Int): Int {
        val  c = Array(par){0}

        val threads = ArrayList<Thread>()

        for(i in 0 until par) {
            if(i == 0){
                val t = thread { c[i] = RunOccurrencePar.runOccurrencePar(k, a, 0, (a.size)/par ) }
                threads.add(t)
            } else if (i == par - 1){
                val t = thread { c[i] = RunOccurrencePar.runOccurrencePar(k, a, (a.size/par) * i, a.size) }
                threads.add(t)
            } else {
                val t = thread { c[i] = RunOccurrencePar.runOccurrencePar(k, a, (a.size/par) * i, (a.size/par) * (i + 1)) }
                threads.add(t)
            }
        }
        threads.forEach{t -> t.join()}
        return c.sum()
    }

}


fun main() {
    val seq = generateSequence { Random.nextInt(100)}.take(1000000000).toList().toIntArray().toTypedArray()
    val t1 = Instant.now().toEpochMilli()
    val rs = Occurrence.occurrence(3, seq)
    val t2 = Instant.now().toEpochMilli()

    println(t2 - t1)
    println(rs)

    val t3 = Instant.now().toEpochMilli()
    val rs1 = OccurrencePar.run(3, seq, 6)
    val t4 = Instant.now().toEpochMilli()
    println(t4 - t3)
    println(rs1)

}
