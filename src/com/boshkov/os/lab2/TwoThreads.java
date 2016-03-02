package com.boshkov.os.lab2;


public class TwoThreads {
    public static class ThreadAB implements Runnable {
        private String sA, sB;

        public ThreadAB(String a, String b){
            sA = a;
            sB = b;
        }
        public void run() {
            //if (sA == "A"){
            //    char a = sA.charAt(0);
            //    for (int i = (int)a; i < (int)a+26; i++){
            //        System.out.println((char)i);
            //    }
            //}
            //else
            //{
            //    for (int i = 1; i <= 26; i++){
            //        System.out.println(i);
            //    }
            //}
            System.out.println(sA);
            System.out.println(sB);
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadAB("A", "B")).start();
        new Thread(new ThreadAB("1", "2")).start();
    }
    /*
     Ako se izvrsat dve nitki paralelno koga ednata pecati broevi od 1 do 26 a drugata od A do Z, ke se izmesa izlezot
     so brojki i bukvi, ako nema dovolno jadra na procesorot da se paralelizira izvrsuvanjeto ke se izvrsat sekvencijalno.
    */
}
