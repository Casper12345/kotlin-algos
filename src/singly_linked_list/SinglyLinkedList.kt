package singly_linked_list

class SinglyLinkedList() {
    var head: Node? = null
    var size = 0

    fun prepend(i: Int) {
        head = Node(i, head)
        size++
    }

    fun append(i: Int) {
        if (head == null) {
            prepend(i)
        } else {
            var p = head
            while (p!!.next != null) {
                p = p.next
            }
            p.next = Node(i, null)
            size++
        }
    }

    fun delete(i: Int) {
        if (head == null) {
            return
        }

        if(head?.i == i){
            head = head?.next
            size--
            return
        }
        var p = head
        while (p?.next != null && p.next?.i != i) {
            p = p.next
        }

        if (p?.next != null) {
            p.next = p.next?.next
            size--
        }


    }

    fun print() {
        var p = head
        while (p != null) {
            println(p!!.i)
            p = p.next
        }
    }


}

data class Node(val i: Int, var next: Node?)

fun main() {
    val ls = SinglyLinkedList()
    ls.append(1)
    ls.append(2)
    ls.append(3)
    ls.append(4)
//    ls.prepend(5)
//    println(ls.size)
    ls.delete(1)
    ls.delete(2)
    ls.delete(4)
    ls.print()
}
