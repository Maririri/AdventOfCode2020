import util.readInputToList

fun main() {
    val bagsContainer = readInputToList("input_data/day07.txt").map {
        parseBagsContainer(it)
    }.toMap()

    val answer = bagsContainer.count { containsShinyGold(it.value, bagsContainer) }

    println(answer)

    val answer2 = countBagsInside(bagsContainer)

    println(answer2)
}

internal fun parseBagsContainer(it: String): Pair<String, Map<String, Int>> {
    val outerBag = it.substringBefore(" bags")
    val nestedBags = it.substringAfter("bags contain ")
        .replace("bags", "")
        .replace("bag", "")
        .replace(".", "")
        .split(",")
        .mapNotNull { itt ->
            if (itt == "no other ") {
                null
            } else {
                val (num, colour) = """([0-9]+) (.*)$""".toRegex().matchEntire(itt.trim())!!.destructured
                colour to num.toInt()
            }
        }.toMap()
    return outerBag to nestedBags
}

internal fun countBagsInside(
    bagsContainer: Map<String, Map<String, Int>>,
    key: String = "shiny gold"
): Int = bagsContainer[key]!!.toList().fold(0) { answer2, it ->
    answer2 + it.second + (it.second * countBagsInside(bagsContainer, it.first))
}


fun containsShinyGold(bagCluster: Map<String, Int>, bagsContainer: Map<String, Map<String, Int>>): Boolean =
    if (bagCluster.containsKey
            ("shiny gold")
    ) {
        true
    } else {
        bagCluster.keys.any { containsShinyGold(bagsContainer[it]!!, bagsContainer) }
    }
