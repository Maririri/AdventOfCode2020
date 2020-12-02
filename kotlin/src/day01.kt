import util.readInputToSortedListInt

fun main() {
    val sortedArray = readInputToSortedListInt("input_data/day01.txt")

    findPairOfElements(0, sortedArray.size - 1, sortedArray, 2020)?.let {
        println("Solved. The answer is " + (it.first * it.second))
    } ?: error("Keep thinking")

    findTripleOfElements(0, sortedArray.size - 1, sortedArray, 2020)?.let {
        println("Solved. The answer is " + (it.first * it.second * it.third))
    } ?: println("Keep thinking")
}

fun findPairOfElements(l: Int, r: Int, sortedArray: List<Int>, sum: Int): Pair<Int, Int>? {
    var l1 = l
    var r1 = r

    while (l1 < r1) {
        val tempSum = sortedArray[l1] + sortedArray[r1]
        when {
            tempSum == sum -> return Pair(sortedArray[l1], sortedArray[r1])
            tempSum < sum -> l1++
            tempSum > sum -> r1--
        }
    }
    return null
}

fun findTripleOfElements(l: Int, r: Int, sortedArray: List<Int>, sum: Int): Triple<Int, Int, Int>? {
    for (i in sortedArray) {
        findPairOfElements(l, r, sortedArray, sum - i)?.let {
            return Triple(it.first, it.second, i)
        }
    }
    return null
}