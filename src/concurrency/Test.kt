package concurrency

import java.util.*
import java.util.concurrent.ConcurrentHashMap


object NoVisibility {
    private var ready = false
    private var number = 0

    @JvmStatic
    fun main(args: Array<String>) {
        ReaderThread().start()
        number = 42
        ready = true
    }

    private class ReaderThread : Thread() {
        override fun run() {
            while (!ready) yield()
            println(number)
        }
    }
}

class SynchronizedInteger {
    private var value = 0

    @Synchronized
    fun get(): Int {
        return value
    }

    @Synchronized
    fun set(value: Int) {
        this.value = value
    }
}

fun main() {
    val s1 = SynchronizedInteger()

    while (true) {
        running(s1)
        Thread.sleep(3000)
    }
}

fun running(s1: SynchronizedInteger) {

    for (i in 0 until 10) {
        Thread { s1.set(s1.get() + 1) }.start()
        Thread { print(s1.get().toString() + " ") }.start()
        Thread { print(s1.get().toString() + " ") }.start()
        Thread { print(s1.get().toString() + " ") }.start()
        Thread { print(s1.get().toString() + " ") }.start()
        Thread { s1.set(s1.get() + 1) }.start()
        Thread { print(s1.get().toString() + " ") }.start()
        Thread { print(s1.get().toString() + " ") }.start()
    }
}

object ThreadLocalExample {
    // ThreadLocal variable
    private val threadLocal: ThreadLocal<Int> = ThreadLocal.withInitial { 1 }

    @JvmStatic
    fun main(args: Array<String>) {
        val task = Runnable {
            println(Thread.currentThread().name + " initial: " + threadLocal.get())
            threadLocal.set(threadLocal.get() + 1)
            println(Thread.currentThread().name + " updated: " + threadLocal.get())
        }

        val thread1 = Thread(task)
        val thread2 = Thread(task)

        thread1.start()
        thread2.start()
    }
}

class SafeColl {
    private val map = ConcurrentHashMap(HashMap<Int, Int>())

    fun add(i: Int, n: Int) {
        map.merge(i, n){ v, nev ->  v + nev }
    }

    fun get(i: Int): Int? {
        return map[i]
    }

}

class UnsafeColl {
    private val map = HashMap<Int, Int>()

    fun add(i: Int, n: Int) {
        map[i] = (map[i] ?: 0) + n
    }

    fun get(i: Int): Int? {
        return map[i]
    }

}


object UnsafeCollection {

    @JvmStatic
    fun main(args: Array<String>) {
        val us = SafeColl()
        while (true) {

            val t1 = Thread {
                for (i in 0 until 1000) {
                    us.add(1, 1)
                }
            }
            val t2 = Thread {
                for (i in 0 until 1000) {
                    us.add(10, 1)
                }
            }


            t1.start()
            t2.start()

            t1.join()
            t2.join()

            println("***")
            Thread.sleep(2000)
            println(us.get(10))
        }
        Thread.sleep(2000)
    }
}

