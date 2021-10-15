package com.gimslab.algorithms

class RobotPath {
}

fun main() {
	val m = 7
	val n = 3
	val p = robotPath(m, n)
	println("m:${m} n:${n} path:${p}")
}

fun robotPath(m: Int, n: Int): Int {
	return if (m == 1 || n == 1) 1
	else robotPath(m - 1, n) + robotPath(m, n - 1)
}
