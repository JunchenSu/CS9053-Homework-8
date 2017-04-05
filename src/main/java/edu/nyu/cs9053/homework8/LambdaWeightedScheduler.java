package edu.nyu.cs9053.homework8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;


public class LambdaWeightedScheduler {

    /**
     * Sort the jobs by finish time.
     * For every job find the first job which does not overlap with this job
     * and see if this job profit plus profit till last non overlapping job is greater
     * than profit till last job.
     * @param jobs
     * @return
     */
    public static int maximum(List<Job> jobs){
        int profit[] = new int[jobs.size()];
        if (jobs == null || jobs.size() == 0) return 0;
        Collections.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job job1, Job job2) {
                return job1.getEnd() - job2.getEnd();//put the job with a ealier end time ahead
            }
        });
        profit[0] = jobs.get(0).getWeight();
        for(int i = 1; i < jobs.size(); i++) {
            profit[i] = Math.max(jobs.get(i).getWeight(), profit[i-1]);
            for(int j = 0; j < i; j++) {
                if(jobs.get(j).getEnd() <= jobs.get(i).getStart()){ //not overlap
                    profit[i] = Math.max(profit[i], jobs.get(i).getWeight() + profit[j]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int val : profit) {
            if (max < val) {
                max = val;
            }
        }
        return max;
    }
}