fun <T : Comparable<T>> findMax(items: List<T>): T {
    if (items.isEmpty()) {
        throw IllegalArgumentException("List tidak boleh kosong")
    }

    var maxItem = items[0]
    for (item in items) {
        if (item > maxItem) { // Ini sama aja kayak item.compareTo(maxItem) > 0
            maxItem = item
        }
    }
    return maxItem
}

fun main() {
    println(findMax(listOf(3, 7, 2, 9, 4)))           // 9
    println(findMax(listOf(1.5, 2.8, 0.3)))           // 2.8
    println(findMax(listOf("apel", "jeruk", "duku"))) // "jeruk" (alfabetis)
}
