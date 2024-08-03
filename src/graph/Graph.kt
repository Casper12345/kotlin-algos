package graph

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.*

class Graph(val size: Int) {
    // adjacency list
    private val edges = Array<LinkedList<Int>>(size){ LinkedList() }

    fun addEdge(v: Int, w: Int) {
        edges[v].add(w)
        edges[w].add(v)
    }

    fun adj(i: Int): List<Int> {
        return edges[i]
    }

    fun print(path: List<Int>) {
        val sb = StringBuilder()
        var n = 1
        for(i in 0 until size) {
            if(edges[i].isEmpty()) {
                sb.append("#")
            } else {
                if(path.contains(i)) {
                    sb.append("@")
                } else {
                    sb.append("*")
                }

            }
            if(i == (sqrt(size.toFloat()).toInt() * n) - 1) {
                sb.append("\n")
                n++
            }
        }
        println(sb.toString())
    }

    fun dfs(s: Int, e: Int): List<Int> {
        val toReturn = ArrayList<Int>()
        val visited = Array(size){ false }
        val edgeTo = Array(size){0}
        traverseDFS(s , visited, edgeTo)

        var n = e
        while(n != s) {
            toReturn.addFirst(edgeTo[n])
            n = edgeTo[n]
        }
        toReturn.add(e)
        return toReturn

    }

    fun bfs(s: Int, e: Int): List<Int> {
        val toReturn = ArrayList<Int>()
        val visited = Array(size){ false }
        val edgeTo = Array(size){0}
        val q: Queue<Int> = LinkedList()

        q.add(s)
        visited[s] = true
        while(q.isNotEmpty()) {
            val v = q.poll()
            for (i in adj(v)) {
                if (!visited[i]) {
                    q.add(i)
                    visited[i] = true
                    edgeTo[i] = v
                }
            }
        }

        var n = e
        while(n != s) {
            toReturn.addFirst(edgeTo[n])
            n = edgeTo[n]
        }

        toReturn.add(e)
        return toReturn

    }

    private fun traverseDFS(s: Int, visited: Array<Boolean>, edgeTo: Array<Int>) {
        visited[s] = true
        for (i in adj(s)) {
            if (!visited[i]) {
                edgeTo[i] = s
                traverseDFS(i, visited, edgeTo)
            }
        }
    }

}

fun main() {
    val gr = Graph(100)
    gr.addEdge(3, 13)
    gr.addEdge(13, 23)
    gr.addEdge(23, 33)
    gr.addEdge(33, 43)
    gr.addEdge(43, 53)
    gr.addEdge(43, 44)
    gr.addEdge(44, 45)
    gr.addEdge(45, 55)
    gr.addEdge(55, 65)
    gr.addEdge(55, 65)
    gr.addEdge(65, 75)
    gr.addEdge(75, 85)
    gr.addEdge(85, 95)
    gr.addEdge(95, 94)
    gr.addEdge(94, 93)

    gr.addEdge(53, 63)
    gr.addEdge(63, 73)
    gr.addEdge(73, 83)
    gr.addEdge(83, 93)
    val l = gr.bfs(3, 55)
    gr.print(l)


}
