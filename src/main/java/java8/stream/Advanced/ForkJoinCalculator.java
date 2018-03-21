package java8.stream.Advanced;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculator extends RecursiveTask<Long> {

    private static final long THRESHOLD = (long) 1e5;

    private long start;
    private long end;

    ForkJoinCalculator(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long gap = end - start;

        if (gap < THRESHOLD) {
            return Long.sum(start, end);
        } else {
            Long mid = (end + start) / 2;

            ForkJoinCalculator leftCalculator = new ForkJoinCalculator(start, mid);
            ForkJoinCalculator rightCalculator = new ForkJoinCalculator(mid+1, end);

            // fork sub tasks, and push into thread queue at the same time
            leftCalculator.fork();
            rightCalculator.fork();

            return leftCalculator.join() + rightCalculator.join();
        }
    }
}
