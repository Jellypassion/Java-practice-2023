package com.multithreading.queue;

import java.util.concurrent.BlockingQueue;

public class BuyerThread implements Runnable {

    private final BlockingQueue<Cashbox> cashboxes;

    public BuyerThread(BlockingQueue<Cashbox> cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {
        try {
            // Retrieves and removes the head of this queue, waiting if necessary until an element becomes available.
            Cashbox cashbox = cashboxes.take();
            System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashbox);
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashbox);
            cashboxes.add(cashbox);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//    @Override
//    public void run() {
//        try {
//            // to avoid changing the object by two threads at the same time we will use synchronized block
//            synchronized (cashboxes) {
//                // operations need to be performed inside an infinite loop
//                while (true) {
//                    if (!cashboxes.isEmpty()) {
//                        Cashbox cashbox = cashboxes.remove();
//                        System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashbox);
//                        // release the monitor of cashboxes
//                        // wait() should always be called inside synchronized block (when the monitor is captured on the object)
//                        // otherwise it will throw an exception
//                        cashboxes.wait(5L); // buyer spends 5 msec to perform a buy
//                        System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashbox);
//                        cashboxes.add(cashbox);
////                        cashboxes.notify();// notifies only one thread that is waiting for the object
//                        cashboxes.notifyAll();// notifies all the threads that are waiting for the object
//                        break;
//                    } else {
//                        System.out.println(Thread.currentThread().getName() + " ожидает свободную кассу ");
//                        // without parameters the thread waits until other threads will call notify() or notifyAll() methods
//                        cashboxes.wait();
//                    }
//                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}

