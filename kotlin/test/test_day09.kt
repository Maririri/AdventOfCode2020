import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class test_day09 {
        val testSeq = """35
20
15
25
47
40
62
55
65
95
102
117
150
182
127
219
299
277
309
576""".lines().map { it.toLong() }
    @Test
    fun `Day 9 Part 1 Find Number not Corresponding to Property`(){
        val testListOfWrongNums = findNumsWithoutProperty(testSeq, 5)
        assertEquals(127, testListOfWrongNums.first())
    }

    @Test
    fun `Day 9 Part 2 Find Contiguous Set for Wrong Number`(){
        val testNum = firstNumFromSet(testSeq, 127)
        assertEquals(15, testNum)
    }

}