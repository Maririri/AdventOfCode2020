import util.readInputSplintByBlankLines
import java.io.File

fun main() {
    val fileStr = File("input_data/day06.txt").readText()
    val inputList = readInputSplintByBlankLines(fileStr)
    var numOfPositiveAnswers1 = 0
    val inputCharArr: List<CharArray> = inputList.map { it.replace("\n", "").toCharArray() }

    inputCharArr.forEach {
        numOfPositiveAnswers1 += it.distinct().count()
    }
    if (numOfPositiveAnswers1 > 0)
        println("Solved. The answer is $numOfPositiveAnswers1")
    else
        println("Keep Thinking")

    var numOfPositiveAnswers2 = 0
    inputList.forEach {
        numOfPositiveAnswers2 += checkAnswers2(it)
    }

    if (numOfPositiveAnswers2 > 0)
        println("Solved. The answer is $numOfPositiveAnswers2")
    else
        println("Keep Thinking")
}

fun checkAnswers2(it: String): Int {
    var numOfPositiveAnswers21 = 0
    val list = it.split("\n")
    it.replace("\n", "").toCharArray().distinct().forEach {
        if (list.all { str -> str.contains(it) })
            numOfPositiveAnswers21++
    }
    return numOfPositiveAnswers21
}

