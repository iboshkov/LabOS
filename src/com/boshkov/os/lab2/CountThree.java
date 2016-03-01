package com.boshkov.os.lab2;

import java.util.HashSet;
import java.util.Scanner;

public class CountThree {

    public static int NUM_RUNS = 100;
    /**
     * Promenlivata koja treba da go sodrzi brojot na pojavuvanja na elementot 3
     */
    int count = 0;

    public void init() {
    }

    class Counter extends Thread {
        public synchronized void count(int[] data) throws InterruptedException {
            for (int i : data){
                if (i == 3) count++;
            }
        }
        private int[] data;

        public Counter(int[] data) {
            this.data = data;
        }

        @Override
        public void run() {
            try {
                count(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            CountThree environment = new CountThree();
            environment.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void start() throws Exception {

        init();

        HashSet<Thread> threads = new HashSet<Thread>();
        Scanner s = new Scanner(System.in);
        int total=s.nextInt();

        for (int i = 0; i < NUM_RUNS; i++) {
            int[] data = new int[total];
            for (int j = 0; j < total; j++) {
                data[j] = s.nextInt();
            }
            Counter c = new Counter(data);
            threads.add(c);
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println(count);
    }
}

/*
    Input so 1000 brojki:
    10
    2
    9
    6
    5
    10
    2
    10
    7
    1
    2
    8
    10
    3
    8
    8
    4
    7
    5
    4
    4
    7
    9
    4
    7
    10
    9
    8
    10
    6
    5
    10
    6
    2
    4
    4
    4
    6
    4
    9
    9
    9
    9
    6
    7
    7
    7
    9
    6
    3
    6
    8
    7
    9
    4
    9
    2
    1
    6
    6
    3
    8
    6
    3
    7
    6
    5
    6
    7
    7
    6
    5
    2
    3
    2
    2
    3
    2
    10
    3
    1
    5
    10
    4
    6
    2
    7
    10
    10
    10
    6
    8
    1
    4
    6
    7
    3
    4
    3
    3
    9
    1
    2
    5
    3
    5
    2
    9
    4
    3
    3
    9
    10
    1
    1
    4
    1
    2
    8
    7
    10
    2
    10
    4
    9
    10
    7
    6
    10
    6
    1
    5
    5
    6
    8
    2
    8
    5
    4
    5
    10
    5
    7
    2
    5
    2
    4
    3
    3
    8
    5
    10
    9
    10
    9
    2
    6
    8
    4
    8
    7
    6
    3
    2
    10
    2
    2
    5
    4
    6
    3
    4
    7
    7
    6
    1
    3
    8
    9
    2
    6
    2
    5
    9
    10
    8
    6
    2
    3
    2
    3
    3
    6
    1
    1
    3
    7
    6
    1
    4
    4
    9
    5
    10
    1
    1
    5
    1
    2
    8
    9
    5
    6
    2
    2
    8
    6
    6
    3
    4
    1
    5
    1
    9
    2
    5
    3
    1
    4
    8
    7
    2
    6
    4
    3
    1
    6
    7
    7
    8
    6
    9
    8
    6
    9
    10
    2
    1
    7
    2
    7
    5
    2
    7
    7
    1
    6
    8
    9
    2
    2
    10
    8
    3
    4
    3
    10
    5
    1
    1
    5
    7
    2
    8
    10
    5
    3
    3
    10
    3
    1
    3
    5
    1
    8
    3
    5
    8
    5
    10
    8
    1
    2
    3
    10
    4
    7
    7
    4
    4
    7
    5
    3
    9
    5
    3
    2
    9
    6
    4
    8
    1
    2
    8
    5
    5
    7
    6
    9
    8
    6
    10
    3
    9
    4
    5
    8
    5
    1
    4
    6
    2
    7
    1
    7
    10
    6
    6
    9
    10
    2
    8
    4
    5
    5
    6
    6
    9
    4
    1
    6
    9
    5
    5
    2
    8
    4
    6
    1
    3
    1
    2
    1
    7
    4
    10
    5
    6
    2
    9
    1
    7
    1
    6
    3
    8
    7
    1
    9
    8
    1
    8
    8
    2
    10
    8
    4
    1
    8
    10
    7
    9
    3
    4
    8
    5
    4
    6
    7
    9
    2
    7
    2
    1
    3
    9
    5
    9
    9
    5
    8
    9
    2
    5
    2
    5
    9
    3
    3
    1
    3
    5
    10
    3
    10
    5
    6
    8
    3
    4
    1
    2
    1
    2
    2
    8
    5
    3
    7
    2
    9
    5
    9
    9
    8
    9
    10
    6
    3
    8
    6
    5
    8
    5
    9
    9
    2
    6
    9
    3
    10
    3
    1
    3
    3
    6
    6
    6
    5
    5
    7
    4
    1
    8
    3
    5
    3
    2
    5
    2
    8
    10
    5
    10
    8
    3
    3
    1
    2
    2
    2
    1
    9
    2
    2
    2
    1
    5
    2
    7
    7
    2
    4
    7
    6
    10
    7
    10
    5
    9
    2
    9
    9
    6
    7
    1
    3
    9
    3
    2
    2
    2
    9
    3
    8
    7
    8
    1
    7
    4
    5
    10
    2
    1
    4
    10
    5
    7
    5
    1
    10
    4
    1
    2
    6
    4
    2
    7
    2
    4
    7
    1
    1
    3
    3
    7
    7
    3
    9
    7
    9
    8
    9
    4
    1
    8
    7
    5
    2
    8
    7
    3
    10
    6
    3
    6
    9
    1
    10
    2
    8
    7
    3
    3
    2
    2
    5
    3
    9
    6
    7
    7
    6
    9
    5
    10
    7
    10
    9
    10
    9
    7
    4
    9
    5
    6
    2
    5
    7
    8
    3
    2
    8
    4
    4
    7
    9
    10
    10
    6
    9
    4
    7
    8
    1
    3
    10
    6
    2
    7
    2
    8
    10
    9
    2
    4
    3
    5
    5
    4
    5
    4
    10
    4
    8
    10
    7
    10
    6
    7
    5
    10
    3
    5
    8
    5
    10
    10
    10
    10
    1
    4
    5
    9
    2
    9
    6
    4
    8
    4
    4
    4
    10
    5
    6
    10
    5
    10
    2
    4
    3
    6
    1
    1
    2
    10
    9
    1
    6
    7
    4
    5
    4
    1
    4
    4
    10
    10
    7
    10
    4
    3
    10
    3
    4
    10
    10
    7
    7
    3
    4
    7
    3
    10
    4
    3
    8
    7
    1
    5
    5
    8
    6
    3
    8
    2
    4
    9
    9
    2
    6
    3
    9
    10
    8
    7
    2
    9
    9
    10
    4
    8
    7
    2
    4
    2
    9
    5
    1
    1
    7
    4
    2
    2
    7
    4
    6
    9
    9
    9
    8
    6
    3
    2
    8
    10
    6
    6
    7
    5
    1
    8
    3
    6
    8
    5
    7
    9
    6
    1
    9
    3
    8
    5
    6
    10
    7
    3
    6
    4
    6
    10
    2
    1
    5
    1
    5
    2
    1
    10
    7
    8
    2
    2
    8
    9
    5
    4
    5
    1
    6
    10
    3
    1
    10
    10
    10
    8
    3
    7
    6
    5
    5
    5
    7
    6
    2
    4
    5
    4
    3
    9
    9
    3
    7
    5
    10
    4
    3
    8
    2
    5
    9
    4
    4
    1
    6
    10
    9
    1
    3
    3
    4
    5
    1
    7
    4
    3
    1
    1
    5
    3
    1
    9
    7
    4
    10
    2
    4
    4
    1
    4
    3
    8
    6
    6
    6
    9
    3
    6
    7
    3
    7
    1
    10
    5
    6
    4
    8
    1
    3
    3
    8
    9
    10
    7
    10
    3
    7
    8
    1
    8
    4
    10
    7
    9
    4
    3
    3
    10
    7
    3
    3
    5
    2
    6
    4
    6
    1
    8
    9
    10
    5
    3
    5
    7
    10
    10
    8
    7
    7
    7
    9
    3
    3
    3
    7
    7
    2
    2
    6
    10
    3
    10
    2
    4
    2
    10
    4
    6
    1
    8
    3
    7
    4
    6
    1
    1
    10
    9
    5
    6
    1
    10
    6
    6
    8
    5
    9
    1
    5
    2
    3
    5
    9
    10
    2
    6
    7
    1
    8
    2
    2
    8
    4
    3
    2
    8
    6
    6
    6
    4
    4
    1
    6
    4
    1
    4
    7
    10
    6
    result: 109
    from: random.org
*/