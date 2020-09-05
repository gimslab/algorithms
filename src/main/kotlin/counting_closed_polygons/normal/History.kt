package counting_closed_polygons.normal

class History(
		private val bars: MutableSet<Bar> = mutableSetOf(),
) {
	fun add(bar: Bar) {
		bars.add(bar)
	}

	fun containsPoint(p: Point): Boolean {
		return bars.map { it.start }.contains(p)
	}

	fun containsCrossBar(b: Bar): Boolean {
		return bars.any { it.cross(b) }
	}

	fun containsOverrideBarWith(b: Bar): Boolean {
		return bars.any { it.overrideWith(b) }
	}
}