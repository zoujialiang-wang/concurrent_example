package threadPool.CountDownLatch;

import cn.hutool.core.date.StopWatch;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @version V1.0
 * @Package threadPool.order
 * @auther ZouJiaLiang
 * @data 2021/4/29 下午6:42
 */
public class Test2 {
    public static void main(String[] args) {
        while (true) {
            StopWatch stopWatch = new StopWatch("test2");
            stopWatch.start();
            AtomicReference<Object> pos = new AtomicReference<>();
            AtomicReference<Object> dos = new AtomicReference<>();
            // 查询未对账订单
            Thread T1 = new Thread(() -> pos.set(getPOrders()));
            T1.start();
            // 查询派送单
            Thread T2 = new Thread(() -> dos.set(getDOrders()));
            T2.start();
            // 等待T1、T2结束
            try {
                T1.join();
                T2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 执行对账操作
            Object diff = check(pos, dos);
            // 差异写入差异库
            save(diff);stopWatch.stop();
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
