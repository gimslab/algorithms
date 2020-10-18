package com.gimslab.algorithms.counting_closed_polygons.normal

data class Bar(
		val start: Point,
		val end: Point,
		val dir: Int
) {
	private fun diagonal(): Boolean {
		return dir % 2 != 0
	}

	fun cross(b: Bar): Boolean {
		return this.diagonal() && b.diagonal()
				&& this.dir != b.dir
				&& this.start.distanceOneTo(b.start)
				&& this.end.distanceOneTo(b.end)
	}

	fun overrideWith(b: Bar): Boolean {
		return this == b
				|| b.start == end && b.end == start
	}
}