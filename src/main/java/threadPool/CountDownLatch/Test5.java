package threadPool.CountDownLatch;

import threadPool.util.ExecutorManager;

import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @Package threadPool.order
 * @auther ZouJiaLiang
 * @data 2021/4/29 下午7:08
 */
public class Test5 {
    static Vector<Object> pos = new Vector<>();
    static Vector<Object> doc = new Vector<>();
    static ThreadPoolExecutor test = ExecutorManager.getThreadPoolExecutor("test");
    static final CyclicBarrier barrier = new CyclicBarrier(2, () -> test.execute(() -> checkIng()));

    public static void main(String[] args) {
        test.execute(() -> {
            while (true) {
                pos.add(getPOrders());
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        test.execute(() -> {
            while (true) {
                doc.add(getPOrders());
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void checkIng() {
        Object p = pos.remove(0);
        Object c = doc.remove(0);
        // 执行对账操作
        Object diff = check(p, c);
        // 差异写入差异库
        save(diff);
        System.out.println(System.currentTimeMillis());
    }

    private static void save(Object diff) {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Object check(Object pos, Object dos) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object getDOrders() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object getPOrders() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
