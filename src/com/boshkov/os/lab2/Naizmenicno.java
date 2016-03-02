package com.boshkov.os.lab2;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Naizmenicno {

    public static int NUM_RUNS = 1000;

    int f1count;
    int f2count;
    int maxDifference = 0;
    static Semaphore s1;
    static Semaphore s2;

    /**
     * Metod koj treba da gi inicijalizira vrednostite na semaforite i
     * ostanatite promenlivi za sinhronizacija.
     *
     */
    public void init(int count) {
        s1 = new Semaphore(count);
        s2 = new Semaphore(0);
    }

    class F1Thread extends Thread {

        @Override
        public void run() {
            try {
                executeF1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void executeF1() throws InterruptedException {
            if (s1.availablePermits() == 0){
                s2.release();
            }
            s1.acquire();
            f1();
        }
    }

    class F2Thread extends Thread {

        public void executeF2() throws InterruptedException {
            s2.acquire();
            f2();
            s2.release();
            s1.release();
        }

        @Override
        public void run() {
            try {
                executeF2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void f1() {
        System.out.println("f1()");
        f1count++;
        if (f1count - f2count > maxDifference) {
            maxDifference = f1count - f2count;
        }
    }

    public void f2() {
        System.out.println("f2()");
        f2count++;

        if (f1count - f2count > maxDifference) {
            maxDifference = f1count - f2count;
        }
    }

    public static void main(String[] args) {
        try {
            Naizmenicno environment = new Naizmenicno();
            environment.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void start() throws Exception {

        System.out.println("Vnesete za kolku poveke sakate da se izvrsi f1()");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        init(n);

        HashSet<Thread> threads = new HashSet<Thread>();
        for (int i = 0; i < NUM_RUNS; i++) {
            F1Thread f1 = new F1Thread();
            F2Thread f2 = new F2Thread();
            threads.add(f1);
            threads.add(f2);
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
        System.out.println("F1count: " + f1count);
        System.out.println("F2count: " + f2count);
        System.out.println("maxDifference: " + maxDifference);
        System.out.println("Status: " + (maxDifference <= n));
    }
}
