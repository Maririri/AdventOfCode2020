import java.io.File

fun main() {
    val input = File("input_data/day09.txt").readLines().map { it.toLong() }
    val wrongNum = findNumsWithoutProperty(input).first()

    println("$wrongNum")

    val contiguousSetStart = firstNumFromSet(input, wrongNum)

    println(contiguousSetStart)
}

internal fun firstNumFromSet(input: List<Long>, wrongNum: Long) =
    input.filterIndexed { i, it ->
        if (it < wrongNum) {
            wrongNum == run {
                var accumulator = 0L
                var idx = i
                while ((accumulator < wrongNum) && (idx < input.size)) {
                    accumulator += input[idx]
                    idx++
                }
                accumulator
            }
        } else {
            false
        }
    }.first()

internal fun findNumsWithoutProperty(input: List<Long>, preambleLength: Int = 25): List<Long> =
    input.filterIndexed { idx, it ->
        if (idx >= preambleLength) {

            val preamble = input.subList(idx - preambleLength, idx)
            !hasProperty(preamble, it)
        } else {
            false
        }
    }

internal fun hasProperty(preamble: List<Long>, currElement: Long): Boolean {
    for (i in 0..preamble.size - 1)
        for (j in 1..preamble.size - 1)
            if ((i != j) && (preamble[i] + preamble[j] == currElement))
                return true
    return false
}