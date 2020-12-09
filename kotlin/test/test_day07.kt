import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class test_day07 {
    @Test
    fun `Day 7 Part 2 count bags inside the shiny gold`() {
        val testData = """shiny gold bags contain 2 dark red bags.
dark red bags contain 2 dark orange bags.
dark orange bags contain 2 dark yellow bags.
dark yellow bags contain 2 dark green bags.
dark green bags contain 2 dark blue bags.
dark blue bags contain 2 dark violet bags.
dark violet bags contain no other bags.""".lines().map {
            parseBagsContainer(it)
        }.toMap()
        assertEquals(countBagsInside(testData), 126)

        val testData2 = """shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
faded blue bags contain no other bags.
dotted black bags contain no other bags.
vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
dark olive bags contain 3 faded blue bags, 4 dotted black bags.""".lines().map {
            parseBagsContainer(it)
        }.toMap()
        assertEquals(countBagsInside(testData2), 32)
    }
}