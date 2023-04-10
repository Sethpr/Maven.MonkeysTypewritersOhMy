package io.zipcoder;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.StampedLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {

    StampedLock lock = new StampedLock();

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    @Override
    public void run() {
        long stamp = lock.writeLock();
        while(stringIterator.hasNext()){
            copied = copied + stringIterator.next() + " ";
        }
        lock.unlockWrite(stamp);
    }

}
