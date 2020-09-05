package counting_closed_polygons.perf

import counting_closed_polygons.normal.Point

class HistoryPerf(
		val bars: MutableSet<BarPerf> = mutableSetOf(),
		val startPoints: MutableSet<Point> = mutableSetOf(),
		val barsThatHasCross: MutableSet<BarPerf> = mutableSetOf(),
		val barsReversedDir: MutableSet<BarPerf> = mutableSetOf()
) {
	fun add(bar: BarPerf) {
		bars.add(bar)
		startPoints.add(bar.start)
		barsThatHasCross.addAll(bar.crosses())
		barsReversedDir.add(bar.reverseDir())
	}

	fun containsPoint(p: Point): Boolean {
		return startPoints.contains(p)
	}

	fun containsCrossBar(b: BarPerf): Boolean {
		return barsThatHasCross.contains(b)
	}

	fun containsOverrideBarWith(b: BarPerf): Boolean {
		return bars.contains(b) || barsReversedDir.contains(b)
	}
}
