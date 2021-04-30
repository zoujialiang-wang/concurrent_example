package threadPool.lock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * @version V1.0
 * @Package threadPool.controller
 * @auther ZouJiaLiang
 * @data 2021/4/25 下午6:46
 */

@RestController
public class TestController {
    @GetMapping("/test")
    public void test() throws InterruptedException {
        CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(2);
        Account2 Account2 = new Account2(200);
        Account2 Account22 = new Account2(200);
        Account2 Account23 = new Account2(200);
        new Thread(() -> {
            Account2.transfer(Account22, 100);
            COUNT_DOWN_LATCH.countDown();
        }).start();
        new Thread(() -> {
            Account22.transfer(Account2, 100);
            COUNT_DOWN_LATCH.countDown();
        }).start();
        COUNT_DOWN_LATCH.await();
        if (Account22.getBalance() != 200) {
            System.out.println("用户1:" + Account2.getBalance() + "      用户2:" + Account22.getBalance() + "        用户3:" + Account23.getBalance());
        }
    }
}
