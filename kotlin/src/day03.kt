import util.readInputToList

data class Position(val x: Int, val y: Int)

fun main() {
    val input = readInputToList("input_data/day03.txt")
    val listOfTrees = findAllTrees(input)
    val treeCount1 = countTreesOnPath(input, listOfTrees, 3, 1)
    if (treeCount1 > 0)
        println("Solved. The answer is $treeCount1")
    else
        println("Keep Thinking")

    val treeCount2 : Long= countTreesOnPath(input, listOfTrees, 1, 1)*
            countTreesOnPath(input, listOfTrees, 3, 1)*
            countTreesOnPath(input, listOfTrees, 5, 1)*
            countTreesOnPath(input, listOfTrees, 7, 1)*
            countTreesOnPath(input, listOfTrees, 1, 2).toLong()
    if (treeCount2 > 0)
        println("Solved. The answer is $treeCount2")
    else
        println("Keep Thinking")
}

fun countTreesOnPath(
    input: List<String>,
    listOfTrees: MutableList<Position>,
    stepX: Int,
    stepY: Int
): Int {
    val width = input[0].length
    val height = input.size
    var i = 0
    var j = 0
    var treeCount = 0

    while (j < height) {
        if (i >= width)
            i -= width

        treeCount += listOfTrees.contains(Position(i, j)).toInt()
        i += stepX; j += stepY
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