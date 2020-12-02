import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class test_day02 {
    @Test
    fun test1() {
        val testPasswordPolicy = listOf(
            PasswordPolicy(Pair(1, 3), 'a', "abcde"),
            PasswordPolicy(Pair(1, 3), 'b', "cdefg"),
            PasswordPolicy(Pair(2, 9), 'c', "ccccccccc")
        )
        assertTrue { checkPasswordComplianceToPolicy(testPasswordPolicy[0]) }
        assertFalse { checkPasswordComplianceToPolicy(testPasswordPolicy[1]) }
        assertTrue { checkPasswordComplianceToPolicy(testPasswordPolicy[2]) }
    }
}