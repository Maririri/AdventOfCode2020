import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class test_day10 {
    @Test
    fun `Day 10 Part 1 Find Lists of 1 and 3 Jolts Difference`(){
        val testData = """16
10
15
5
1
11
7
19
6
12
4""".lines().map { it.toInt() }.sorted()

        val joltList1 = testData.mapIndexed() { idx, it ->
            getJoltDiffSeq(idx, testData, it)
        }
        val joltList3 = testData.mapIndexed() { idx, it ->
            getJoltDiffSeq(idx, testData, it)
        }

        assertEquals(7, joltList1.filter { it == 1 }.size)
        assertEquals(5, joltList3.filter { it == 3 }.size + 1)
    }
}