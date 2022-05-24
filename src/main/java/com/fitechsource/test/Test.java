package com.fitechsource.test;


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

public class Test {

    public static void main(String[] args) throws InterruptedException {

        int numberOfIterations = 1;
        long start = System.currentTimeMillis();
        for (int i = 0; i < numberOfIterations; i++) {

//            Toggle implementations
//            processSingleThreaded();
            processMultiThreaded();
        }
        System.out.println("Average execution time is " + (System.currentTimeMillis() - start) / numberOfIterations + " ms.");

    }

    private static void processSingleThreaded() {
        Set<Double> res = new HashSet<>();

        try {
            for (int i = 0; i < TestConsts.N; i++) {
                res.addAll(TestCalc.calculate(i));
            }
        } catch (TestException e) {
            e.printStackTrace();
            return;
        }

        System.out.println(res);
    }

    private static void processMultiThreaded() throws InterruptedException {


        //flag for stopping other threads if one of them thrown an exception
        final AtomicBoolean exceptionThrown = new AtomicBoolean(false);

        final int CHECK_THREADS_INTERVAL_MILLIS = 300;

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
                    System.out.println(Thread.currentThread().getName() + " thrown TestException.");
                    e.printStackTrace();
                    exceptionThrown.set(true);
                    return;
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " successfully finished work.");
            });
            threads.add(thread);
            firstIndex = lastIndex;
        }

        final Thread coordinator = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(CHECK_THREADS_INTERVAL_MILLIS);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " thread was interrupted");
                    e.printStackTrace();
                }
                if (exceptionThrown.get()) {
                    for (Thread thread : threads) {
                        thread.interrupt();
                        System.out.println(" Coordinator interrupted " + thread.getName());
                    }
                    return;
                }
            }
        });

        coordinator.setName("Coordinator");
        coordinator.setDaemon(true);
        coordinator.start();


        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).setPriority(Thread.MAX_PRIORITY);
            String curThreadName = "worker-" + i;
            threads.get(i).setName(curThreadName);
            threads.get(i).start();
        }

//        Uncomment to interrupt worker-0 and test exceptions
//        threads.get(0).interrupt();

        for (Thread thread : threads) {
            thread.join();
        }

        if (!exceptionThrown.get()) {
            System.out.println("Calculations in multithreaded mode finished successfully.");
            System.out.println(res);
        }
    }
}
