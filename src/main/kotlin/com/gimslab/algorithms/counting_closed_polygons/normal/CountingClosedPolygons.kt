package com.gimslab.algorithms.counting_closed_polygons.normal

import com.gimslab.algorithms.counting_closed_polygons.perf.BarPerf
import com.gimslab.algorithms.counting_closed_polygons.perf.HistoryPerf

class CountingClosedPolygons {

	fun solution(arrows: IntArray): Int {
		var answer = 0
		var oldp = Point(0, 0)
		val history = History()
		for (a in arrows) {
			val bar = Bar(oldp, oldp.move(a), a)
			if (!history.containsOverrideBarWith(bar)) {
				if (history.containsPoint(bar.end))
					answer++
				if (history.containsCrossBar(bar))
					answer++
			}
			history.add(bar)
			oldp = bar.end
		}
		return answer
	}

	fun solutionPerf(arrows: IntArray): Any {
		var answer = 0
		var oldp = Point(0, 0)
		val history = HistoryPerf()
		for(a in arrows){
			val bar = BarPerf(oldp, a)
			if(!history.containsOverrideBarWith(bar)){
				if(history.containsPoint(bar.end))
					answer++
				if(history.containsCrossBar(bar))
					answer++
			}
			history.add(bar)
			oldp = bar.end
		}
		return answer
	}
}
