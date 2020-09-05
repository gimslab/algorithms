package counting_closed_polygons.normal

data class Point(
		val x: Int,
		val y: Int
) {
	fun distanceOneTo(p: Point): Boolean {
		return Math.abs(this.x - p.x) + Math.abs(this.y - p.y) == 1
	}

	fun move(arrow: Int): Point {
		val xoffset = when (arrow) {
			7, 6, 5 -> -1
			1, 2, 3 -> 1
			else -> 0
		}
		val yoffset = when (arrow) {
			7, 0, 1 -> -1
			5, 4, 3 -> 1
			else -> 0
		}
		return Point(x + xoffset, y + yoffset)
	}
}