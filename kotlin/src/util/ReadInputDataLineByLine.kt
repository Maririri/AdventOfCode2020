package util

import java.io.File

fun readInputDatatoList(fileName: String) = File(fileName).readLines().map { it.toInt() }