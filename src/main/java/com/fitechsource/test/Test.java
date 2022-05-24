package com.fitechsource.test;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

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

@Slf4j
public class Test {

    public static final int CHECK_THREADS_INTERVAL_MILLIS = 300;

    public static void main(String[] args) throws InterruptedException {

        int numberOfIterations = 1;
        long start = System.currentTimeMillis();
        for (int i = 0; i < numberOfIterations; i++) {

//            Toggle implementations
//            processSingleThreaded();
            processMultiThreaded();
        }
        log.info("Average execution time is {} ms.", (System.currentTimeMillis() - start) / numberOfIterations);

    }

    private static void processSingleThreaded() {
        Set<Double> res = new HashSet<>();

        try {
            for (int i = 0; i < TestConsts.N; i++) {
                res.addAll(TestCalc.calculate(i));
            }
        } catch (TestException e) {
            log.error(e.getMessage());
            return;
        }

        System.out.println(res);
    }

    private static void processMultiThreaded() throws InterruptedException {

        //flag for stopping other threads if one of them thrown an exception
        final AtomicBoolean exceptionThrown = new AtomicBoolean(false);

        Set<Double> res = Collections.synchronizedSet(new HashSet<>());
        ArrayList<Thread> threads = new ArrayList<>();

        int minIterationsPerOneThread = TestConsts.N / TestConsts.MAX_THREADS;
        int remainingIterations = TestConsts.N % TestConsts.MAX_THREADS;

        int firstIndex = 0;
        for (int i = 0; i < TestConsts.MAX_THREADS; i++) {
            int lastIndex = firstIndex + minIterationsPerOneThread;
            if (remainingIterations > 0) {
                lastIndex++;
                remainingIterations--;
            }

////          DEV: checking first and last index on each iteration
//            log.trace("firstIndex = {}", firstIndex);
//            log.trace("lastIndex = {}", lastIndex);


            int finalFirstIndex = firstIndex;
            int finalLastIndex = lastIndex;
            Thread thread = new Thread(() -> {
                try {
                    for (int j = finalFirstIndex; j < finalLastIndex; j++) {
                        res.addAll(TestCalc.calculate(j));
                    }
                } catch (TestException e) {
                    log.error("{} thrown TestException. ", Thread.currentThread().getName(), e);
                    exceptionThrown.set(true);
                    return;
                }
                log.trace("Thread {} successfully finished work.", Thread.currentThread().getName());
            });
            threads.add(thread);
            firstIndex = lastIndex;
        }

        final Thread coordinator = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(CHECK_THREADS_INTERVAL_MILLIS);
                } catch (InterruptedException ex) {
                    log.error("{} thread was interrupted", Thread.currentThread().getName(), ex);
                }
                if (exceptionThrown.get()) {
                    for (Thread thread : threads) {
                        //On my pc thread.isInterrupted() always returns false
                        // and because of that worker-0 is interrupted second time. Google says its known issue.
                        if (!thread.isInterrupted()) {
                            thread.interrupt();
                            log.warn("Coordinator thread interrupted {}.", thread.getName());
                        }
                    }
                    return;
                }
            }
        });

        coordinator.setName("Coordinator");
        coordinator.setDaemon(true);
        coordinator.start();
        log.trace("Coordinator is started.");

        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).setPriority(Thread.MAX_PRIORITY);
            String curThreadName = "worker-" + i;
            threads.get(i).setName(curThreadName);
            threads.get(i).start();
            log.trace("{} is started.", curThreadName);
        }

//        Uncomment to interrupt worker-0 and test exceptions
        threads.get(0).interrupt();

        for (Thread thread : threads) {
            thread.join();
        }

        if (!exceptionThrown.get()) {
            log.trace("Calculations in multithreaded mode finished successfully.");
            System.out.println(res);
        }
    }
}
