package com.fitechsource.test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Should be improved to reduce calculation time.
 * <p>
 * 1. Change this file or create new one using parallel calculation mode.
 * 2. Do not use `executors`, only plain threads  (max threads count which should be created for calculations is com.fitechsource.test.TestConsts#MAX_THREADS)
 * 3. Try to provide simple solution, do not implement frameworks.
 * 4. Don't forget that calculation method can throw exception, process it right way.
 * (Stop calculation process and print error message. Ignore already calculated intermediate results, user doesn't need it.)
 * <p>
 * Please attach code files to email - skhisamov@fitechsource.com
 */

public class Test2 {
    public static void main(String[] args) throws InterruptedException, TestException {
        long start = System.currentTimeMillis();

        //Toggle implementations
//        processSingleThreaded();
        processMultiThreaded();

        System.out.println("Execution time is " + (System.currentTimeMillis() - start) + " ms.");
    }

    private static void processSingleThreaded() throws TestException {
        Set<Double> res = new HashSet<>();

        for (int i = 0; i < TestConsts.N; i++) {
            res.addAll(TestCalc.calculate(i));
        }

        System.out.println(res);
    }

    private static void processMultiThreaded() throws InterruptedException {
        Set<Double> res = Collections.synchronizedSet(new HashSet<>());

        ArrayList<WorkerThread> workers = new ArrayList<>(TestConsts.MAX_THREADS);

        AtomicInteger tasks = new AtomicInteger(TestConsts.N);


        for (int i = 0; i < TestConsts.MAX_THREADS; i++) {
            workers.add(new WorkerThread(res, tasks));
        }

        for (WorkerThread worker : workers) {
            worker.start();
        }

        for (WorkerThread worker : workers) {
            worker.join();
        }

        System.out.println(res);
    }

    static class WorkerThread extends Thread {

        private Set<Double> res;
        private AtomicInteger count;

        WorkerThread(Set<Double> res, AtomicInteger count) {
            this.res = res;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    int cnt = count.decrementAndGet();

                    if (cnt < 0) {
                        return;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " decremented counter (" + cnt + "). Time is " + System.currentTimeMillis());
                        res.addAll(TestCalc.calculate(cnt));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}
