import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class test_day01() {
    @Test
    fun checkTwoNumbers() {
        val testArray = listOf(1721, 299)
        findPairOfElements(0, testArray.size - 1, testArray, 2020)?.let {
            assertEquals(it.first + it.second, 2020)
        }
    }

    @Test
    fun checkThreeNumbers() {
        val testArray = listOf(366, 675, 979)
        findTripleOfElements(0, testArray.size - 1, testArray, 2020)?.let {
            assertEquals(it.first + it.second + it.third, 2020)
        }
    }
}