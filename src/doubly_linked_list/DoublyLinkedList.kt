package doubly_linked_list

class DoublyLinkedList {
    var head: Node? = null
    var tail: Node? = null
    var size = 0

    fun append(i: Int) {
        if(size == 0){
            val n = Node(i, null, null)
            head = n
            tail = n
        } else {
            val n = Node(i, tail, null)
            tail?.next = n
            tail = n
        }
        size++
    }

    fun prepend(i: Int) {
        if(size == 0){
            val n = Node(i, null, null)
            head = n
            tail = n
        } else {
            val p = head
            head = Node(i, null, p)
            p?.previous = head
        }
        size++
    }

    fun delete(i: Int) {
        if(head == null) {
            return
        }

        if(head == tail && head?.i == i){
            head = null
            tail = null
            size--
            return
        }

        if(head?.i == i){
            head = head?.next
            head?.previous = null
            size--
            return
        }

        if(tail?.i == i){
            tail = tail?.previous
            tail?.next = null
            size--
            return
        }

        var p = head
        while(p?.next != null && p.next?.i != i){
            p = p.next
        }
        if (p?.next != null) {
            p.next = p.next?.next
            p.next?.previous = p
            size--
        }

    }

    fun print() {
        var p = head
        while(p != null) {
            println(p.i)
            p = p.next
        }
    }

    fun printReverse() {
        var p = tail
        while(p != null) {
            println(p.i)
            p = p.previous
        }
    }


}

data class Node(val i: Int, var previous: Node?, var next: Node?)

fun main() {
    val l = DoublyLinkedList()
    l.append(1)
    l.append(2)
    l.append(3)
    l.append(4)
    l.append(5)
    l.prepend(0)
    l.delete(3)
    l.delete(2)
    l.delete(0)
    l.delete(1)
    l.delete(4)
    l.delete(5)
    println(l.size)
    l.print()
    l.printReverse()
}
