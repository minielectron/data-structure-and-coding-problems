package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Job {
    public int deadline;
    public int profit;
    public String id;

    public Job(int deadline, int profit, String id) {
        this.deadline = deadline;
        this.id = id;
        this.profit = profit;
    }
}

class JobComparator implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        return -o1.profit + o2.profit;
    }
}


public class JobSequencing {

    public static void main(String[] args) {
        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(new Job(4, 20, "a"));
        jobs.add(new Job(1, 10, "b"));
        jobs.add(new Job(1, 40, "c"));
        jobs.add(new Job(1, 30, "d"));
        scheduleJobs(jobs);
    }

    private static void scheduleJobs(List<Job> jobs) {

        // Find maximum deadline allowed
        int max = Integer.MIN_VALUE;
        for (Job j : jobs) {
            if (max < j.deadline) {
                max = j.deadline;
            }
        }

        // Create a array of deadlines
        String[] schedule = new String[max];

        // Sort the Jobs
        jobs.sort(new JobComparator());

        //Schedule the jobs
        int profit = 0;
        for (Job job : jobs) {
            if (schedule[job.deadline - 1] == null) {
                schedule[job.deadline - 1] = job.id;
                profit += job.profit;
            } else {
                for (int i = 0; i < job.deadline - 1; i++) {
                    if (schedule[i] == null) {
                        schedule[i] = job.id;
                        profit += job.profit;
                        break;
                    }
                }
            }
        }

        // Print the schedule
        for (String s : schedule) {
            if (s != null) {
                System.out.println(s + ", ");
            }
        }
        System.out.println(profit);

    }

}
