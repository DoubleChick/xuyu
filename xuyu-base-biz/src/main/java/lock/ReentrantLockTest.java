package lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现可重入锁
 *
 * @author zhaojinfeng
 * @create 2019-01-08 9:39 PM
 */
public class ReentrantLockTest {

    private volatile AtomicInteger atomicInteger = new AtomicInteger(0);

    private volatile Thread lockThread = null;

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.tryLock();
    }

    /**
     * 可重入加锁
     *
     * @return
     */
    public boolean tryLock() {
        if (atomicInteger.get() == 0) {
            if (atomicInteger.compareAndSet(0, 1)) {
                lockThread = Thread.currentThread();
                return true;
            } else {
                return false;
            }
        } else {
            if (lockThread == Thread.currentThread()) {
                int state = atomicInteger.get() + 1;
                atomicInteger.set(state);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean tryRelease(){
        return false;
    }

}
