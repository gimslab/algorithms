package com.gimslab.algorithms

fun main() {
	val a1 = SmartArray(listOf(1, 2, 3, 4, 8, 9, 100).toIntArray(), 0)
	val a2 = SmartArray(listOf(2, 3, 8, 9, 22, 33, 44, 55, 100).toIntArray(), 0)
	val a3 = SmartArray(listOf(1, 3, 4, 9, 10, 100).toIntArray(), 0)
	val aset = ArraySet(a1, a2, a3)

	while (aset.noArrayOob()) {
		println("$a1 $a2 $a3")
		if (aset.matchAllCurVal()) {
			println("------------> ${aset.sa1.curVal()}")
			aset.sa1.increaseIdx()
		} else {
			val arrMin = aset.findArrayHasMinCurVal()
			arrMin.increaseIdx()
		}
	}
}

class SmartArray(
		private val arr: IntArray,
		private var idx: Int
) {
	fun oob() = idx >= arr.size
	fun curVal() = arr[idx]

	fun increaseIdx() {
		idx++
	}

	override fun toString() = "$idx:${arr[idx]}"
}

class ArraySet(
		val sa1: SmartArray,
		val sa2: SmartArray,
		val sa3: SmartArray,
) {
	fun noArrayOob() = !sa1.oob() && !sa2.oob() && !sa3.oob()
	fun matchAllCurVal() = sa1.curVal() == sa2.curVal() && sa2.curVal() == sa3.curVal()
	fun findArrayHasMinCurVal(): SmartArray {
		return if (sa1.curVal() <= sa2.curVal() && sa1.curVal() <= sa3.curVal())
			sa1
		else if (sa2.curVal() <= sa3.curVal() && sa2.curVal() <= sa1.curVal())
			sa2
		else
			sa3
	}
}
