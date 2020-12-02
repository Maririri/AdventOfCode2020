import util.readInputToList

data class PasswordPolicy(
    val repetitionRange: Pair<Int, Int>,
    val letter: Char,
    val password: String
)

fun main() {
    val passwordsPolicies = readInputToList("input_data/day02.txt").map {
        PasswordPolicy(
            Pair(it.substringBefore('-').toInt(), it.substringAfter('-').substringBefore(' ').toInt()),
            it.substringAfter(' ').substringBefore(':').toCharArray()[0],
            it.substringAfterLast(' ')
        )
    }

    val correctPasswords = passwordsPolicies.filter { checkPasswordComplianceToPolicy(it) }
    if (correctPasswords.isNotEmpty())
        println("Solved. The answer is ${correctPasswords.size}")
    else
        println("Keep Thinking")
}

fun checkPasswordComplianceToPolicy(policy: PasswordPolicy): Boolean {
    var rep = 0
    for (c in policy.password) {
        if (c == policy.letter) {
            rep++
        }
    }
    return policy.repetitionRange.first <= rep && rep <= policy.repetitionRange.second
}