import util.readInputToList

data class Passport(
    val byr: Pair<Int, Boolean>,
    val iyr: Pair<Int, Boolean>,
    val eyr: Pair<Int, Boolean>,
    val hgt: Pair<String, Boolean>,
    val hcl: Pair<String, Boolean>,
    val ecl: Pair<String, Boolean>,
    val pid: Pair<Int, Boolean>,
    val cid: Pair<Int, Boolean>
) {
    fun isValid(): Boolean {
        return byr.second &&
                iyr.second &&
                eyr.second &&
                hgt.second &&
                hcl.second &&
                ecl.second &&
                pid.second
    }
}

fun main() {
    val inputToList = readInputToList("input_data/day04.txt")
    val listOfPassRaw = getAllRawPassports(inputToList)

    for (i in listOfPassRaw) {
        println(i)
        println("-----------------------")
    }
}

fun getAllRawPassports(inputToList: List<String>): MutableList<MutableList<String>> {
    val listOfPassRaw = mutableListOf<MutableList<String>>()
    val tempList = mutableListOf<String>()

    inputToList.forEach {
        if (it.isNotBlank()) {
            tempList.add(it)
        } else {
            listOfPassRaw.add(tempList.toCollection(mutableListOf()))

            tempList.clear()
        }
    }
    return listOfPassRaw
}