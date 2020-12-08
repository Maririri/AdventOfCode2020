import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class test_day08 {
    val testData = """nop +0
acc +1
jmp +4
acc +3
jmp -3
acc -99
acc +1
jmp -4
acc +6"""

    @Test
    fun test1() {
        val testList = testData.split("\n").map { transformToInstrPair(it) }
        assertEquals(findAcc1(testList).first, 5)
    }

    @Test
    fun test2() {
        val testList = testData.split("\n").map { transformToInstrPair(it) }
        assertEquals(findAcc2(testList), 8)
    }
}