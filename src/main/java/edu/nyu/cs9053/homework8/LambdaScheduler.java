package edu.nyu.cs9053.homework8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class LambdaScheduler {
	public static List<Job> schedule(List<Job> jobs) {
		List<Job> res = new ArrayList<>();
		if(jobs == null || jobs.size() == 0) return res;
		Collections.sort(jobs, new Comparator<Job>() {
			@Override
			public int compare(Job job1, Job job2) {
				return job1.getEnd() - job2.getEnd();//put the job with a ealier end time ahead
			}
		});
		Job prev = null;
		for (Job next : jobs) {
			if(prev == null || next.getStart() >= prev.getEnd()) {
				res.add(next);
				prev = next;
			}
		}
		return res;
	}
}