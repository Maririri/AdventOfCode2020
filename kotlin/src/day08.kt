import util.readInputToList

const val fileName = "input_data/day08.txt"

fun main() {
    val listOfPair = readInputToList(fileName).map {
        transformToInstrPair(it)
    }

    println(listOfPair)

    val answer1 = findAcc1(listOfPair).first

    if (answer1 > 0)
        println("Solved. The answer is $answer1")
    else
        println("Keep Thinking")

    val answer2 = findAcc2(listOfPair)

    if (answer2 > 0)
        println("Solved. The answer is $answer2")
    else
        println("Keep Thinking")
}

fun findAcc1(listOfPair: List<Pair<String, Int>>): Pair<Int, Boolean> {
    var idx = 0
    var accum = 0
    var hasTerm = false
    val size = listOfPair.size
    val visitedPositions = MutableList(size) { false }
    while (!visitedPositions[idx]) {
        visitedPositions[idx] = true
        val instr = listOfPair[idx].first
        val value = listOfPair[idx].second
        when (instr) {
            "acc" -> {
                accum += value
                idx++
            }
            "jmp" -> idx += value
            "nop" -> idx++
        }
        if (idx >= size) {
            hasTerm = true
            break
        }
    }
    return accum to hasTerm
}

fun findAcc2(listOfPair: List<Pair<String, Int>>): Int {
    var answer = 0
    listOfPair.forEachIndexed { idx, it ->
        val mutableList = listOfPair.toMutableList()
        when (it.first) {
            "jmp" -> mutableList[idx] = "nop" to it.second
            "nop" -> mutableList[idx] = "jmp" to it.second
        }
        val findAcc1 = findAcc1(mutableList)
        if(findAcc1.second){
            answer = findAcc1.first
            return answer
        }
    }
    return answer
}

fun transformToInstrPair(it: String): Pair<String, Int> {
    val pairStr = it.split(" ")
    return pairStr[0] to pairStr[1].toInt()
}