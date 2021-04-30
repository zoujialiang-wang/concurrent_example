package threadPool.CountDownLatch;

import cn.hutool.core.date.StopWatch;
import threadPool.util.ExecutorManager;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @version V1.0
 * @Package threadPool.order
 * @auther ZouJiaLiang
 * @data 2021/4/29 下午7:00
 */
public class Test4 {
    public static void main(String[] args) {
        ThreadPoolExecutor test = ExecutorManager.getThreadPoolExecutor("test");
        AtomicReference<Object> pos = new AtomicReference<>();
        AtomicReference<Object> dos = new AtomicReference<>();
        while (true) {
            CountDownLatch latch = new CountDownLatch(2);
            StopWatch stopWatch = new StopWatch("test4");
            stopWatch.start();
            // 查询未对账订单
            test.execute(() -> {
                pos.set(getPOrders());
                latch.countDown();
            });
            // 查询派送单
            test.execute(() -> {
                dos.set(getDOrders());
                latch.countDown();
            });
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 执行对账操作
            Object diff = check(pos, dos);
            // 差异写入差异库
            save(diff);
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
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
