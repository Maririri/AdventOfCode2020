import util.readInputToSortedListInt

fun main() {
    val sortedListOfAdapters = readInputToSortedListInt("input_data/day10.txt")
    val joltList1 = sortedListOfAdapters.mapIndexed { idx, it ->
        getJoltDiffSeq(idx, sortedListOfAdapters, it)
    }.filter { it == 1 }
    val joltList3 = sortedListOfAdapters.mapIndexed { idx, it ->
        getJoltDiffSeq(idx, sortedListOfAdapters, it)
    }.filter { it == 3 }

    val res = joltList1.size * (joltList3.size + 1)

    println(res)
}

internal fun getJoltDiffSeq(
    idx: Int,
    sortedListOfAdapters: List<Int>,
    it: Int
) = when (idx) {
    0 -> it
    else -> (it - sortedListOfAdapters[idx - 1])
}

