package threadPool;


import threadPool.util.CommonExecutor;
import threadPool.util.ExecutorManager;

import javax.xml.crypto.Data;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @version V1.0
 * @Package threadPool
 * @auther ZouJiaLiang
 * @data 2021/4/8 上午11:50
 */
public class test {
    public static void main(String[] args) {
//        ExecutorService test = Executors.newScheduledThreadPool(4);
//
//        for (int i = 0; i < 10; i++) {
//            test.execute(() -> {
//                try {
//                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//
//        Map<String, ThreadPoolExecutor> allThreadPoolExecutor = ExecutorManager.getAllThreadPoolExecutor();
//        System.out.println(allThreadPoolExecutor.entrySet().stream().collect(Collectors.toMap(
//                (e) -> e.getKey(), e -> new HashMap(16) {{
//                    put("coolSize", e.getValue().getPoolSize());
//                    put("maxSize", e.getValue().getMaximumPoolSize());
//                    put("query", e.getValue().getQueue().size());
//                }}
//        )));
//
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        ThreadPoolExecutor test1 = ExecutorManager.getThreadPoolExecutor("test");
//        test1.setCorePoolSize(4);
//        test1.setMaximumPoolSize(8);
//        System.out.println(allThreadPoolExecutor.entrySet().stream().collect(Collectors.toMap(
//                (e) -> e.getKey(), e -> new HashMap(16) {{
//                    put("coolSize", e.getValue().getPoolSize());
//                    put("maxSize", e.getValue().getMaximumPoolSize());
//                    put("query", e.getValue().getQueue().size());
//                }}
//        )));

    }
}
