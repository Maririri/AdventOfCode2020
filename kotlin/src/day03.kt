import util.readInputToList

data class Position(val x: Int, val y: Int)

fun main() {
    val input = readInputToList("input_data/day03.txt")
    val listOfTrees = findAllTrees(input)
    val treeCount = countTreesOnPath(input, listOfTrees)
    if (treeCount > 0)
        println("Solved. The answer is $treeCount")
    else
        println("Keep Thinking")
}

fun countTreesOnPath(
    input: List<String>,
    listOfTrees: MutableList<Position>
): Int {
    val width = input[0].length
    val height = input.size
    var i = 0
    var j = 0
    var treeCount = 0

    while (j < height) {
        if (i>=width)
            i-=width

        treeCount += listOfTrees.contains(Position(i, j)).toInt()
        i += 3; j++
    }
    return treeCount
}

fun findAllTrees(input: List<String>) =
    input.foldIndexed(mutableListOf<Position>()) { i, acc, row ->
        row.forEachIndexed { j, char ->
            if (char == '#') {
                acc.add(Position(j, i))
            }
        }
        acc
    }

fun Boolean.toInt() = if (this) 1 else 0