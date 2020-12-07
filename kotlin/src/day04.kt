import java.io.File

val requiredPassportFields = listOf(
    "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"
)

val validPassportFields = mapOf(
    "byr" to """^(19[2-9]\d|200[0-2])$""".toRegex(),
    "iyr" to """^(201\d|2020)$""".toRegex(),
    "eyr" to """^(202\d|2030)$""".toRegex(),
    "hgt" to """^(1[5-8]\d|19[0-3])cm$| |^(59|6\d|7[0-6])in$""".toRegex(),
    "hcl" to """^#([0-9a-f]){6}$""".toRegex(),
    "ecl" to """^(amb|blu|brn|gry|grn|hzl|oth)$""".toRegex(),
    "pid" to """^[0-9]{9}$""".toRegex()
)

fun main() {
    val inputToString = File("input_data/day04.txt").readText()
    val listOfPassports = processPassToListMap(inputToString)
    val numOfValidPass1 = listOfPassports.count { isPassportValid(it) }

    if (numOfValidPass1 > 0)
        println("Solved. The answer is $numOfValidPass1")
    else
        println("Keep Thinking")

    val numOfValidPass2 = listOfPassports.count { isPassportValid(it) && arePassportFieldsValid(it) }

    if (numOfValidPass2 > 0)
        println("Solved. The answer is $numOfValidPass2")
    else
        println("Keep Thinking")
}

fun processPassToListMap(inputToString: String): List<Map<String, String>> {
    val listOfPass = inputToString.split("\n\n").map {
        it.replace('\n', ' ')
    }

    val mapOfPassports = listOfPass.map {
        it.split(" ").mapNotNull { itt ->
            if (itt.isNotBlank()) {
                val entry = itt.split(":")
                entry[0] to entry[1]
            } else
                null
        }.toMap()
    }
    return mapOfPassports
}

fun isPassportValid(pass: Map<String, String>): Boolean {
    return requiredPassportFields.all {
        pass.containsKey(it)
    }
}

fun arePassportFieldsValid(pass: Map<String, String>): Boolean {
    return validPassportFields.all {
        pass[it.key]!!.matches(it.value)
    }
}