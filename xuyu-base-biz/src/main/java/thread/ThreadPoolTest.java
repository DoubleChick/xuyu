package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhaojinfeng
 * @create 2019-01-16 11:59 AM
 */
public class ThreadPoolTest implements Runnable {

    // ExecutorService继承Executor，一个支持返回值一个不支持
    // ThreadPoolExecutor继承AbstractExecutorService继承ExecutorService

    // 静态原子整型
    private static AtomicInteger num = new AtomicInteger();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            executorService.execute(new ThreadPoolTest());
//            Future<Integer> future = executorService.submit((Callable<Integer>) () -> getAndIncrease());
//            System.out.println(future.get());
        }
    }

    public static Integer getAndIncrease() {
        return num.getAndIncrement();
    }
}
