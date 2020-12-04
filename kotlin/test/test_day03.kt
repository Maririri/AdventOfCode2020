import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class test_day03 {
    private val testMap = listOf(
        "..##.........##.........##.........##.........##.........##.......",
        "#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..",
        ".#....#..#..#....#..#..#....#..#..#....#..#..#....#..#..#....#..#.",
        "..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#",
        ".#...##..#..#...##..#..#...##..#..#...##..#..#...##..#..#...##..#.",
        "..#.##.......#.##.......#.##.......#.##.......#.##.......#.##.....",
        ".#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#",
        ".#........#.#........#.#........#.#........#.#........#.#........#",
        "#.##...#...#.##...#...#.##...#...#.##...#...#.##...#...#.##...#...",
        "#...##....##...##....##...##....##...##....##...##....##...##....#",
        ".#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#"
    )
    @Test
    fun test11(){
        val testListOfTrees = findAllTrees(testMap)
        assertEquals(countTreesOnPath(testMap, testListOfTrees, 1, 1), 2)
    }
    @Test
    fun test31(){
        val testListOfTrees = findAllTrees(testMap)
        assertEquals(countTreesOnPath(testMap, testListOfTrees, 3, 1), 7)
    }
    @Test
    fun test51(){
        val testListOfTrees = findAllTrees(testMap)
        assertEquals(countTreesOnPath(testMap, testListOfTrees, 5, 1), 3)
    }
    @Test
    fun test71(){
        val testListOfTrees = findAllTrees(testMap)
        assertEquals(countTreesOnPath(testMap, testListOfTrees, 7, 1), 4)
    }
    @Test
    fun test12(){
        val testListOfTrees = findAllTrees(testMap)
        assertEquals(countTreesOnPath(testMap, testListOfTrees, 1, 2), 2)
    }
}