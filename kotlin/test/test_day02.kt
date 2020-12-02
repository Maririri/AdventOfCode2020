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
        assertTrue { checkPasswordComplianceToPolicy1(testPasswordPolicy[0]) }
        assertFalse { checkPasswordComplianceToPolicy1(testPasswordPolicy[1]) }
        assertTrue { checkPasswordComplianceToPolicy1(testPasswordPolicy[2]) }
    }
    @Test
    fun test2() {
        val testPasswordPolicy = listOf(
            PasswordPolicy(Pair(1, 3), 'a', "abcde"),
            PasswordPolicy(Pair(1, 3), 'b', "cdefg"),
            PasswordPolicy(Pair(2, 9), 'c', "ccccccccc")
        )
        assertTrue { checkPasswordComplianceToPolicy2(testPasswordPolicy[0]) }
        assertFalse { checkPasswordComplianceToPolicy2(testPasswordPolicy[1]) }
        assertFalse { checkPasswordComplianceToPolicy2(testPasswordPolicy[2]) }
    }
}