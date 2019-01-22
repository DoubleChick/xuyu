package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁源码阅读
 * @author zhaojinfeng
 * @create 2019-01-16 4:35 PM
 */
public class ReentrantLockSourceCode {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.tryLock();
    }
}
