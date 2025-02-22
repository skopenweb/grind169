fun Array<IntArray>.prettyPrint() {
    println("[ ")
    for (element in this) {
        print("[")
        for (j in 0..<this[0].size) {
            print(" ${element[j]}")
        }
        println("]")
    }
    println()
}