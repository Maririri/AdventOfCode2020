package util

import java.io.File

fun readInputToList(fileName: String) = File(fileName).readLines()

fun readInputToSortedListInt(fileName: String) = readInputToList(fileName).map { it.toInt() }.sorted()

fun readInputSplintByBlankLines(input: String) = input.split("\n\n")