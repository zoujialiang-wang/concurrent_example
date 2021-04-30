package threadPool.CountDownLatch;

import cn.hutool.core.date.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @Package threadPool.order
 * @auther ZouJiaLiang
 * @data 2021/4/29 下午6:28
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        while (true){
            StopWatch stopWatch = new StopWatch("test1");
            stopWatch.start("查询未对账订单");
            // 查询未对账订单
            Object pos = getPOrders();
            stopWatch.stop();
            // 查询派送单
            stopWatch.start("查询派送单");
            Object dos = getDOrders();
            stopWatch.stop();
            stopWatch.start("执行对账操作");
            // 执行对账操作
            Object diff = check(pos, dos);
            stopWatch.stop();
            // 差异写入差异库
            stopWatch.start("差异写入差异库");
            save(diff);
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }

    }

    private static void save(Object diff) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
    }

    private static Object check(Object pos, Object dos) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return null;
    }

    private static Object getDOrders() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return null;
    }

    private static Object getPOrders() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return null;
    }
}
