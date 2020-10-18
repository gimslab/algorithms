package com.gimslab.algorithms.counting_closed_polygons.perf

import com.gimslab.algorithms.counting_closed_polygons.normal.Point

data class BarPerf(
		val start: Point,
		val end: Point,
		val dir: Int,
		val diagonal: Boolean
) {
	constructor(start: Point, dir: Int) : this(start, start.move(dir), dir, (dir % 2 != 0))

	fun cross(b: BarPerf): Boolean {
		return this.diagonal && b.diagonal
				&& this.dir != b.dir
				&& this.start.distanceOneTo(b.start)
				&& this.end.distanceOneTo(b.end)
	}

	fun crosses(): List<BarPerf> {
		return when (dir) {
			1 -> listOf(BarPerf(start.move(0), 3), BarPerf(start.move(2), 7))
			3 -> listOf(BarPerf(start.move(4), 1), BarPerf(start.move(2), 5))
			5 -> listOf(BarPerf(start.move(4), 7), BarPerf(start.move(6), 3))
			7 -> listOf(BarPerf(start.move(0), 5), BarPerf(start.move(6), 1))
			else -> listOf()
		}
	}

	fun reverseDir(): BarPerf {
		return BarPerf(end, (dir + 4) % 8)
	}

	fun overrideWith(b: BarPerf): Boolean {
		return this == b
				|| b.start == end && b.end == start
	}
}
