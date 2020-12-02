package day1

import util.readInputDatatoList

fun main() {
    val sortedArray = readInputDatatoList("input_data/day01.txt").sorted()

    val pair = findPairOfElements(0, sortedArray.size - 1, sortedArray, 2020)

    if (pair.first + pair.second == 2020)
        println("Solved. The answer is " + (pair.first * pair.second))
    else
        println("Keep thinking")

}

fun findPairOfElements(l: Int, r: Int, sortedArray: List<Int>, sum: Int): Pair<Int, Int> {
    var l1 = l
    var r1 = r

    while (l1 < r1) {
        val tempSum = sortedArray[l1] + sortedArray[r1]
        when {
            tempSum == sum -> break
            tempSum < sum -> l1++
            tempSum > sum -> r1--
        }
    }
    return Pair(sortedArray[l1], sortedArray[r1])
}
