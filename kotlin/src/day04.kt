import java.io.File

val requiredPassportFields = listOf(
    "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"
)

fun main() {
    val inputToString = File("input_data/day04.txt").readText()
    val listOfPassports = processPassToListMap(inputToString)
    val numOfValidPass = listOfPassports.count { isPassportValid(it) }

    if (numOfValidPass > 0)
        println("Solved. The answer is $numOfValidPass")
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