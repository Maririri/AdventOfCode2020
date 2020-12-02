import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import day1.findPairOfElements


class test_day01() {
    @Test
    fun checkTwoNumbers() {
        val testArray = listOf(1721, 299)
        findPairOfElements(0, testArray.size - 1, testArray, 2020)?.let {
            assertEquals(it.first + it.second, 2020)
        }
    }
}