import util.readInputToList

const val rows = 128
const val columns = 8

fun main() {
    val plainSeats = mutableListOf<Int>()
    readInputToList("input_data/day05.txt").map {
        divideRowAndCol(it)
    }.forEach {
        val seatID = findSeatID(rows, columns, it)
        plainSeats.add(seatID)
    }
    println("${plainSeats.maxOrNull() ?: "Keep Thinking"}")
}

fun divideRowAndCol(it: String): Pair<String, String> {
    val startCol = it.findAnyOf(listOf("L", "R"))
    return it.substringBefore(startCol!!.second) to it.subSequence(startCol.first, it.length).toString()
}

fun findSeatID(rows: Int, columns: Int, it: Pair<String, String>): Int {
    var row = 0 to rows - 1
    var col = 0 to columns - 1
    row = findSeatInRange(it.first, row)
    col = findSeatInRange(it.second, col)
    return row.first * 8 + col.first
}

fun findSeatInRange(
    str: String,
    range: Pair<Int, Int>
): Pair<Int, Int> {
    var range1 = range
    for (l in str) {
        val begin = range1.first
        val end = range1.second
        when (l) {
            'F', 'L' -> range1 = begin to (begin + (end - begin) / 2)
            'B', 'R' -> range1 = (begin + (end - begin) / 2 + 1) to end
        }
    }
    return range1
}