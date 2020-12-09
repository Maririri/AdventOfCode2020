import org.junit.jupiter.api.Test
import util.readInputSplintByBlankLines
import kotlin.test.assertEquals

class test_day06{
    @Test
    fun test1(){
        val testData = """abc

a
b
c

ab
ac

a
a
a
a

b
"""

        val testInputList = readInputSplintByBlankLines(testData)
        assertEquals(checkAnswers2(testInputList[0]), 3)
        assertEquals(checkAnswers2(testInputList[1]), 0)
        assertEquals(checkAnswers2(testInputList[2]), 1)
        assertEquals(checkAnswers2(testInputList[3]), 1)
        assertEquals(checkAnswers2(testInputList[4]), 1)
    }
}