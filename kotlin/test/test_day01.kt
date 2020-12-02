import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import day1.findPairOfElements


class test_day01() {
    @Test
    fun test() {
        val testArray = arrayOf(1721, 299)
        val testPair = findPairOfElements(0, testArray.size - 1, testArray, 2020)

        assertEquals(testPair.first + testPair.second, 2020)
    }
}