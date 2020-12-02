package day1

import util.readInputDatatoList

fun main(args: Array<String>) {
    val sortedArray = readInputDatatoList("input_data/day01.txt").sorted().toTypedArray()

    val pair = findPairOfElements(0, sortedArray.size - 1, sortedArray, 2020)

    if (pair.first + pair.second == 2020)
        println("Solved. The answer is " + (pair.first * pair.second))
    else
        println("Keep thinking")

}

fun findPairOfElements(l: Int, r: Int, sortedArray: Array<Int>, sum: Int): Pair<Int, Int> {
    var l1 = l
    var r1 = r

    while (l < r) {
        when {
            sortedArray[l1] + sortedArray[r1] == sum -> break
            sortedArray[l1] + sortedArray[r1] < sum -> l1++
            sortedArray[l1] + sortedArray[r1] > sum -> r1--
        }
    }
    return Pair(sortedArray[l1], sortedArray[r1])
}
