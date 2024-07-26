package BST

class BinarySearchTree(var root: Node?) {

    fun search(i: Int, b: Node? = root): Boolean {
       if(b == null){
           return false
       } else {
           return if(b.value == i){
               true
           } else if(b.value > i){
               search(i, b.left)
           } else {
               search(i, b.right)
           }
       }
    }

    fun insert(i: Int) {
        if(root == null){
            root = Node(i, null, null)
        } else {
           insertRec(root, i)
        }
    }

    private fun insertRec(current: Node?, value: Int): Node {
        if(current == null){
            return Node(value, null, null)
        } else {
            if(value < current.value){
                current.left = insertRec(current.left, value)
            } else if(value > current.value){
                current.right = insertRec(current.right, value)
            }
            return current
        }
    }

    fun delete(value: Int) {
        root = deleteRec(root, value)
    }

    private fun deleteRec(current: Node?, value: Int): Node? {
        if (current == null) {
            return null
        }

        if (value < current.value) {
            current.left = deleteRec(current.left, value)
        } else if (value > current.value) {
            current.right = deleteRec(current.right, value)
        } else {
            // Node to be deleted found
            if (current.left == null && current.right == null) {
                return null
            } else if (current.left == null) {
                return current.right
            } else if (current.right == null) {
                return current.left
            } else {
                val smallestValue = findSmallestValue(current.right)
                current.value = smallestValue
                current.right = deleteRec(current.right, smallestValue)
            }
        }
        return current
    }

    private fun findSmallestValue(node: Node?): Int {
        return node?.left?.let { findSmallestValue(it) } ?: node!!.value
    }

    fun printInOrder(b: Node? = root){
        if(b == null){
            return
        } else {
            printInOrder(b.left)
            println(b.value)
            printInOrder(b.right)
        }
    }

    fun printPreOrder(b: Node? = root){
        if(b == null){
            return
        } else {
            println(b.value)
            printInOrder(b.left)
            printInOrder(b.right)
        }
    }
    fun printPostOrder(b: Node? = root){
        if(b == null){
            return
        } else {
            printInOrder(b.left)
            printInOrder(b.right)
            println(b.value)
        }
    }

}

data class Node(var value: Int, var left: Node?, var right: Node?)


fun main() {
    val bst = BinarySearchTree(null)
    bst.insert(1)
    bst.insert(2)
    bst.insert(20)
    bst.insert(10)
    bst.insert(90)



    bst.delete(20)
    bst.printInOrder()

    println(bst.search(20))
}
