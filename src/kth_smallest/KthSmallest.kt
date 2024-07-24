package kth_smallest

class KthSmallest {

    fun smallest(k: Int, a: Array<Int>): Int {
        a.sort()
        return a[k]
    }

}
