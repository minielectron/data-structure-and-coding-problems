package greedy;

import java.util.ArrayList;
import java.util.List;

public class IntervalScheduling {
    public static void main(String[] args) {
        var intervalScheduling = new IntervalScheduling();
        int[][] input = {
                {0, 3},
                {0, 6},
                {0,17},
                {8,11},
                {19,23}
        };
        var output = intervalScheduling.constructOptimalSchedule(input);
        for (int[] current : output) {
            for (int k : current) {
                System.out.println(k);
            }
        }
    }

    public List<int[]> constructOptimalSchedule(int[][] intervals) {
        var output = new ArrayList<int[]>();
        int[] currentInterval = intervals[0];
        output.add(currentInterval);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= currentInterval[1]) {
                output.add(intervals[i]);
                currentInterval = intervals[i];
            }
        }

        return output;
    }
}
