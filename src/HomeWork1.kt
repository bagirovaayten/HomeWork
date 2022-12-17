fun main() {
    val listStr = listOf('a', 'B', 'A', 'b', 'A', 'a')
    print(listStr.uniqueOrdered())

    val listInts = listOf(
        2, 5, 1, 5, 4, 4, 5, 3, 2, 6, 4, 5, 9, 5, 4, 2, 6, 6, 7, 7, 4, 9, 3, 1, 1
    )

    println(listInts.uniqueOrdered())
}

fun <T : Comparable<T>> List<T>.uniqueOrdered(): List<T> {
    val filteredList = mutableListOf<T>()

    for (i in this) {
        if (filteredList.contains(i).not()) {
            filteredList.add(i)
        }
    }
    for (j in filteredList.indices) {
        for (i in filteredList.indices.toMutableList().takeLast(filteredList.size - j - 1)) {
            if (filteredList[j] > filteredList[i]) {
                filteredList.sort()
            }
        }
    }
    return filteredList
}
