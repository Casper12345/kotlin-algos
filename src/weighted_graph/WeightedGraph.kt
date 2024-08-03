package weighted_graph

import java.util.*
import kotlin.math.sqrt

class WeightedGraph(val size: Int) {
    // adjacency matrix

    private val edges: Array<Array<Int>> = Array(size){ Array(size){0} }

    fun addEdge(e: Int, v: Int, w: Int) {
        edges[e][v] = w
        edges[v][e] = w
    }

    fun getWeight(e: Int, v:Int): Int {
        return edges[e][v]
    }



    fun print(path: List<Int>) {
        val sb = StringBuilder()
        sb.append("   ")
        for (i in 0 until size) {
            sb.append("{$i}")
        }
        sb.append("\n")
        for (i in 0 until size) {
            sb.append("{$i}")
            for (j in 0 until size) {
                sb.append("[${getWeight(i, j)}]")
            }
            sb.append("\n")
        }
        println(sb.toString())
    }

    fun dijkstra(src: Int): IntArray {
        val dist = IntArray(size) { Int.MAX_VALUE }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        dist[src] = 0
        pq.add(Pair(src, 0))

        while (pq.isNotEmpty()) {
            val (u, _) = pq.poll()

            for (v in 0 until size) {
                if (getWeight(u, v) != 0) {
                    val newDist = dist[u] + getWeight(u, v)
                    if (newDist < dist[v]) {
                        dist[v] = newDist
                        pq.add(Pair(v, newDist))
                    }
                }
            }
        }
        return dist
    }



}

fun main() {
    val g = WeightedGraph(5)
    g.addEdge(0, 1, 2)
    g.addEdge(0, 2, 5)
    g.addEdge(0, 3, 3)
    g.addEdge(1, 2, 1)
    g.addEdge(2, 3, 1)
    g.addEdge(1, 4, 1)
    g.addEdge(2, 4, 1)
    g.addEdge(3, 4, 1)
    g.print(ArrayList())
    println(g.dijkstra(0).joinToString(", "))

}
