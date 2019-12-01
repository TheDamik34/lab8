package zad3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class PeriodicWriting {

    private String[] strings = {"aaaa", "bbbb", "cccc", "dddd"};
    private Thread[] threads = new Thread[strings.length];
    private WriteLetterFromArray[] workers = new WriteLetterFromArray[strings.length];
    private CyclicBarrier barrier;

    static class WriteLetterFromArray implements Runnable {
        private String tab;
        final CyclicBarrier barrier;

        public WriteLetterFromArray(String tab, CyclicBarrier barrier) {
            this.tab = tab;
            this.barrier = barrier;
        }

        @Override
        public void run() {

            for(int i = 0; i < tab.length(); ++i) {

                System.out.printf("%c", tab.charAt(i));

                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    return;
                }
            }
        }
    }

    public PeriodicWriting() {
        this.barrier = new CyclicBarrier(this.strings.length, () -> System.out.print(" "));

        for(int i = 0; i < strings.length; ++i) {
            workers[i] = new WriteLetterFromArray(strings[i], barrier);
            threads[i] = new Thread(workers[i]);
            threads[i].start();
        }
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public static void main(String[] args) throws InterruptedException {
        PeriodicWriting periodicWriting = new PeriodicWriting();

    }
}
