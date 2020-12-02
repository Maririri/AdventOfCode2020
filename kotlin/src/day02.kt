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

    val correctPasswords1 = passwordsPolicies.filter { checkPasswordComplianceToPolicy1(it) }
    if (correctPasswords1.isNotEmpty())
        println("Solved. The answer is ${correctPasswords1.size}")
    else
        println("Keep Thinking")

    val correctPasswords2 = passwordsPolicies.filter { checkPasswordComplianceToPolicy2(it) }
    if (correctPasswords2.isNotEmpty())
        println("Solved. The answer is ${correctPasswords2.size}")
    else
        println("Keep Thinking")
}

fun checkPasswordComplianceToPolicy1(policy: PasswordPolicy): Boolean {
    return policy.password.count { it == policy.letter } in (policy.repetitionRange.first..policy.repetitionRange.second)
}

fun checkPasswordComplianceToPolicy2(policy: PasswordPolicy): Boolean {
    return (policy.password[policy.repetitionRange.first - 1] == policy.letter) xor (policy.password[policy.repetitionRange.second - 1] == policy.letter)
}