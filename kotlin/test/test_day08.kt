import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class test_day08 {
    @Test
    fun test1() {
        val testData = """nop +0
acc +1
jmp +4
acc +3
jmp -3
acc -99
acc +1
jmp -4
acc +6"""
        val testList = testData.split("\n").map { transformToInstrPair(it) }
        assertEquals(findAcc1(testList), 5)
    }
}