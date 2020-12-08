import util.readInputToList

const val fileName = "input_data/day08.txt"

fun main() {
    val listOfPair = readInputToList(fileName).map {
        transformToInstrPair(it) /*to false*/
    }
    val answer1 = findAcc1(listOfPair)

    if (answer1 > 0)
        println("Solved. The answer is $answer1")
    else
        println("Keep Thinking")
}

fun findAcc1(listOfPair: List<Pair<String, Int>>): Int {
    var idx = 0
    var answer = 0
    val visitedPositions = MutableList(listOfPair.size) { false }
    while (!visitedPositions[idx]) {
        visitedPositions[idx] = true
        val instr = listOfPair[idx].first
        val value = listOfPair[idx].second
        when (instr) {
            "acc" -> {
                answer += value
                idx++
            }
            "jmp" -> idx += value
            "nop" -> idx++
        }
    }
    return answer
}

fun transformToInstrPair(it: String): Pair<String, Int> {
    val pairStr = it.split(" ")
    val instr = pairStr[0]
    val valueStr = pairStr[1]
    val plus = "+"; val minus = "-"
    val value = when {
        valueStr.startsWith(plus) -> valueStr.removePrefix(plus).toInt()
        valueStr.startsWith(minus) -> 0 - valueStr.removePrefix(minus).toInt()
        else -> null
    }
    return instr to value!!
}