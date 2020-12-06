import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class test_day06{
    @Test
    fun test1(){
        val testData = "abc\n" +
                "\n" +
                "a\n" +
                "b\n" +
                "c\n" +
                "\n" +
                "ab\n" +
                "ac\n" +
                "\n" +
                "a\n" +
                "a\n" +
                "a\n" +
                "a\n" +
                "\n" +
                "b"

        val testInputList = readInputSplintByBlankLines(testData)
        assertEquals(checkAnswers2(testInputList[0]), 3)
        assertEquals(checkAnswers2(testInputList[1]), 0)
        assertEquals(checkAnswers2(testInputList[2]), 1)
        assertEquals(checkAnswers2(testInputList[3]), 1)
        assertEquals(checkAnswers2(testInputList[4]), 1)
    }
}