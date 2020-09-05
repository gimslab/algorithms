package counting_closed_polygons

import counting_closed_polygons.normal.CountingClosedPolygons
import java.io.BufferedReader
import java.io.FileReader
import java.lang.Integer.parseInt
import java.lang.System.arraycopy
import java.lang.System.currentTimeMillis

fun main() {
	test(intArrayOf(6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0), 3)
	test(intArrayOf(6, 5, 2, 7, 1, 4, 2, 4, 6), 3)
	test(intArrayOf(5, 2, 7, 1, 6, 3), 3)
	test(intArrayOf(6, 2, 4, 0, 5, 0, 6, 4, 2, 4, 2, 0), 3)
	test(intArrayOf(2, 7, 2, 5, 0), 3)
	test(intArrayOf(1, 1, 4, 4, 6, 6, 1, 7, 3), 1)

	// test from file
	for (i in 1..10) {
		val infile = "src/main/resources/test_data/arhitekt.in.$i"
		val outfile = "src/main/resources/test_data/arhitekt.out.$i"
		print("[$i] ")
		test(
				readInputFile(infile),
				readExpectedOutputFile(outfile))
	}
}

fun readInputFile(filename: String): IntArray {
	val br = BufferedReader(FileReader(filename))
	var line1: String?
	var line2: String?
	br.use {
		line1 = br.readLine()
		line2 = br.readLine()
	}
	val arrayLength = parseInt(line1)
	val intArray = line2?.toCharArray()
			?.map { parseInt(it.toString()) }
			?.toIntArray() ?: intArrayOf()
	if (arrayLength == intArray.size)
		return intArray
	if (intArray.size > arrayLength) {
		val dest = intArrayOf()
		arraycopy(intArray, 0, dest, 0, arrayLength)
		return dest
	}
	throw IllegalArgumentException("invalid input data")
}

fun readExpectedOutputFile(filename: String): Int {
	val br = BufferedReader(FileReader(filename))
	br.use {
		val line1 = br.readLine()
		return parseInt(line1)
	}
}

fun test(arrows: IntArray, expected: Int) {
	val countingClosedPolygons = CountingClosedPolygons()
//	val started1 = currentTimeMillis()
//	val r1 = countingClosedPolygons.solution(arrows)
//	println("${r1 == expected} ${elapsedFrom(started1)} ms ${toSimpleString(arrows)} ==> $r1 expected:$expected")
	val started2 = currentTimeMillis()
	val r2 = countingClosedPolygons.solutionPerf(arrows)
	println("${r2 == expected} ${elapsedFrom(started2)} ms ${toSimpleString(arrows)} ==> $r2 expected:$expected")
}

fun toSimpleString(intArray: IntArray): String {
	val str = " (${intArray.size}) : ${intArray.contentToString()}"
	return if (str.length > 50)
		"${str.substring(0..50)} .. ]"
	else
		str
}

fun elapsedFrom(started: Long): Long {
	return currentTimeMillis() - started
}
