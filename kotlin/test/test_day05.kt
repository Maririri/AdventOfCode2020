import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class test_day05 {
    @Test
    fun test1() {
        val testData = listOf("FBFBBFFRLR", "BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL").map { divideRowAndCol(it) }
        assertEquals(findSeatID(rows, columns, testData[0]), 357)
        assertEquals(findSeatID(rows, columns, testData[1]), 567)
        assertEquals(findSeatID(rows, columns, testData[2]), 119)
        assertEquals(findSeatID(rows, columns, testData[3]), 820)
    }
}